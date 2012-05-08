package com.github.nmorel.sickbeard.client.request.episode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;
import com.github.nmorel.sickbeard.model.enums.Status;

public class EpisodeSetStatusRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( EpisodeSetStatusRequest.class );

    private static final String CMD_NAME = "episode.setstatus";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_SEASON = "season";
    private static final String PARAM_EPISODE = "episode";
    private static final String PARAM_STATUS = "status";

    public EpisodeSetStatusRequest( String tvdbid, int season, int episode, Status status, SickBeardConfig config )
    {
        super( config, CMD_NAME );
        if ( null == tvdbid )
        {
            throw new IllegalArgumentException( "tvdbid is required" );
        }
        if ( null == status )
        {
            throw new IllegalArgumentException( "status is required" );
        }
        setParameter( PARAM_TVDBID, tvdbid );
        setParameter( PARAM_SEASON, Integer.toString( season ) );
        setParameter( PARAM_EPISODE, Integer.toString( episode ) );
        setParameter( PARAM_STATUS, status.getSickBeardValue() );
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
}
