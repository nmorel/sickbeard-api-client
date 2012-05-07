package com.github.nmorel.sickbeard.client.request;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardDeniedResultException;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardErrorException;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardFailureException;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardFatalException;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardTimeoutException;
import com.github.nmorel.sickbeard.model.result.SickBeardResult;

/**
 * Request using the standard SickBeard result json object with data, message and result key.
 *
 * @author Nicolas Morel
 * @param <T> Type of the result
 */
public abstract class StandardRequest<T>
    extends AbstractRequest<T>
{

    protected StandardRequest( SickBeardConfig config, String command )
    {
        super( config, command );
    }

    @Override
    protected T handleResponse( InputStream response )
        throws SickBeardException
    {
        SickBeardResult result;
        try
        {
            result = getConfig().getMapper().readValue( response, SickBeardResult.class );
        }
        catch ( JsonParseException e )
        {
            String message = "Error while parsing the response";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }
        catch ( JsonMappingException e )
        {
            String message = "Error while parsing the response";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }
        catch ( IOException e )
        {
            String message = "Error while parsing the response";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }

        String message = result.getMessage();
        switch ( result.getResult() )
        {
            case DENIED_RESULT:
                getLogger().error( message );
                throw new SickBeardDeniedResultException( message );
            case FAILURE:
                getLogger().error( message );
                throw new SickBeardFailureException( message );
            case ERROR:
                getLogger().error( message );
                throw new SickBeardErrorException( message );
            case FATAL:
                getLogger().error( message );
                throw new SickBeardFatalException( message );
            case TIMEOUT:
                getLogger().error( message );
                throw new SickBeardTimeoutException( message );
            case SUCCESS:
            default:
                getLogger().debug( "Success : message={}, data={}", message, result.getData() );
                return doOnSuccess( result.getData() );
        }
    }

    /**
     * Use to convert the data into the result type. We don't convert it directly because sb can return a string into
     * data instead of value in case of an error.
     */
    protected T doOnSuccess( JsonNode data )
        throws SickBeardException
    {
        try
        {
            getLogger().debug( "Converting data to result" );
            T res = convertData( data );
            getLogger().debug( "Data converted : {}", res );
            return res;
        }
        catch ( JsonParseException e )
        {
            String message = "Error while parsing the data";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }
        catch ( JsonMappingException e )
        {
            String message = "Error while parsing the data";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }
        catch ( IOException e )
        {
            String message = "Error while parsing the data";
            getLogger().error( message, e );
            throw new SickBeardException( message, e );
        }
    }

    /**
     * Convert the data to the result type
     */
    protected abstract T convertData( JsonNode data )
        throws JsonParseException, JsonMappingException, IOException;
}
