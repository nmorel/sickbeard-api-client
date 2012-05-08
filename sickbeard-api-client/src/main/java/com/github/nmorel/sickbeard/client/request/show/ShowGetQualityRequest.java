package com.github.nmorel.sickbeard.client.request.show;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nmorel.sickbeard.client.SickBeardConfig;
import com.github.nmorel.sickbeard.client.request.SimpleRequest;
import com.github.nmorel.sickbeard.model.result.QualityDetails;

public class ShowGetQualityRequest
    extends SimpleRequest<QualityDetails>
{
    private static final Logger LOGGER = LoggerFactory.getLogger( ShowGetQualityRequest.class );

    private static final String CMD_NAME = "show.getquality";
    private static final String PARAM_TVDBID = "tvdbid";

    public ShowGetQualityRequest( String tvdbid, SickBeardConfig config )
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
    protected Class<QualityDetails> getReturnType()
    {
        return QualityDetails.class;
    }
}
