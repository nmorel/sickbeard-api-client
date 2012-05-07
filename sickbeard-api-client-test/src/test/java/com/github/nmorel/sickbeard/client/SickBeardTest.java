package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.nmorel.sickbeard.client.cmd.SickBeard;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.result.TvdbSearchResult;
import com.github.nmorel.sickbeard.model.result.TvdbSearchResults;

@SuppressWarnings( "deprecation" )
public class SickBeardTest
{
    private static SickBeard sb;

    @BeforeClass
    public static void setup()
    {
        sb = new SickBeardClient( "http://localhost:8085/api/1234/" ).sb();
    }

    @Test
    public void pauseBacklogTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        assertNull( sb.pauseBacklog().setPause( true ).call() );
    }

    @Test
    public void pingTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        assertEquals( 13152, sb.ping().call().getPid() );
    }

    @Test
    public void searchTvdbTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        TvdbSearchResults results = sb.searchTvdb().setLang( Language.FR ).setName( "test" ).call();
        assertEquals( Language.EN, results.getLanguage() );
        assertEquals( 2, results.getResults().size() );

        TvdbSearchResult result = results.getResults().get( 0 );
        assertEquals( new Date( 92, 4, 25 ), result.getFirstAired() );
        assertEquals( "The Tonight Show with Jay Leno", result.getName() );
        assertEquals( "70336", result.getTvdbid() );

        result = results.getResults().get( 1 );
        assertEquals( new Date( 109, 8, 14 ), result.getFirstAired() );
        assertEquals( "The Jay Leno Show", result.getName() );
        assertEquals( "113921", result.getTvdbid() );
    }

    @Test
    public void setDefaultsTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        assertNull( sb.setDefaults().setArchive( Quality.HD_BR, Quality.FULL_HD_BR ).call() );
    }

    @Test
    public void shutdownTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        assertNull( sb.shutdown().call() );
    }
}
