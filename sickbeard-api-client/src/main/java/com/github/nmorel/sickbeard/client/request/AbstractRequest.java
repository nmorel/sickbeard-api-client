package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
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

    private Map<String, String> parameters;

    protected AbstractRequest( SickBeardConfig config, String command )
    {
        this.config = config;
        this.parameters = new LinkedHashMap<String, String>();
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
        this.parameters.put( key, value );
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
            getLogger().debug( "Calling SickBeard command '{}' with parameters : {}", getCommand(), parameters );

            HttpPost request = new HttpPost( config.getUrl() );
            List<NameValuePair> nameValuePairs = new LinkedList<NameValuePair>();
            for ( Entry<String, String> parameter : parameters.entrySet() )
            {
                nameValuePairs.add( new BasicNameValuePair( parameter.getKey(), parameter.getValue() ) );
            }
            request.setEntity( new UrlEncodedFormEntity( nameValuePairs ) );

            InputStream stream = null;
            try
            {
                HttpResponse response = getConfig().getClient().execute( request );
                stream = response.getEntity().getContent();
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
