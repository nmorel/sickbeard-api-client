package com.github.nmorel.sickbeard.model.enums;

public enum ResultEnum
{
    SUCCESS( "success" ), FAILURE( "failure" ), TIMEOUT( "timeout" ), ERROR( "error" ), FATAL( "fatal" ), DENIED_RESULT( "denied result" );

    private String identifier;

    private ResultEnum( String identifier )
    {
        this.identifier = identifier;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public static ResultEnum fromIdentifier( String identifier )
    {
        for ( ResultEnum result : values() )
        {
            if ( result.getIdentifier().equalsIgnoreCase( identifier ) )
            {
                return result;
            }
        }
        return SUCCESS;
    }

}
