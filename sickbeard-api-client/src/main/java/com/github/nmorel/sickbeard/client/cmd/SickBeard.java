package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.sb.SbGetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetMessagesRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbGetRootDirsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPauseBacklogRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbPingRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbRestartRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSearchTvdbRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbSetDefaultsRequest;
import com.github.nmorel.sickbeard.client.request.sb.SbShutdownRequest;

public interface SickBeard
{
    /**
     * Get default settings from SickBeard's config.
     */
    SbGetDefaultsRequest getDefaults();

    /**
     * Get un-claimed messages from the ui.notification queue.
     */
    SbGetMessagesRequest getMessages();

    /**
     * Get the root (parent) directories from SickBeard's config, test if valid, and which is the default.
     */
    SbGetRootDirsRequest getRootDirs();

    /**
     * Pause the backlog search.
     */
    SbPauseBacklogRequest pauseBacklog();

    /**
     * Check to see if SickBeard is running.
     */
    SbPingRequest ping();

    /**
     * Restart SickBeard.
     */
    SbRestartRequest restart();

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
