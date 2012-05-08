package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.Exceptions;
import com.github.nmorel.sickbeard.client.request.exceptions.ExceptionsShowRequest;
import com.github.nmorel.sickbeard.client.request.exceptions.ExceptionsShowsRequest;

public class ExceptionsImpl
    implements Exceptions
{
    private SickBeardConfig config;

    public ExceptionsImpl( SickBeardConfig config )
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
