package com.github.nmorel.sickbeard.client.request.sb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericRequest;
import com.github.nmorel.sickbeard.model.result.RootDir;

public class SbGetRootDirsRequest
    extends GenericRequest<List<RootDir>>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbGetRootDirsRequest.class );

    private static final String CMD_NAME = "sb.getrootdirs";

    public SbGetRootDirsRequest( SickBeardConfig config )
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
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<RootDir>>()
        {
        };
    }
}
