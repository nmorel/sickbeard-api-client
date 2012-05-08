package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.logs.LogsRequest;

public interface LogsCommands
{
    /**
     * View SickBeard's log.
     */
    LogsRequest getLogs();
}
