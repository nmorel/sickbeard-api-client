package com.github.nmorel.sickbeard.model.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.nmorel.sickbeard.model.enums.ShowStatus;

public class ShowStatusDeserializer
    extends JsonDeserializer<ShowStatus>
{
    @Override
    public ShowStatus deserialize( JsonParser jp, DeserializationContext ctxt )
        throws IOException, JsonProcessingException
    {
        String value = jp.getText();
        if ( null == value || value.isEmpty() )
        {
            return null;
        }
        return ShowStatus.fromSickBeardValue( value );
    }
}
