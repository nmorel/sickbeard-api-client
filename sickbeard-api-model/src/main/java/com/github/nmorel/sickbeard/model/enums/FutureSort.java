package com.github.nmorel.sickbeard.model.enums;

public enum FutureSort
{
    DATE( "date" ), SHOW( "show" ), NETWORK( "network" );

    private String identifier;

    private FutureSort( String identifier )
    {
        this.identifier = identifier;
    }

    public String getIdentifier()
    {
        return identifier;
    }

}
