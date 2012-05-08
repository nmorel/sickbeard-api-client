package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;

/**
 * Parent request to all request
 *
 * @author Nicolas Morel
 * @param <T> Type of the result
 */
public abstract class AbstractRequest<T>
    implements Request<T>
{
    private static final String PARAM_CMD = "cmd";

    private SickBeardConfig config;

    private PostMethod method;

    protected AbstractRequest( SickBeardConfig config, String command )
    {
        this.config = config;
        this.method = new PostMethod( config.getUrl() );
        setParameter( PARAM_CMD, command );
    }

    /**
     * @return a logger
     */
    protected abstract Logger getLogger();

    /**
     * @return the command's name
     */
    protected abstract String getCommand();

    /**
     * @return SickBeard configuration
     */
    protected SickBeardConfig getConfig()
    {
        return config;
    }

    /**
     * Set a query parameter
     *
     * @param key Key of the parameter
     * @param value Value of the parameter
     */
    protected void setParameter( String key, String value )
    {
        method.setParameter( key, value );
    }

    protected String convertBooleanParameter( boolean value )
    {
        return value ? "1" : "0";
    }

    @Override
    public T call()
        throws SickBeardException
    {
        try
        {

            getLogger().debug( "Calling SickBeard command '{}' with parameters : {}", getCommand(), method.getParameters() );

            InputStream stream;

            try
            {
                getConfig().getClient().executeMethod( method );
                stream = method.getResponseBodyAsStream();
            }
            catch ( HttpException e )
            {
                String message = "Error calling SickBeard";
                getLogger().error( message, e );
                throw new SickBeardException( message, e );
            }
            catch ( IOException e )
            {
                String message = "Error calling SickBeard";
                getLogger().error( message, e );
                throw new SickBeardException( message, e );
            }

            getLogger().debug( "Call successful. Handling the response" );
            T response = handleResponse( stream );
            getLogger().debug( "Response handled" );
            return response;

        }
        catch ( SickBeardException e )
        {
            throw e;
        }
        catch ( Exception e )
        {
            String message = "Unexpected error";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }
    }

    /**
     * Convert the response stream
     *
     * @param response stream of the call's response
     * @return the converted response
     * @throws SickBeardException
     */
    protected abstract T handleResponse( InputStream response )
        throws SickBeardException;
}
