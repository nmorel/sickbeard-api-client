package com.github.nmorel.sickbeard.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.nmorel.sickbeard.model.deserializer.QualityDeserializer;

@JsonDeserialize( using = QualityDeserializer.class )
public enum Quality
{
    SD_TV( "sdtv" ), SD_DVD( "sddvd" ), HD_TV( "hdtv" ), HD_WEB_DL( "hdwebdl" ), HD_BR( "hdbluray" ), FULL_HD_BR( "fullhdbluray" ), UNKNOWN(
        "unknown" ), ANY( "any" );

    private String sickBeardValue;

    private Quality( String sickBeardValue )
    {
        this.sickBeardValue = sickBeardValue;
    }

    public String getSickBeardValue()
    {
        return sickBeardValue;
    }

    public static Quality fromSickBeardValue( String sickBeardValue )
    {
        if ( null != sickBeardValue )
        {
            for ( Quality quality : values() )
            {
                if ( quality.getSickBeardValue().equalsIgnoreCase( sickBeardValue ) )
                {
                    return quality;
                }
            }
        }
        return null;
    }
}
