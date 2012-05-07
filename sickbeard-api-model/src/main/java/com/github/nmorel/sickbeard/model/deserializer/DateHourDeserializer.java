package com.github.nmorel.sickbeard.model.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateHourDeserializer
    extends JsonDeserializer<Date>
{
    private static ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>()
    {
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        }
    };

    @Override
    public Date deserialize( JsonParser jp, DeserializationContext ctxt )
        throws IOException, JsonProcessingException
    {
        String value = jp.getText();
        if ( null == value || value.isEmpty() )
        {
            return null;
        }
        try
        {
            return formatter.get().parse( value );
        }
        catch ( ParseException e )
        {
            throw new JsonParseException( "Error parsing date from value : " + value, jp.getCurrentLocation(), e );
        }
    }

}
