package com.github.nmorel.sickbeard.client.request;

import java.io.InputStream;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;

/**
 * Request returning an image
 *
 * @author Nicolas Morel
 */
public abstract class ImageRequest
    extends AbstractRequest<InputStream>
{

    protected ImageRequest( SickBeardConfig config, String command )
    {
        super( config, command );
    }

    @Override
    protected InputStream handleResponse( InputStream response )
        throws SickBeardException
    {
        return response;
    }

}
