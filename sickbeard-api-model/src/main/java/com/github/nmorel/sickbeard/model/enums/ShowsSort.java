package com.github.nmorel.sickbeard.model.enums;

public enum ShowsSort
{
    ID( "id" ), NAME( "name" );

    private String identifier;

    private ShowsSort( String identifier )
    {
        this.identifier = identifier;
    }

    public String getIdentifier()
    {
        return identifier;
    }

}
