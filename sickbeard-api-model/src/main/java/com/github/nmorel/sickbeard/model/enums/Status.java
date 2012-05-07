package com.github.nmorel.sickbeard.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.nmorel.sickbeard.model.deserializer.StatusDeserializer;

@JsonDeserialize( using = StatusDeserializer.class )
public enum Status
{
    WANTED( "wanted" ), SKIPPED( "skipped" ), ARCHIVED( "archived" ), IGNORED( "ignored" );

    private String sickBeardValue;

    private Status( String sickBeardValue )
    {
        this.sickBeardValue = sickBeardValue;
    }

    public String getSickBeardValue()
    {
        return sickBeardValue;
    }

    public static Status fromSickBeardValue( String sickBeardValue )
    {
        if ( null != sickBeardValue )
        {
            for ( Status status : values() )
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
