package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.history.HistoryClearRequest;
import com.github.nmorel.sickbeard.client.request.history.HistoryDisplayRequest;
import com.github.nmorel.sickbeard.client.request.history.HistoryTrimRequest;

public interface HistoryCommands
{
    /**
     * Display SickBeard's downloaded/snatched history.
     */
    HistoryDisplayRequest display();

    /**
     * Clear SickBeard's history.
     */
    HistoryClearRequest clear();

    /**
     * Trim SickBeard's history by removing entries greater than 30 days old.
     */
    HistoryTrimRequest trim();
}
