package com.github.nmorel.sickbeard.client.request.show;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.StandardRequest;
import com.github.nmorel.sickbeard.model.result.DetailedShow;

public class ShowDisplayRequest
    extends StandardRequest<DetailedShow>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowDisplayRequest.class );

    private static final String CMD_NAME = "show";
    private static final String PARAM_TVDBID = "tvdbid";

    private String tvdbid;

    public ShowDisplayRequest( String tvdbid, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == tvdbid )
        {
            throw new IllegalArgumentException( "tvdbid is required" );
        }
        this.tvdbid = tvdbid;
        setParameter( PARAM_TVDBID, tvdbid );
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

    @Override
    protected DetailedShow convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException
    {
        DetailedShow.Builder builder = getConfig().getMapper().readValue( data.traverse(), DetailedShow.Builder.class );
        builder.tvdbId( tvdbid );
        return builder.build();
    }
}
