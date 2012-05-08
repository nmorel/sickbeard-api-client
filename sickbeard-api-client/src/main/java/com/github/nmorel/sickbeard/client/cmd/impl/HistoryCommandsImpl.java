package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.HistoryCommands;
import com.github.nmorel.sickbeard.client.request.history.HistoryClearRequest;
import com.github.nmorel.sickbeard.client.request.history.HistoryDisplayRequest;
import com.github.nmorel.sickbeard.client.request.history.HistoryTrimRequest;

public class HistoryCommandsImpl
    implements HistoryCommands
{
    private SickBeardConfig config;

    public HistoryCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public HistoryDisplayRequest display()
    {
        return new HistoryDisplayRequest( config );
    }

    @Override
    public HistoryClearRequest clear()
    {
        return new HistoryClearRequest( config );
    }

    @Override
    public HistoryTrimRequest trim()
    {
        return new HistoryTrimRequest( config );
    }

}
