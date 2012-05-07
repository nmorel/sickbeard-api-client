package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.SickBeard;
import com.github.nmorel.sickbeard.client.request.sb.SbPauseBacklogRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPingRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSearchTvdbRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbShutdownRequest;

public class SickBeardImpl
    implements SickBeard
{
    private SickBeardConfig config;

    public SickBeardImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public SbPauseBacklogRequest pauseBacklog()
    {
        return new SbPauseBacklogRequest( config );
    }

    @Override
    public SbPingRequest ping()
    {
        return new SbPingRequest( config );
    }

    @Override
    public SbSearchTvdbRequest searchTvdb()
    {
        return new SbSearchTvdbRequest( config );
    }

    @Override
    public SbSetDefaultsRequest setDefaults()
    {
        return new SbSetDefaultsRequest( config );
    }

    @Override
    public SbShutdownRequest shutdown()
    {
        return new SbShutdownRequest( config );
    }
}
