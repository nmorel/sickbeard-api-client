package com.github.nmorel.sickbeard.client.request.shows;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.StandardRequest;
import com.github.nmorel.sickbeard.model.enums.ShowsSort;
import com.github.nmorel.sickbeard.model.result.Show;

public class ShowsDisplayRequest
    extends StandardRequest<List<Show>>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowsDisplayRequest.class );

    private static final String CMD_NAME = "shows";
    private static final String PARAM_PAUSED = "paused";
    private static final String PARAM_SORT = "sort";

    private ShowsSort currentSort = ShowsSort.ID;

    public ShowsDisplayRequest( SickBeardConfig config )
    {
        super( config, CMD_NAME );
    }

    @Override
    protected Logger getLogger()
    {
        return LOGGER;
    }

    @Override
    protected String getCommand()
    {
        return CMD_NAME;
    }

    /**
     * Only show the shows that are set to paused
     */
    public ShowsDisplayRequest setPaused( boolean paused )
    {
        setParameter( PARAM_PAUSED, convertBooleanParameter( paused ) );
        return this;
    }

    /**
     * Sort the list of shows by show name or tvdbid
     */
    public ShowsDisplayRequest setSort( ShowsSort sort )
    {
        currentSort = sort;
        setParameter( PARAM_SORT, sort.getIdentifier() );
        return this;
    }

    @Override
    protected List<Show> convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException
    {
        Map<String, Show.Builder> map = getConfig().getMapper().readValue( data.traverse(), new TypeReference<Map<String, Show.Builder>>()
        {
        } );

        List<Show> shows = new LinkedList<Show>();
        for ( Entry<String, Show.Builder> entry : map.entrySet() )
        {
            String key = entry.getKey();
            Show.Builder builder = entry.getValue();
            if ( ShowsSort.NAME.equals( currentSort ) )
            {
                builder.showName( key );
            }
            else
            {
                builder.tvdbId( key );
            }
            shows.add( builder.build() );
        }
        return Collections.unmodifiableList( shows );
    }
}
