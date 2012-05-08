package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;

public abstract class GenericMapRequest<K, V>
    extends StandardRequest<Map<K, V>>
{

    protected GenericMapRequest( SickBeardConfig config, String command )
    {
        super( config, command );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    protected Map<K, V> convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException
    {
        return Collections.unmodifiableMap( (Map<? extends K, ? extends V>) getConfig().getMapper().readValue( data.traverse(), getReturnType() ) );
    }

    /**
     * @return the return type
     */
    protected abstract TypeReference<?> getReturnType();

}
