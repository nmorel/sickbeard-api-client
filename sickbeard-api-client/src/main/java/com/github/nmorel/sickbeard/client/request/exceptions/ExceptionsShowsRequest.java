package com.github.nmorel.sickbeard.client.request.exceptions;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericMapRequest;

public class ExceptionsShowsRequest
    extends GenericMapRequest<String, List<String>>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ExceptionsShowsRequest.class );

    private static final String CMD_NAME = "exceptions";

    public ExceptionsShowsRequest( SickBeardConfig config )
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
        return new TypeReference<Map<String, List<String>>>() {};
    }
}
