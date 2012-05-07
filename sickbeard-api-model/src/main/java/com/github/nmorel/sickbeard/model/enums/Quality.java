package com.github.nmorel.sickbeard.model.enums;

public enum Quality
{
    SD_TV( "sdtv" ), SD_DVD( "sddvd" ), HD_TV( "hdtv" ), HD_WEB_DL( "hdwebdl" ), HD_BR( "hdbluray" ), FULL_HD_BR( "fullhdbluray" ), UNKNOWN(
        "unknown" ), ANY( "any" );

    private String paramId;

    private Quality( String paramId )
    {
        this.paramId = paramId;
    }

    public String getParamId()
    {
        return paramId;
    }
}
