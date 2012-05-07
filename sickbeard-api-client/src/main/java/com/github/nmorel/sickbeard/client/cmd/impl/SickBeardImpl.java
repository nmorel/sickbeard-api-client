package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.SickBeard;
import com.github.nmorel.sickbeard.client.request.sb.SbGetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetMessagesRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetRootDirsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPauseBacklogRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPingRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbRestartRequest;
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
    public SbGetDefaultsRequest getDefaults()
    {
        return new SbGetDefaultsRequest( config );
    }

    @Override
    public SbGetMessagesRequest getMessages()
    {
        return new SbGetMessagesRequest( config );
    }

    @Override
    public SbGetRootDirsRequest getRootDirs()
    {
        return new SbGetRootDirsRequest( config );
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
    public SbRestartRequest restart()
    {
        return new SbRestartRequest( config );
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
