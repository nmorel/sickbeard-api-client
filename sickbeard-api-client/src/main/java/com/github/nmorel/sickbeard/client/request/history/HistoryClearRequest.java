package com.github.nmorel.sickbeard.client.request.history;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;

public class HistoryClearRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( HistoryClearRequest.class );

    private static final String CMD_NAME = "history.clear";

    public HistoryClearRequest( SickBeardConfig config )
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
