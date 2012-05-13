package com.github.nmorel.sickbeard.client.exceptions;

public class SickBeardTimeoutException
    extends SickBeardException
{
    private static final long serialVersionUID = -8350312478455792573L;

    public SickBeardTimeoutException( String message )
    {
        super( message );
    }
}
