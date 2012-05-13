package com.github.nmorel.sickbeard.client.request.exceptions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;

public class ExceptionsShowRequest
    extends GenericListRequest<String>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ExceptionsShowRequest.class );

    private static final String CMD_NAME = "exceptions";
    private static final String PARAM_TVDBID = "tvdbid";

    public ExceptionsShowRequest( String tvdbid, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == tvdbid )
        {
            throw new IllegalArgumentException( "tvdbid is required" );
        }
        setParameter( PARAM_TVDBID, tvdbid );
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

    @Override
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<String>>() {};
    }
}
