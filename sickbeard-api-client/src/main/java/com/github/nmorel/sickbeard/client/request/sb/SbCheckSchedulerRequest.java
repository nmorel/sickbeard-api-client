package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.Scheduler;

public class SbCheckSchedulerRequest
    extends SimpleRequest<Scheduler>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbCheckSchedulerRequest.class );

    private static final String CMD_NAME = "sb.checkscheduler";

    public SbCheckSchedulerRequest( SickBeardConfig config )
    {
        super( config, CMD_NAME );
    }

    @Override
    protected Logger getLogger()
    {
        return LOGGER;
    }

    @Override
    protected String getCommand()
    {
        return CMD_NAME;
    }

    @Override
    protected Class<Scheduler> getReturnType()
    {
        return Scheduler.class;
    }

}
