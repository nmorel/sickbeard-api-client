package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.Misc;

public class SbMiscRequest
    extends SimpleRequest<Misc>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbMiscRequest.class );

    private static final String CMD_NAME = "sb";

    public SbMiscRequest( SickBeardConfig config )
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
    protected Class<Misc> getReturnType()
    {
        return Misc.class;
    }
}
