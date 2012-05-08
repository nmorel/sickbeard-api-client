package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.ExceptionsCommands;
import com.github.nmorel.sickbeard.client.request.exceptions.ExceptionsShowRequest;
import com.github.nmorel.sickbeard.client.request.exceptions.ExceptionsShowsRequest;

public class ExceptionsCommandsImpl
    implements ExceptionsCommands
{
    private SickBeardConfig config;

    public ExceptionsCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public ExceptionsShowRequest show( String tvdbid )
    {
        return new ExceptionsShowRequest( tvdbid, config );
    }

    @Override
    public ExceptionsShowsRequest shows()
    {
        return new ExceptionsShowsRequest( config );
    }
}
