package com.github.nmorel.sickbeard.client;

import com.github.nmorel.sickbeard.client.cmd.Episode;
import com.github.nmorel.sickbeard.client.cmd.SickBeard;
import com.github.nmorel.sickbeard.client.cmd.impl.EpisodeImpl;
import com.github.nmorel.sickbeard.client.cmd.impl.SickBeardImpl;

public class SickBeardClient
{
    private SickBeardConfig config;

    private SickBeard sb;

    private Episode episode;

    public SickBeardClient( String url )
    {
        this( new SickBeardConfig.Builder().withUrl( url ).build() );
    }

    public SickBeardClient( SickBeardConfig config )
    {
        this.config = config;
    }

    public SickBeard sb()
    {
        if ( null == sb )
        {
            sb = new SickBeardImpl( config );
        }
        return sb;
    }

    public Episode episode()
    {
        if ( null == episode )
        {
            episode = new EpisodeImpl( config );
        }
        return episode;
    }

}
