package com.github.nmorel.sickbeard.client.request.logs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;
import com.github.nmorel.sickbeard.model.enums.LogLevel;

public class LogsRequest
    extends GenericListRequest<String>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( LogsRequest.class );

    private static final String CMD_NAME = "logs";
    private static final String PARAM_MIN_LEVEL = "min_level";

    public LogsRequest( SickBeardConfig config )
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
     * The minimum level classification of log entries to show, with each level inherting its above level
     */
    public LogsRequest setMinLevel( LogLevel level )
    {
        setParameter( PARAM_MIN_LEVEL, level.getIdentifier() );
        return this;
    }

    @Override
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<String>>() {};
    }
}
