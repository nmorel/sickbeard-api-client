package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;

public abstract class SimpleRequest<T>
    extends StandardRequest<T>
{

    protected SimpleRequest( SickBeardConfig config, String command )
    {
        super( config, command );
    }

    @Override
    protected T convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException
    {
        return getConfig().getMapper().readValue( data.traverse(), getReturnType() );
    }

    /**
     * @return the return type
     */
    protected abstract Class<T> getReturnType();

}
