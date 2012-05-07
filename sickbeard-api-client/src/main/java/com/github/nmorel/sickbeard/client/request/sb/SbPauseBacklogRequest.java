package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;

public class SbPauseBacklogRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbPauseBacklogRequest.class );

    private static final String CMD_NAME = "sb.pausebacklog";
    private static final String PARAM_PAUSE = "pause";

    public SbPauseBacklogRequest( SickBeardConfig config )
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
     * Pause or unpause the global backlog
     *
     * @param pause true to pause, false to unpause. Default is false
     */
    public SbPauseBacklogRequest setPause( boolean pause )
    {
        setParameter( PARAM_PAUSE, convertBooleanParameter( pause ) );
        return this;
    }

}
