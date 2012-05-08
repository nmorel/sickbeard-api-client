package com.github.nmorel.sickbeard.client.request.episode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.EpisodeSearch;

public class EpisodeSearchRequest
    extends SimpleRequest<EpisodeSearch>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( EpisodeSearchRequest.class );

    private static final String CMD_NAME = "episode.search";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_SEASON = "season";
    private static final String PARAM_EPISODE = "episode";

    public EpisodeSearchRequest( String tvdbid, int season, int episode, SickBeardConfig config )
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

    @Override
    protected Class<EpisodeSearch> getReturnType()
    {
        return EpisodeSearch.class;
    }
}
