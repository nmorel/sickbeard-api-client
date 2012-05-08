package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.FutureCommands;
import com.github.nmorel.sickbeard.client.request.future.FutureDisplayRequest;

public class FutureCommandsImpl
    implements FutureCommands
{
    private SickBeardConfig config;

    public FutureCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public FutureDisplayRequest display()
    {
        return new FutureDisplayRequest( config );
    }
}
