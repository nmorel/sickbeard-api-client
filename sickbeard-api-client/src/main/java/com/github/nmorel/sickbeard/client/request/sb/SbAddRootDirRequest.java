package com.github.nmorel.sickbeard.client.request.sb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;
import com.github.nmorel.sickbeard.model.result.RootDir;

public class SbAddRootDirRequest
    extends GenericListRequest<RootDir>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbAddRootDirRequest.class );

    private static final String CMD_NAME = "sb.addrootdir";
    private static final String PARAM_LOCATION = "location";
    private static final String PARAM_DEFAULT = "default";

    public SbAddRootDirRequest( String location, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == location )
        {
            throw new IllegalArgumentException( "location is required" );
        }
        setParameter( PARAM_LOCATION, location );
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
     * Make the location passed the default root (parent) directory
     */
    public SbAddRootDirRequest setDefault( boolean defaultDir )
    {
        setParameter( PARAM_DEFAULT, convertBooleanParameter( defaultDir ) );
        return this;
    }

    @Override
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<RootDir>>() {};
    }
}
