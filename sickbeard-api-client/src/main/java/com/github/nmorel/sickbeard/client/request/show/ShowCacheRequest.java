package com.github.nmorel.sickbeard.client.request.show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.Cache;

public class ShowCacheRequest
    extends SimpleRequest<Cache>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowCacheRequest.class );

    private static final String CMD_NAME = "show.cache";
    private static final String PARAM_TVDBID = "tvdbid";

    public ShowCacheRequest( String tvdbid, SickBeardConfig config )
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
    protected Class<Cache> getReturnType()
    {
        return Cache.class;
    }
}
