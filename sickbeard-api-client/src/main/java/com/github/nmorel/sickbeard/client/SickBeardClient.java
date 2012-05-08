package com.github.nmorel.sickbeard.client;

import com.github.nmorel.sickbeard.client.cmd.EpisodeCommands;
import com.github.nmorel.sickbeard.client.cmd.ExceptionsCommands;
import com.github.nmorel.sickbeard.client.cmd.FutureCommands;
import com.github.nmorel.sickbeard.client.cmd.SickBeardCommands;
import com.github.nmorel.sickbeard.client.cmd.impl.EpisodeCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.ExceptionsCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.FutureCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.SickBeardCommandsImpl;

public class SickBeardClient
{
    private SickBeardConfig config;

    private SickBeardCommands sb;

    private EpisodeCommands episode;

    private ExceptionsCommands exceptions;

    private FutureCommands future;

    public SickBeardClient( String url )
    {
        this( new SickBeardConfig.Builder().withUrl( url ).build() );
    }

    public SickBeardClient( SickBeardConfig config )
    {
        this.config = config;
    }

    public SickBeardCommands sb()
    {
        if ( null == sb )
        {
            sb = new SickBeardCommandsImpl( config );
        }
        return sb;
    }

    public EpisodeCommands episode()
    {
        if ( null == episode )
        {
            episode = new EpisodeCommandsImpl( config );
        }
        return episode;
    }

    public ExceptionsCommands exceptions()
    {
        if ( null == exceptions )
        {
            exceptions = new ExceptionsCommandsImpl( config );
        }
        return exceptions;
    }

    public FutureCommands future()
    {
        if ( null == future )
        {
            future = new FutureCommandsImpl( config );
        }
        return future;
    }

}
