package com.github.nmorel.sickbeard.client.exceptions;

public class SickBeardDeniedResultException
    extends SickBeardException
{
    private static final long serialVersionUID = -422664966492245415L;

    public SickBeardDeniedResultException( String message )
    {
        super( message );
    }
}
