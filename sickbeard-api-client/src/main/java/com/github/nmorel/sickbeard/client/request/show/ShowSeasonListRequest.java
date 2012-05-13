package com.github.nmorel.sickbeard.client.request.show;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;

public class ShowSeasonListRequest
    extends GenericListRequest<Integer>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowSeasonListRequest.class );

    private static final String CMD_NAME = "show.seasonlist";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_SORT = "sort";
    private static final String PARAM_SORT_ASC = "asc";
    private static final String PARAM_SORT_DESC = "desc";

    public ShowSeasonListRequest( String tvdbid, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == tvdbid )
        {
            throw new IllegalArgumentException( "tvdbid is required" );
        }
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

    /**
     * Change the sort order from descending to ascending
     */
    public ShowSeasonListRequest setAscending( boolean ascending )
    {
        if ( ascending )
        {
            setParameter( PARAM_SORT, PARAM_SORT_ASC );
        }
        else
        {
            setParameter( PARAM_SORT, PARAM_SORT_DESC );
        }
        return this;
    }

    @Override
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<Integer>>() {};
    }
}
