package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;

public class SbShutdownRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbShutdownRequest.class );

    private static final String CMD_NAME = "sb.shutdown";

    public SbShutdownRequest( SickBeardConfig config )
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
