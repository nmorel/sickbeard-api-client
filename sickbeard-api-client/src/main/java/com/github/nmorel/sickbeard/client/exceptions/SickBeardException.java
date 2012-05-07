package com.github.nmorel.sickbeard.client.exceptions;

public class SickBeardException
    extends Exception
{
    public SickBeardException( String message )
    {
        super( message );
    }

    public SickBeardException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
