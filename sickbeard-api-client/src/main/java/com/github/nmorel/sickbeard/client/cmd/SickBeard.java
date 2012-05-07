package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.sb.SbPauseBacklogRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPingRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSearchTvdbRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbShutdownRequest;

public interface SickBeard
{
    /**
     * Pause the backlog search.
     */
    SbPauseBacklogRequest pauseBacklog();

    /**
     * Check to see if SickBeard is running.
     */
    SbPingRequest ping();

    /**
     * Search TVDB for a show with a given string or tvdbid.
     */
    SbSearchTvdbRequest searchTvdb();

    /**
     * Set default settings for SickBeard.
     */
    SbSetDefaultsRequest setDefaults();

    /**
     * Shutdown SickBeard.
     */
    SbShutdownRequest shutdown();
}
