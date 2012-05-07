package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;

public abstract class NoDataRequest
    extends StandardRequest<Void>
{

    protected NoDataRequest( SickBeardConfig config, String command )
    {
        super( config, command );
    }

    @Override
    protected Void convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException
    {
        return null;
    }

}
