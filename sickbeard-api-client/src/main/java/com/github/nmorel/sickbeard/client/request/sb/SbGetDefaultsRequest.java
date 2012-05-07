package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.Defaults;

public class SbGetDefaultsRequest
    extends SimpleRequest<Defaults>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbGetDefaultsRequest.class );

    private static final String CMD_NAME = "sb.getdefaults";

    public SbGetDefaultsRequest( SickBeardConfig config )
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
    protected Class<Defaults> getReturnType()
    {
        return Defaults.class;
    }

}
