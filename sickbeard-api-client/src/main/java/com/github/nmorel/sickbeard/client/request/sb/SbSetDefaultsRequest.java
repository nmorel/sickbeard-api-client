package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;

public class SbSetDefaultsRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbSetDefaultsRequest.class );

    private static final String CMD_NAME = "sb.setdefaults";
    private static final String PARAM_ARCHIVE = "archive";
    private static final String PARAM_FUTURE_SHOW_PAUSED = "future_show_paused";
    private static final String PARAM_INITIAL = "initial";
    private static final String PARAM_STATUS = "status";
    private static final String PARAM_SEASON_FOLDER = "season_folder";
    private static final String PARAM_SEPARATOR = "|";

    public SbSetDefaultsRequest( SickBeardConfig config )
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
     * Archive quality for the show
     *
     * @param qualities
     */
    public SbSetDefaultsRequest setArchive( Quality... qualities )
    {
        StringBuilder builder = new StringBuilder();
        if ( null != qualities )
        {
            for ( Quality quality : qualities )
            {
                if ( builder.length() > 0 )
                {
                    builder.append( PARAM_SEPARATOR );
                }
                builder.append( quality.getParamId() );
            }
        }
        setParameter( PARAM_ARCHIVE, builder.toString() );
        return this;
    }

    /**
     * @param futureShowPaused
     */
    public SbSetDefaultsRequest setFutureShowPaused( boolean futureShowPaused )
    {
        setParameter( PARAM_FUTURE_SHOW_PAUSED, convertBooleanParameter( futureShowPaused ) );
        return this;
    }

    /**
     * Initial quality for the show
     *
     * @param qualities
     */
    public SbSetDefaultsRequest setInitial( Quality... qualities )
    {
        StringBuilder builder = new StringBuilder();
        if ( null != qualities )
        {
            for ( Quality quality : qualities )
            {
                if ( builder.length() > 0 )
                {
                    builder.append( PARAM_SEPARATOR );
                }
                builder.append( quality.getParamId() );
            }
        }
        setParameter( PARAM_INITIAL, builder.toString() );
        return this;
    }

    /**
     * Use season subfolders within the show directory
     *
     * @param seasonFolder
     */
    public SbSetDefaultsRequest setSeasonFolder( boolean seasonFolder )
    {
        setParameter( PARAM_SEASON_FOLDER, convertBooleanParameter( seasonFolder ) );
        return this;
    }

    /**
     * Status of missing episodes
     *
     * @param status
     */
    public SbSetDefaultsRequest setStatus( Status status )
    {
        setParameter( PARAM_STATUS, status.getParamId() );
        return this;
    }

}
