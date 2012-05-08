package com.github.nmorel.sickbeard.client.cmd;

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

public interface SickBeardCommands
{
    /**
     * Display misc SickBeard related information. This is also the default command that the api will show if none is
     * specified.
     */
    SbMiscRequest misc();

    /**
     * Add a root (parent) directory (only if it is a valid location), and set as the default root dir if requested to
     * SickBeard's config.
     *
     * @param location full path to a root (parent) directory of tv shows
     */
    SbAddRootDirRequest addRootDir( String location );

    /**
     * Query the SickBeard scheduler.
     */
    SbCheckSchedulerRequest checkScheduler();

    /**
     * Delete a root (parent) directory from the root directory list in SickBeard's config.
     *
     * @param location the full path to root (parent) directory
     */
    SbDeleteRootDirRequest deleteRootDir( String location );

    /**
     * Force the episode search early.
     */
    SbForceSearchRequest forceSearch();

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
