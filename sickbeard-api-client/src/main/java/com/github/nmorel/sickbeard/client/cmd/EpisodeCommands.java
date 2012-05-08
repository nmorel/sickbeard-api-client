package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.episode.EpisodeDisplayRequest;
import com.github.nmorel.sickbeard.client.request.episode.EpisodeSearchRequest;
import com.github.nmorel.sickbeard.client.request.episode.EpisodeSetStatusRequest;
import com.github.nmorel.sickbeard.model.enums.Status;

public interface EpisodeCommands
{
    /**
     * Displays the information of a specific episode matching the corresponding tvdbid, season and episode number.
     *
     * @param tvdbid tvdbid unique show id
     * @param season season number
     * @param episode episode number
     */
    EpisodeDisplayRequest display( String tvdbid, int season, int episode );

    /**
     * Initiate a search for a specific episode matching the corresponding tvdbid, season and episode number.
     *
     * @param tvdbid tvdbid unique show id
     * @param season season number
     * @param episode episode number
     */
    EpisodeSearchRequest search( String tvdbid, int season, int episode );

    /**
     * Set the status of an episode.
     *
     * @param tvdbid tvdbid unique show id
     * @param season season number
     * @param episode episode number
     * @param status wanted, skipped, archived or ignored
     */
    EpisodeSetStatusRequest setStatus( String tvdbid, int season, int episode, Status status );
}
