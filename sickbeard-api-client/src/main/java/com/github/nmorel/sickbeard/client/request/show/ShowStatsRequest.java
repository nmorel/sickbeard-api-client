package com.github.nmorel.sickbeard.client.request.show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.ShowStats;

public class ShowStatsRequest
    extends SimpleRequest<ShowStats>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowStatsRequest.class );

    private static final String CMD_NAME = "show.stats";
    private static final String PARAM_TVDBID = "tvdbid";

    public ShowStatsRequest( String tvdbid, SickBeardConfig config )
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

    @Override
    protected Class<ShowStats> getReturnType()
    {
        return ShowStats.class;
    }
}
