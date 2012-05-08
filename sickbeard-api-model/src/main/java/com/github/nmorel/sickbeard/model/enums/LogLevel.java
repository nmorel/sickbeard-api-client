package com.github.nmorel.sickbeard.model.enums;

public enum LogLevel
{
    DEBUG( "debug" ), INFO( "info" ), WARNING( "warning" ), ERROR( "error" );

    private String identifier;

    private LogLevel( String identifier )
    {
        this.identifier = identifier;
    }

    public String getIdentifier()
    {
        return identifier;
    }
}
