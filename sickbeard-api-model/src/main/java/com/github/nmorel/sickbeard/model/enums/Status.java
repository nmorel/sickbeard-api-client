package com.github.nmorel.sickbeard.model.enums;

public enum Status
{
    WANTED( "wanted" ), SKIPPED( "skipped" ), ARCHIVED( "archived" ), IGNORED( "ignored" );

    private String paramId;

    private Status( String paramId )
    {
        this.paramId = paramId;
    }

    public String getParamId()
    {
        return paramId;
    }
}
