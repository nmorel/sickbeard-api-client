package com.github.nmorel.sickbeard.client.request.sb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;
import com.github.nmorel.sickbeard.model.result.Message;

public class SbGetMessagesRequest
    extends GenericListRequest<Message>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbGetMessagesRequest.class );

    private static final String CMD_NAME = "sb.getmessages";

    public SbGetMessagesRequest( SickBeardConfig config )
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
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<Message>>()
        {
        };
    }
}
