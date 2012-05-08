package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.ShowsCommands;
import com.github.nmorel.sickbeard.client.request.shows.ShowsDisplayRequest;
import com.github.nmorel.sickbeard.client.request.shows.ShowsStatsRequest;

public class ShowsCommandsImpl
    implements ShowsCommands
{
    private SickBeardConfig config;

    public ShowsCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public ShowsDisplayRequest display()
    {
        return new ShowsDisplayRequest( config );
    }

    @Override
    public ShowsStatsRequest stats()
    {
        return new ShowsStatsRequest( config );
    }
}
