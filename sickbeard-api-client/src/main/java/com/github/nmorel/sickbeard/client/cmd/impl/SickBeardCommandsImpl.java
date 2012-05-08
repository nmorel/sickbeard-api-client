package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.SickBeardCommands;
import com.github.nmorel.sickbeard.client.request.sb.SbAddRootDirRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbCheckSchedulerRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbDeleteRootDirRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbForceSearchRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetMessagesRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetRootDirsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbMiscRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPauseBacklogRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPingRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbRestartRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSearchTvdbRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbShutdownRequest;

public class SickBeardCommandsImpl
    implements SickBeardCommands
{
    private SickBeardConfig config;

    public SickBeardCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public SbMiscRequest misc()
    {
        return new SbMiscRequest( config );
    }

    @Override
    public SbAddRootDirRequest addRootDir( String location )
    {
        return new SbAddRootDirRequest( location, config );
    }

    @Override
    public SbCheckSchedulerRequest checkScheduler()
    {
        return new SbCheckSchedulerRequest( config );
    }

    @Override
    public SbDeleteRootDirRequest deleteRootDir( String location )
    {
        return new SbDeleteRootDirRequest( location, config );
    }

    @Override
    public SbForceSearchRequest forceSearch()
    {
        return new SbForceSearchRequest( config );
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
