package com.github.nmorel.sickbeard.client.cmd;

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

public interface ShowCommands
{
    /**
     * Display information for a given show
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowDisplayRequest display( String tvdbid );

    /**
     * Add a show to SickBeard using an existing folder.
     *
     * @param tvdbid tvdbid unique show id
     * @param location full path to the existing folder for the show
     */
    ShowAddExistingRequest addExisting( String tvdbid, String location );

    /**
     * Add a show to SickBeard providing the parent directory where the tv shows folder should be created.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowAddNewRequest addNew( String tvdbid );

    /**
     * Display if the poster/banner SickBeard's image cache is valid.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowCacheRequest cache( String tvdbid );

    /**
     * Delete a show from SickBeard.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowDeleteRequest delete( String tvdbid );

    /**
     * Retrieve the stored banner image from SickBeard's cache for a particular tvdbid. If no image is found then the
     * default sb banner is shown.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowGetBannerRequest getBanner( String tvdbid );

    /**
     * Retrieve the stored poster image from SickBeard's cache for a particular tvdbid. If no image is found then the
     * default sb poster is shown.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowGetPosterRequest getPoster( String tvdbid );

    /**
     * Get quality settings of a show in SickBeard.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowGetQualityRequest getQuality( String tvdbid );

    /**
     * Set a show's paused state in SickBeard.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowPauseRequest pause( String tvdbid );

    /**
     * Refresh a show in SickBeard by rescanning local files.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowRefreshRequest refresh( String tvdbid );

    /**
     * Display the season list for a given show.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowSeasonListRequest seasonList( String tvdbid );

    /**
     * Display a listing of episodes for a given season.
     *
     * @param tvdbid tvdbid unique show id
     * @param season season number
     */
    ShowSeasonRequest season( String tvdbid, int season );

    /**
     * Display a listing of episodes for all season.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowSeasonsRequest seasons( String tvdbid );

    /**
     * Set desired quality of a show in SickBeard.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowSetQualityRequest setQuality( String tvdbid );

    /**
     * Display episode statistics for a given show.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowStatsRequest stats( String tvdbid );

    /**
     * Update a show in SickBeard by pulling down information from TVDB and rescan local files.
     *
     * @param tvdbid tvdbid unique show id
     */
    ShowUpdateRequest update( String tvdbid );
}
