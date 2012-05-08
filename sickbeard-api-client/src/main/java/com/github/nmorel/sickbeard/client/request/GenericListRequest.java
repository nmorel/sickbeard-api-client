package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;

public abstract class GenericListRequest<T>
    extends StandardRequest<List<T>>
{

    protected GenericListRequest( SickBeardConfig config, String command )
    {
        super( config, command );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    protected List<T> convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException
    {
        return Collections.unmodifiableList( (List<? extends T>) getConfig().getMapper().readValue( data.traverse(), getReturnType() ) );
    }

    /**
     * @return the return type
     */
    protected abstract TypeReference<?> getReturnType();

}
