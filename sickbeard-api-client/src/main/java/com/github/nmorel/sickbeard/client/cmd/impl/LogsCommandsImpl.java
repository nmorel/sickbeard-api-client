package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.LogsCommands;
import com.github.nmorel.sickbeard.client.request.logs.LogsRequest;

public class LogsCommandsImpl
    implements LogsCommands
{
    private SickBeardConfig config;

    public LogsCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public LogsRequest getLogs()
    {
        return new LogsRequest( config );
    }
}
