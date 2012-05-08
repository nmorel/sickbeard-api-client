package com.github.nmorel.sickbeard.client.cmd;

import com.github.nmorel.sickbeard.client.request.exceptions.ExceptionsShowRequest;
import com.github.nmorel.sickbeard.client.request.exceptions.ExceptionsShowsRequest;

public interface ExceptionsCommands
{
    /**
     * Display scene exceptions for a given show.
     *
     * @param tvdbid tvdbid unique show id
     */
    ExceptionsShowRequest show( String tvdbid );

    /**
     * Display scene exceptions for all show.
     */
    ExceptionsShowsRequest shows();
}
