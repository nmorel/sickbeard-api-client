package com.github.nmorel.sickbeard.client.cmd.impl;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.cmd.ShowCommands;
import com.github.nmorel.sickbeard.client.request.show.ShowAddExistingRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowAddNewRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowCacheRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowDeleteRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowDisplayRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowGetBannerRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowGetPosterRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowGetQualityRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowPauseRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowRefreshRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowSeasonListRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowSeasonRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowSeasonsRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowSetQualityRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowStatsRequest;
import com.github.nmorel.sickbeard.client.request.show.ShowUpdateRequest;

public class ShowCommandsImpl
    implements ShowCommands
{
    private SickBeardConfig config;

    public ShowCommandsImpl( SickBeardConfig config )
    {
        this.config = config;
    }

    @Override
    public ShowDisplayRequest display( String tvdbid )
    {
        return new ShowDisplayRequest( tvdbid, config );
    }

    @Override
    public ShowAddExistingRequest addExisting( String tvdbid, String location )
    {
        return new ShowAddExistingRequest( tvdbid, location, config );
    }

    @Override
    public ShowAddNewRequest addNew( String tvdbid )
    {
        return new ShowAddNewRequest( tvdbid, config );
    }

    @Override
    public ShowCacheRequest cache( String tvdbid )
    {
        return new ShowCacheRequest( tvdbid, config );
    }

    @Override
    public ShowDeleteRequest delete( String tvdbid )
    {
        return new ShowDeleteRequest( tvdbid, config );
    }

    @Override
    public ShowGetBannerRequest getBanner( String tvdbid )
    {
        return new ShowGetBannerRequest( tvdbid, config );
    }

    @Override
    public ShowGetPosterRequest getPoster( String tvdbid )
    {
        return new ShowGetPosterRequest( tvdbid, config );
    }

    @Override
    public ShowGetQualityRequest getQuality( String tvdbid )
    {
        return new ShowGetQualityRequest( tvdbid, config );
    }

    @Override
    public ShowPauseRequest pause( String tvdbid )
    {
        return new ShowPauseRequest( tvdbid, config );
    }

    @Override
    public ShowRefreshRequest refresh( String tvdbid )
    {
        return new ShowRefreshRequest( tvdbid, config );
    }

    @Override
    public ShowSeasonListRequest seasonList( String tvdbid )
    {
        return new ShowSeasonListRequest( tvdbid, config );
    }

    @Override
    public ShowSeasonRequest season( String tvdbid, int season )
    {
        return new ShowSeasonRequest( tvdbid, season, config );
    }

    @Override
    public ShowSeasonsRequest seasons( String tvdbid )
    {
        return new ShowSeasonsRequest( tvdbid, config );
    }

    @Override
    public ShowSetQualityRequest setQuality( String tvdbid )
    {
        return new ShowSetQualityRequest( tvdbid, config );
    }

    @Override
    public ShowStatsRequest stats( String tvdbid )
    {
        return new ShowStatsRequest( tvdbid, config );
    }

    @Override
    public ShowUpdateRequest update( String tvdbid )
    {
        return new ShowUpdateRequest( tvdbid, config );
    }
}
