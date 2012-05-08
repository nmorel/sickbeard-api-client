package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.Episode;
import com.github.nmorel.sickbeard.client.request.episode.EpisodeDisplayRequest;
import com.github.nmorel.sickbeard.client.request.episode.EpisodeSearchRequest;
import com.github.nmorel.sickbeard.client.request.episode.EpisodeSetStatusRequest;
import com.github.nmorel.sickbeard.model.enums.Status;

public class EpisodeImpl
    implements Episode
{
    private SickBeardConfig config;

    public EpisodeImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public EpisodeDisplayRequest display( String tvdbid, int season, int episode )
    {
        return new EpisodeDisplayRequest( tvdbid, season, episode, config );
    }

    @Override
    public EpisodeSearchRequest search( String tvdbid, int season, int episode )
    {
        return new EpisodeSearchRequest( tvdbid, season, episode, config );
    }

    @Override
    public EpisodeSetStatusRequest setStatus( String tvdbid, int season, int episode, Status status )
    {
        return new EpisodeSetStatusRequest( tvdbid, season, episode, status, config );
    }
}
