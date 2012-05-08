package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.HistoryCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.History;

@SuppressWarnings( "deprecation" )
public class HistoryTest
{
    private static HistoryCommands history;

    @BeforeClass
    public static void setup()
    {
        history = new SickBeardClient( "http://localhost:8085/api/1234/" ).history();
    }

    @Test
    public void displayTest()
        throws SickBeardException
    {
        List<History> fut = history.display().setLimit( 150 ).setType( Status.DOWNLOADED ).call();

        assertEquals( 2, fut.size() );

        History ep = fut.get( 0 );
        assertEquals( new Date( 111, 7, 19, 12, 58, 0 ), ep.getDate() );
        assertEquals( 4, ep.getEpisode() );
        assertEquals( "-1", ep.getProvider() );
        assertEquals( Quality.SD_TV, ep.getQuality() );
        assertEquals( "project.runway.s09e04.all.about.nina.hdtv.xvid-crimson.avi", ep.getResource() );
        assertEquals( "C:\\Users\\sickbeard\\Documents\\downloads\\complete\\TV\\Project.Runway.S09E04.All.About.Nina.HDTV.XviD-CRiMSON",
            ep.getResourcePath() );
        assertEquals( 9, ep.getSeason() );
        assertEquals( "Project Runway", ep.getShowName() );
        assertEquals( Status.DOWNLOADED, ep.getStatus() );
        assertEquals( "74285", ep.getTvdbid() );

        ep = fut.get( 1 );
        assertEquals( new Date( 111, 7, 19, 12, 25, 0 ), ep.getDate() );
        assertEquals( 4, ep.getEpisode() );
        assertEquals( "NZBs.org", ep.getProvider() );
        assertEquals( Quality.SD_TV, ep.getQuality() );
        assertEquals( "Project.Runway.S09E04.All.About.Nina.HDTV.XviD-CRiMSON", ep.getResource() );
        assertEquals( "", ep.getResourcePath() );
        assertEquals( 9, ep.getSeason() );
        assertEquals( "Project Runway", ep.getShowName() );
        assertEquals( Status.SNATCHED, ep.getStatus() );
        assertEquals( "74285", ep.getTvdbid() );
    }

    @Test
    public void clearTest()
        throws SickBeardException
    {
        assertNull( history.clear().call() );
    }

    @Test
    public void trimTest()
        throws SickBeardException
    {
        assertNull( history.trim().call() );
    }
}
