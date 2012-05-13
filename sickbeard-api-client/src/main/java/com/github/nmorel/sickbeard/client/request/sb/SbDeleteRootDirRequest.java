package com.github.nmorel.sickbeard.client.request.sb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericListRequest;
import com.github.nmorel.sickbeard.model.result.RootDir;

public class SbDeleteRootDirRequest
    extends GenericListRequest<RootDir>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbDeleteRootDirRequest.class );

    private static final String CMD_NAME = "sb.deleterootdir";
    private static final String PARAM_LOCATION = "location";

    public SbDeleteRootDirRequest( String location, SickBeardConfig config )
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

    @Override
    protected TypeReference<?> getReturnType()
    {
        return new TypeReference<List<RootDir>>() {};
    }
}
