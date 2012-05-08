package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.future.FutureDisplayRequest;

public interface FutureCommands
{
    /**
     * Display the upcoming episodes for the shows currently added in the users' database.
     */
    FutureDisplayRequest display();
}
