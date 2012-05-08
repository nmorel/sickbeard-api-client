package com.github.nmorel.sickbeard.model.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.nmorel.sickbeard.model.deserializer.QualityDeserializer;

@JsonDeserialize( using = QualityDeserializer.class )
public enum Quality
{
    SD_TV( "sdtv", "SD TV" ), SD_DVD( "sddvd", "SD DVD" ), HD_TV( "hdtv", "HD TV" ), HD_WEB_DL( "hdwebdl", "720p WEB-DL" ), HD_BR( "hdbluray",
        "720p BluRay" ), FULL_HD_BR( "fullhdbluray", "1080p BluRay" ), UNKNOWN( "unknown", "N/A" ), CUSTOM( "custom", "Custom" ), SD( "sd", "SD" ),
    HD( "hd", "HD" ), ANY( "any", "Any" );

    private String identifier;

    private String label;

    private Quality( String identifier, String label )
    {
        this.identifier = identifier;
        this.label = label;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public String getLabel()
    {
        return label;
    }

    public static Quality fromIdentifierOrLabel( String identifierOrLabel )
    {
        if ( null != identifierOrLabel )
        {
            for ( Quality quality : values() )
            {
                if ( quality.getIdentifier().equalsIgnoreCase( identifierOrLabel ) || quality.getLabel().equalsIgnoreCase( identifierOrLabel ) )
                {
                    return quality;
                }
            }
        }
        return UNKNOWN;
    }

    public static Quality fromIdentifier( String identifier )
    {
        if ( null != identifier )
        {
            for ( Quality quality : values() )
            {
                if ( quality.getIdentifier().equalsIgnoreCase( identifier ) )
                {
                    return quality;
                }
            }
        }
        return UNKNOWN;
    }

    public static Quality fromLabel( String label )
    {
        if ( null != label )
        {
            for ( Quality quality : values() )
            {
                if ( quality.getLabel().equalsIgnoreCase( label ) )
                {
                    return quality;
                }
            }
        }
        return UNKNOWN;
    }
}
