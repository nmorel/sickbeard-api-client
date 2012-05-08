package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.shows.ShowsDisplayRequest;
import com.github.nmorel.sickbeard.client.request.shows.ShowsStatsRequest;

public interface ShowsCommands
{
    /**
     * Display all shows in SickBeard.
     */
    ShowsDisplayRequest display();

    /**
     * Display global episode and show statistics.
     */
    ShowsStatsRequest stats();
}
