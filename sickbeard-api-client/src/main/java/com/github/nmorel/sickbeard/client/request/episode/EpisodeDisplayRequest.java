package com.github.nmorel.sickbeard.client.request.episode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.Episode;

public class EpisodeDisplayRequest
    extends SimpleRequest<Episode>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( EpisodeDisplayRequest.class );

    private static final String CMD_NAME = "episode";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_SEASON = "season";
    private static final String PARAM_EPISODE = "episode";
    private static final String PARAM_FULL_PATH = "full_path";

    public EpisodeDisplayRequest( String tvdbid, int season, int episode, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == tvdbid )
        {
            throw new IllegalArgumentException( "tvdbid is required" );
        }
        setParameter( PARAM_TVDBID, tvdbid );
        setParameter( PARAM_SEASON, Integer.toString( season ) );
        setParameter( PARAM_EPISODE, Integer.toString( episode ) );
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
     * Show the full absolute path (if valid) instead of a relative path for the episode location
     */
    public EpisodeDisplayRequest setFullPath( boolean fullPath )
    {
        setParameter( PARAM_FULL_PATH, convertBooleanParameter( fullPath ) );
        return this;
    }

    @Override
    protected Class<Episode> getReturnType()
    {
        return Episode.class;
    }
}
