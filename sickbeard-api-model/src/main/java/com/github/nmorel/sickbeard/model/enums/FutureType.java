package com.github.nmorel.sickbeard.model.enums;

public enum FutureType
{
    MISSED( "missed" ), LATER( "later" ), TODAY( "today" ), SOON( "soon" );

    private String identifier;

    private FutureType( String identifier )
    {
        this.identifier = identifier;
    }

    public String getIdentifier()
    {
        return identifier;
    }

}
