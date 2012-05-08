package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.LogsCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;

public class LogsTest
{
    private static LogsCommands logs;

    @BeforeClass
    public static void setup()
    {
        logs = new SickBeardClient( "http://localhost:8085/api/1234/" ).logs();
    }

    @Test
    public void getLogsTest()
        throws SickBeardException
    {
        List<String> logsList = logs.getLogs().call();

        assertEquals( 14, logsList.size() );
        assertEquals( "Aug-10 02:57:36 INFO     SHOWQUEUE-REFRESH :: No new cache images needed, not retrieving new ones", logsList.get( 0 ) );
        assertEquals( "Aug-10 02:57:36 INFO     SHOWQUEUE-REFRESH :: Checking & filling cache for show True Blood", logsList.get( 1 ) );
        assertEquals( "Aug-10 02:57:36 INFO     SHOWQUEUE-REFRESH :: 82283: Writing NFOs for all episodes", logsList.get( 2 ) );
        assertEquals( "Aug-10 02:57:36 INFO     SHOWQUEUE-REFRESH :: 82283: Loading all episodes with a location from the database", logsList.get( 3 ) );
        assertEquals( "Aug-10 02:57:35 INFO     SHOWQUEUE-REFRESH :: 82283: Loading all episodes from the show directory S:\\TV\\True Blood",
            logsList.get( 4 ) );
        assertEquals( "Aug-10 02:57:35 INFO     SHOWQUEUE-REFRESH :: Performing refresh on True Blood", logsList.get( 5 ) );
        assertEquals(
            "Aug-10 02:54:36 WARNING  SHOWQUEUE-FORCE-UPDATE :: Unable to add TVRage info: Show is already in database, not adding the TVRage info",
            logsList.get( 6 ) );
        assertEquals(
            "Aug-10 02:54:36 INFO     SHOWQUEUE-FORCE-UPDATE :: Checking the last aired episode to see if the dates match between TVDB and TVRage",
            logsList.get( 7 ) );
        assertEquals( "Aug-10 02:54:32 INFO     SHOWQUEUE-FORCE-UPDATE :: 95011: Loading all episodes from theTVDB...", logsList.get( 8 ) );
        assertEquals( "Aug-10 02:54:30 INFO     SHOWQUEUE-FORCE-UPDATE :: Loading all episodes from the DB", logsList.get( 9 ) );
        assertEquals( "Aug-10 02:54:30 INFO     SHOWQUEUE-FORCE-UPDATE :: 95011: Loading show info from theTVDB", logsList.get( 10 ) );
        assertEquals( "Aug-10 02:54:30 INFO     SHOWQUEUE-FORCE-UPDATE :: Beginning update of Modern Family", logsList.get( 11 ) );
        assertEquals(
            "Aug-10 02:54:25 ERROR    SEARCHQUEUE-BACKLOG-248261 :: No NZB/Torrent providers found or enabled in the sickbeard config. Please check your settings.",
            logsList.get( 12 ) );
        assertEquals( "Aug-10 02:54:25 INFO     SEARCHQUEUE-BACKLOG-248261 :: Searching for stuff we need from NTSF:SD:SUV:: season 1",
            logsList.get( 13 ) );
    }
}
