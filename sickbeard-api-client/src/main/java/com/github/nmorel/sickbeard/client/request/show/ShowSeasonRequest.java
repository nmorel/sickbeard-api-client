package com.github.nmorel.sickbeard.client.request.show;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.GenericMapRequest;
import com.github.nmorel.sickbeard.model.result.Episode;

public class ShowSeasonRequest
    extends GenericMapRequest<Integer, Episode>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowSeasonRequest.class );

    private static final String CMD_NAME = "show.seasons";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_SEASON = "season";

    public ShowSeasonRequest( String tvdbid, int season, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == tvdbid )
        {
            throw new IllegalArgumentException( "tvdbid is required" );
        }
        setParameter( PARAM_TVDBID, tvdbid );
        setParameter( PARAM_SEASON, Integer.toString( season ) );
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
        return new TypeReference<Map<Integer, Episode>>()
        {
        };
    }
}
