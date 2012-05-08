package com.github.nmorel.sickbeard.client;

import com.github.nmorel.sickbeard.client.cmd.EpisodeCommands;
import com.github.nmorel.sickbeard.client.cmd.ExceptionsCommands;
import com.github.nmorel.sickbeard.client.cmd.FutureCommands;
import com.github.nmorel.sickbeard.client.cmd.HistoryCommands;
import com.github.nmorel.sickbeard.client.cmd.LogsCommands;
import com.github.nmorel.sickbeard.client.cmd.ShowsCommands;
import com.github.nmorel.sickbeard.client.cmd.SickBeardCommands;
import com.github.nmorel.sickbeard.client.cmd.impl.EpisodeCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.ExceptionsCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.FutureCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.HistoryCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.LogsCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.ShowsCommandsImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.SickBeardCommandsImpl;

public class SickBeardClient
{
    private SickBeardConfig config;

    private SickBeardCommands sb;

    private EpisodeCommands episode;

    private ExceptionsCommands exceptions;

    private FutureCommands future;

    private HistoryCommands history;

    private LogsCommands logs;

    private ShowsCommands shows;

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

    public HistoryCommands history()
    {
        if ( null == history )
        {
            history = new HistoryCommandsImpl( config );
        }
        return history;
    }

    public LogsCommands logs()
    {
        if ( null == logs )
        {
            logs = new LogsCommandsImpl( config );
        }
        return logs;
    }

    public ShowsCommands shows()
    {
        if ( null == shows )
        {
            shows = new ShowsCommandsImpl( config );
        }
        return shows;
    }

}
