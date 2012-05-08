package com.github.nmorel.sickbeard.client.request.show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.NoDataRequest;
import com.github.nmorel.sickbeard.model.enums.Quality;

public class ShowSetQualityRequest
    extends NoDataRequest
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowSetQualityRequest.class );

    private static final String CMD_NAME = "show.setquality";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_INITIAL = "initial";
    private static final String PARAM_ARCHIVE = "archive";
    private static final String PARAM_SEPARATOR = "|";

    public ShowSetQualityRequest( String tvdbid, SickBeardConfig config )
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

    /**
     * Initial quality for the show. Multiple types can be passed :
     * <ul>
     * <li>sdtv,</li>
     * <li>sddvd,</li>
     * <li>hdtv,</li>
     * <li>hdwebdl,</li>
     * <li>hdbluray,</li>
     * <li>fullhdbluray,</li>
     * <li>unknown</li>
     * <li>any</li>
     * </ul>
     * If not provided then the config setting (default) is used.
     */
    public ShowSetQualityRequest setInitial( Quality... qualities )
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
                builder.append( quality.getIdentifier() );
            }
        }
        setParameter( PARAM_INITIAL, builder.toString() );
        return this;
    }

    /**
     * Archive quality for the show. Multiple types can be passed :
     * <ul>
     * <li>sddvd,</li>
     * <li>hdtv,</li>
     * <li>hdwebdl,</li>
     * <li>hdbluray,</li>
     * <li>fullhdbluray,</li>
     * <li>unknown</li>
     * <li>any</li>
     * </ul>
     * If not provided then the config setting (default) is used.
     */
    public ShowSetQualityRequest setArchive( Quality... qualities )
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
                builder.append( quality.getIdentifier() );
            }
        }
        setParameter( PARAM_ARCHIVE, builder.toString() );
        return this;
    }
}
