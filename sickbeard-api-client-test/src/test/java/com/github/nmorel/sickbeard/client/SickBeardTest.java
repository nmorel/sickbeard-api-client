package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.nmorel.sickbeard.client.cmd.SickBeard;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.Defaults;
import com.github.nmorel.sickbeard.model.result.Message;
import com.github.nmorel.sickbeard.model.result.RootDir;
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

    @Test
    public void restartTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        assertNull( sb.restart().call() );
    }

    @Test
    public void getRootDirsTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        List<RootDir> rootDirs = sb.getRootDirs().call();
        assertEquals( 3, rootDirs.size() );

        RootDir rootDir = rootDirs.get( 0 );
        assertFalse( rootDir.isDefaultDir() );
        assertEquals( "S:\\Invalid_Location", rootDir.getLocation() );
        assertFalse( rootDir.isValid() );

        rootDir = rootDirs.get( 1 );
        assertFalse( rootDir.isDefaultDir() );
        assertEquals( "C:\\Temp", rootDir.getLocation() );
        assertTrue( rootDir.isValid() );

        rootDir = rootDirs.get( 2 );
        assertTrue( rootDir.isDefaultDir() );
        assertEquals( "D:\\SickBeard_TV", rootDir.getLocation() );
        assertTrue( rootDir.isValid() );
    }

    @Test
    public void getMessagesTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        List<Message> messages = sb.getMessages().call();
        assertEquals( 2, messages.size() );

        Message message = messages.get( 0 );
        assertEquals( "This is test number 2", message.getMessage() );
        assertEquals( "Test 2", message.getTitle() );
        assertEquals( "error", message.getType() );

        message = messages.get( 1 );
        assertEquals( "This is test number 1", message.getMessage() );
        assertEquals( "Test 1", message.getTitle() );
        assertEquals( "notice", message.getType() );
    }

    @Test
    public void getDefaultsTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        Defaults defaults = sb.getDefaults().call();

        assertEquals( 3, defaults.getArchive().size() );
        assertEquals( Quality.HD_TV, defaults.getArchive().get( 0 ) );
        assertEquals( Quality.HD_BR, defaults.getArchive().get( 1 ) );
        assertEquals( Quality.HD_WEB_DL, defaults.getArchive().get( 2 ) );

        assertTrue( defaults.isFutureShowPaused() );

        assertEquals( 2, defaults.getInitial().size() );
        assertEquals( Quality.SD_DVD, defaults.getInitial().get( 0 ) );
        assertEquals( Quality.SD_TV, defaults.getInitial().get( 1 ) );

        assertTrue( defaults.isSeasonFolders() );

        assertEquals( Status.SKIPPED, defaults.getStatus() );
    }
}
