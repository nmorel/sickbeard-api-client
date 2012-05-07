package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.Ping;

public class SbPingRequest
    extends SimpleRequest<Ping>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbPingRequest.class );

    private static final String CMD_NAME = "sb.ping";

    public SbPingRequest( SickBeardConfig config )
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

    @Override
    protected Class<Ping> getReturnType()
    {
        return Ping.class;
    }

}
