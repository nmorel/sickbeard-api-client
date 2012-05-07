package com.github.nmorel.sickbeard.generator;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * SickBeard sometimes give "see desc" as an allowed value and not an array of values. This deserializer returns a
 * List<Object> for an array, null otherwise.
 *
 * @author Nicolas Morel
 */
public class AllowedValuesDeserializer
    extends JsonDeserializer<List<Object>>
{

    @Override
    public List<Object> deserialize( JsonParser jp, DeserializationContext ctxt )
        throws IOException, JsonProcessingException
    {
        try
        {
            return jp.readValueAs( new TypeReference<List<Object>>()
            {
            } );
        }
        catch ( JsonProcessingException e )
        {
        }
        catch ( IOException e )
        {
        }
        return null;
    }
}
