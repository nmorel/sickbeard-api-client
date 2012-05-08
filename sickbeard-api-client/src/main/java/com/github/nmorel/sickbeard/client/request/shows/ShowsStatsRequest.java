package com.github.nmorel.sickbeard.client.request.shows;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.ShowsStats;

public class ShowsStatsRequest
    extends SimpleRequest<ShowsStats>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowsStatsRequest.class );

    private static final String CMD_NAME = "shows.stats";

    public ShowsStatsRequest( SickBeardConfig config )
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
    protected Class<ShowsStats> getReturnType()
    {
        return ShowsStats.class;
    }
}
