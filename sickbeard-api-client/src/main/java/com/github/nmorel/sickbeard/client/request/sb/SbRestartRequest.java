package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;

public class SbRestartRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbRestartRequest.class );

    private static final String CMD_NAME = "sb.restart";

    public SbRestartRequest( SickBeardConfig config )
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
}
