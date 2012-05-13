package com.github.nmorel.sickbeard.client.exceptions;

public class SickBeardFailureException
    extends SickBeardException
{
    private static final long serialVersionUID = 8071971609614470802L;

    public SickBeardFailureException( String message )
    {
        super( message );
    }
}
