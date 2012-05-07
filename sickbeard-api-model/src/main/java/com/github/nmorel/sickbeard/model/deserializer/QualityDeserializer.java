package com.github.nmorel.sickbeard.model.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.nmorel.sickbeard.model.enums.Quality;

public class QualityDeserializer
    extends JsonDeserializer<Quality>
{

    @Override
    public Quality deserialize( JsonParser jp, DeserializationContext ctxt )
        throws IOException, JsonProcessingException
    {
        return Quality.fromSickBeardValue( jp.getText() );
    }

}
