package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import com.github.nmorel.sickbeard.model.result.Misc;
import com.github.nmorel.sickbeard.model.result.RootDir;
import com.github.nmorel.sickbeard.model.result.Scheduler;
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

    @Test
    public void forceSearchTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        assertNull( sb.forceSearch().call() );
    }

    @Test
    public void deleteRootDirTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        List<RootDir> rootDirs = sb.deleteRootDir( "C:\\Temp" ).call();
        assertEquals( 2, rootDirs.size() );

        RootDir rootDir = rootDirs.get( 0 );
        assertFalse( rootDir.isDefaultDir() );
        assertEquals( "S:\\Invalid_Location", rootDir.getLocation() );
        assertFalse( rootDir.isValid() );

        rootDir = rootDirs.get( 1 );
        assertTrue( rootDir.isDefaultDir() );
        assertEquals( "D:\\SickBeard_TV", rootDir.getLocation() );
        assertTrue( rootDir.isValid() );
    }

    @Test
    public void checkSchedulerTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        Scheduler scheduler = sb.checkScheduler().call();

        assertFalse( scheduler.isBacklogPaused() );
        assertTrue( scheduler.isBacklogRunning() );
        assertEquals( new Date( 111, 8, 18 ), scheduler.getLastBacklog() );
        assertEquals( new Date( 111, 9, 9 ), scheduler.getNextBacklog() );
        assertNotNull( scheduler.getLastBacklog() );
        assertFalse( scheduler.isSearchRunning() );
    }

    @Test
    public void addRootDirTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        try
        {
            sb.addRootDir( null ).call();
            fail();
        }
        catch ( IllegalArgumentException e )
        {
        }

        List<RootDir> rootDirs = sb.addRootDir( "C:\\Temp" ).setDefault( true ).call();
        assertEquals( 3, rootDirs.size() );

        RootDir rootDir = rootDirs.get( 0 );
        assertFalse( rootDir.isDefaultDir() );
        assertEquals( "S:\\Invalid_Location", rootDir.getLocation() );
        assertFalse( rootDir.isValid() );

        rootDir = rootDirs.get( 1 );
        assertTrue( rootDir.isDefaultDir() );
        assertEquals( "C:\\Temp", rootDir.getLocation() );
        assertTrue( rootDir.isValid() );

        rootDir = rootDirs.get( 2 );
        assertFalse( rootDir.isDefaultDir() );
        assertEquals( "D:\\SickBeard_TV", rootDir.getLocation() );
        assertTrue( rootDir.isValid() );
    }

    @Test
    public void miscTest()
        throws JsonParseException, JsonMappingException, IOException, SickBeardException
    {
        Misc misc = sb.misc().call();

        assertEquals( 41, misc.getApiCommands().size() );
        assertEquals( "episode", misc.getApiCommands().get( 0 ) );
        assertEquals( "episode.search", misc.getApiCommands().get( 1 ) );
        assertEquals( "episode.setstatus", misc.getApiCommands().get( 2 ) );
        assertEquals( "exceptions", misc.getApiCommands().get( 3 ) );
        assertEquals( "future", misc.getApiCommands().get( 4 ) );
        assertEquals( "help", misc.getApiCommands().get( 5 ) );
        assertEquals( "history", misc.getApiCommands().get( 6 ) );
        assertEquals( "history.clear", misc.getApiCommands().get( 7 ) );
        assertEquals( "history.trim", misc.getApiCommands().get( 8 ) );
        assertEquals( "logs", misc.getApiCommands().get( 9 ) );
        assertEquals( "sb", misc.getApiCommands().get( 10 ) );
        assertEquals( "sb.addrootdir", misc.getApiCommands().get( 11 ) );
        assertEquals( "sb.checkscheduler", misc.getApiCommands().get( 12 ) );
        assertEquals( "sb.deleterootdir", misc.getApiCommands().get( 13 ) );
        assertEquals( "sb.forcesearch", misc.getApiCommands().get( 14 ) );
        assertEquals( "sb.getdefaults", misc.getApiCommands().get( 15 ) );
        assertEquals( "sb.getmessages", misc.getApiCommands().get( 16 ) );
        assertEquals( "sb.getrootdirs", misc.getApiCommands().get( 17 ) );
        assertEquals( "sb.pausebacklog", misc.getApiCommands().get( 18 ) );
        assertEquals( "sb.ping", misc.getApiCommands().get( 19 ) );
        assertEquals( "sb.restart", misc.getApiCommands().get( 20 ) );
        assertEquals( "sb.searchtvdb", misc.getApiCommands().get( 21 ) );
        assertEquals( "sb.setdefaults", misc.getApiCommands().get( 22 ) );
        assertEquals( "sb.shutdown", misc.getApiCommands().get( 23 ) );
        assertEquals( "show", misc.getApiCommands().get( 24 ) );
        assertEquals( "show.addexisting", misc.getApiCommands().get( 25 ) );
        assertEquals( "show.addnew", misc.getApiCommands().get( 26 ) );
        assertEquals( "show.cache", misc.getApiCommands().get( 27 ) );
        assertEquals( "show.delete", misc.getApiCommands().get( 28 ) );
        assertEquals( "show.getbanner", misc.getApiCommands().get( 29 ) );
        assertEquals( "show.getposter", misc.getApiCommands().get( 30 ) );
        assertEquals( "show.getquality", misc.getApiCommands().get( 31 ) );
        assertEquals( "show.pause", misc.getApiCommands().get( 32 ) );
        assertEquals( "show.refresh", misc.getApiCommands().get( 33 ) );
        assertEquals( "show.seasonlist", misc.getApiCommands().get( 34 ) );
        assertEquals( "show.seasons", misc.getApiCommands().get( 35 ) );
        assertEquals( "show.setquality", misc.getApiCommands().get( 36 ) );
        assertEquals( "show.stats", misc.getApiCommands().get( 37 ) );
        assertEquals( "show.update", misc.getApiCommands().get( 38 ) );
        assertEquals( "shows", misc.getApiCommands().get( 39 ) );
        assertEquals( "shows.stats", misc.getApiCommands().get( 40 ) );

        assertEquals( "0.2", misc.getApiVersion() );
        assertEquals( "build 495", misc.getSbVersion() );
    }
}
