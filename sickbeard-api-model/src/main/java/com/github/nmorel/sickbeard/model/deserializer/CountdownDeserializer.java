package com.github.nmorel.sickbeard.model.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CountdownDeserializer
    extends JsonDeserializer<Date>
{
    private static ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>()
    {
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat( "HH:mm:ss" );
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
            Calendar current = Calendar.getInstance();
            Calendar countdown = Calendar.getInstance();
            countdown.setTime( formatter.get().parse( value ) );
            current.add( Calendar.HOUR_OF_DAY, -countdown.get( Calendar.HOUR_OF_DAY ) );
            current.add( Calendar.MINUTE, -countdown.get( Calendar.MINUTE ) );
            current.add( Calendar.SECOND, -countdown.get( Calendar.SECOND ) );
            return current.getTime();
        }
        catch ( ParseException e )
        {
            throw new JsonParseException( "Error parsing date from value : " + value, jp.getCurrentLocation(), e );
        }
    }

}
