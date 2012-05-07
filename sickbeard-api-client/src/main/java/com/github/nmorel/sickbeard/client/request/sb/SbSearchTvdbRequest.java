package com.github.nmorel.sickbeard.client.request.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.result.TvdbSearchResults;

public class SbSearchTvdbRequest
    extends SimpleRequest<TvdbSearchResults>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( SbSearchTvdbRequest.class );

    private static final String CMD_NAME = "sb.searchtvdb";
    private static final String PARAM_LANG = "lang";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_TVDB_ID = "tvdbid";

    public SbSearchTvdbRequest( SickBeardConfig config )
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

    @Override
    protected Class<TvdbSearchResults> getReturnType()
    {
        return TvdbSearchResults.class;
    }

    /**
     * @param lang the language
     */
    public SbSearchTvdbRequest setLang( Language lang )
    {
        setParameter( PARAM_LANG, lang.getTvdbAbbreviation() );
        return this;
    }

    /**
     * @param name the name of the show you want to search for
     */
    public SbSearchTvdbRequest setName( String name )
    {
        setParameter( PARAM_NAME, name );
        return this;
    }

    /**
     * @param tvdbid thetvdb.com unique id of a show
     */
    public SbSearchTvdbRequest setTvdbId( String tvdbid )
    {
        setParameter( PARAM_TVDB_ID, tvdbid );
        return this;
    }

}
