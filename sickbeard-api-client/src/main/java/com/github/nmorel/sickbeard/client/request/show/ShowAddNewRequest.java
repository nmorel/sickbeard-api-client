package com.github.nmorel.sickbeard.client.request.show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.ShowAdd;

public class ShowAddNewRequest
    extends SimpleRequest<ShowAdd>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowAddNewRequest.class );

    private static final String CMD_NAME = "show.addnew";
    private static final String PARAM_TVDBID = "tvdbid";
    private static final String PARAM_LOCATION = "location";
    private static final String PARAM_LANG = "lang";
    private static final String PARAM_SEASON_FOLDER = "season_folder";
    private static final String PARAM_STATUS = "status";
    private static final String PARAM_INITIAL = "initial";
    private static final String PARAM_ARCHIVE = "archive";
    private static final String PARAM_SEPARATOR = "|";

    public ShowAddNewRequest( String tvdbid, SickBeardConfig config )
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
     * Base path for where the show folder is to be created. If not provided then the config setting (default) is used
     * -- if valid.
     */
    public ShowAddNewRequest setLocation( String location )
    {
        setParameter( PARAM_LOCATION, location );
        return this;
    }

    /**
     * The tvdb language
     */
    public ShowAddNewRequest setLanguage( Language language )
    {
        setParameter( PARAM_LANG, language.getTvdbAbbreviation() );
        return this;
    }

    /**
     * The status of missing episodes
     * <ul>
     * <li>wanted</li>
     * <li>skipped</li>
     * <li>archived</li>
     * <li>ignored</li>
     * </ul>
     */
    public ShowAddNewRequest setStatus( Status status )
    {
        setParameter( PARAM_STATUS, status.getSickBeardValue() );
        return this;
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
    public ShowAddNewRequest setInitial( Quality... qualities )
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
    public ShowAddNewRequest setArchive( Quality... qualities )
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

    /**
     * Use season subfolders for the show. If not provided then the config setting (default) is used.
     */
    public ShowAddNewRequest setSeasonFolder( boolean seasonFolder )
    {
        setParameter( PARAM_SEASON_FOLDER, convertBooleanParameter( seasonFolder ) );
        return this;
    }

    @Override
    protected Class<ShowAdd> getReturnType()
    {
        return ShowAdd.class;
    }
}
