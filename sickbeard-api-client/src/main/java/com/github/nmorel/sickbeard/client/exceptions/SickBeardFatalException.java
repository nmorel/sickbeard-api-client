package com.github.nmorel.sickbeard.client.exceptions;

public class SickBeardFatalException
    extends SickBeardException
{
    private static final long serialVersionUID = -2922950708927442016L;

    public SickBeardFatalException( String message )
    {
        super( message );
    }
}
