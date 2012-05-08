package com.github.nmorel.sickbeard.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.nmorel.sickbeard.model.deserializer.ShowStatusDeserializer;

@JsonDeserialize( using = ShowStatusDeserializer.class )
public enum ShowStatus
{
    CONTINUING( "continuing" ), ENDED( "ended" );

    private String sickBeardValue;

    private ShowStatus( String sickBeardValue )
    {
        this.sickBeardValue = sickBeardValue;
    }

    public String getSickBeardValue()
    {
        return sickBeardValue;
    }

    public static ShowStatus fromSickBeardValue( String sickBeardValue )
    {
        if ( null != sickBeardValue )
        {
            for ( ShowStatus status : values() )
            {
                if ( status.getSickBeardValue().equalsIgnoreCase( sickBeardValue ) )
                {
                    return status;
                }
            }
        }
        return null;
    }
}
