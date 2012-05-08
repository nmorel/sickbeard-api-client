package com.github.nmorel.sickbeard.client.request.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.enums.FutureSort;
import com.github.nmorel.sickbeard.model.enums.FutureType;
import com.github.nmorel.sickbeard.model.result.Future;

public class FutureDisplayRequest
    extends SimpleRequest<Future>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( FutureDisplayRequest.class );

    private static final String CMD_NAME = "future";
    private static final String PARAM_PAUSED = "paused";
    private static final String PARAM_SORT = "sort";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_SEPARATOR = "|";

    public FutureDisplayRequest( SickBeardConfig config )
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
     * false to exclude paused shows, true to include them, or omitted to use the SB default
     */
    public FutureDisplayRequest setPaused( boolean paused )
    {
        setParameter( PARAM_PAUSED, convertBooleanParameter( paused ) );
        return this;
    }

    /**
     * Change the sort order
     */
    public FutureDisplayRequest setSort( FutureSort sort )
    {
        setParameter( PARAM_SORT, sort.getIdentifier() );
        return this;
    }

    /**
     * multiple types can be passed when delimited by |
     * <ul>
     * <li>missed - show's date is older than today</li>
     * <li>today - show's date is today</li>
     * <li>soon - show's date greater than today but less than a week</li>
     * <li>later - show's date greater than a week</li>
     * </ul>
     */
    public FutureDisplayRequest setTypes( FutureType... types )
    {
        StringBuilder builder = new StringBuilder();
        if ( null != types )
        {
            for ( FutureType type : types )
            {
                if ( builder.length() > 0 )
                {
                    builder.append( PARAM_SEPARATOR );
                }
                builder.append( type.getIdentifier() );
            }
        }
        setParameter( PARAM_TYPE, builder.toString() );
        return this;
    }

    @Override
    protected Class<Future> getReturnType()
    {
        return Future.class;
    }
}
