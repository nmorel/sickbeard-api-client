package com.github.nmorel.sickbeard.client.request.history;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.History;

public class HistoryDisplayRequest
    extends GenericListRequest<History>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( HistoryDisplayRequest.class );

    private static final String CMD_NAME = "history";
    private static final String PARAM_LIMIT = "limit";
    private static final String PARAM_TYPE = "type";

    public HistoryDisplayRequest( SickBeardConfig config )
    {
        super( config, CMD_NAME );
    }

    @Override
    protected Logger getLogger()
    {
        return LOGGER;
    }

    @Override
    protected String getCommand()
    {
        return CMD_NAME;
    }

    /**
     * There is an artificial max limit of 100 currently imposed for the limit command to ensure performance.
     */
    public HistoryDisplayRequest setLimit( int limit )
    {
        setParameter( PARAM_LIMIT, Integer.toString( limit ) );
        return this;
    }

    /**
     * Only show a specific type of results
     */
    public HistoryDisplayRequest setType( Status type )
    {
        if ( !Status.DOWNLOADED.equals( type ) && !Status.SNATCHED.equals( type ) )
        {
            throw new IllegalArgumentException( "Only downloaded and snatched status are authorized" );
        }
        setParameter( PARAM_TYPE, type.getSickBeardValue() );
        return this;
    }

    @Override
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<History>>() {};
    }
}
