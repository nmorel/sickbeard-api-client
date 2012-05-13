package com.github.nmorel.sickbeard.client.exceptions;

public class SickBeardException
    extends Exception
{
    private static final long serialVersionUID = 244507117974123022L;

    public SickBeardException( String message )
    {
        super( message );
    }

    public SickBeardException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
