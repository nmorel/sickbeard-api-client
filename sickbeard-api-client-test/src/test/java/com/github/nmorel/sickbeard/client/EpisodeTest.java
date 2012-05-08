package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.EpisodeCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.Episode;
import com.github.nmorel.sickbeard.model.result.EpisodeSearch;

@SuppressWarnings( "deprecation" )
public class EpisodeTest
{
    private static EpisodeCommands episode;

    @BeforeClass
    public static void setup()
    {
        episode = new SickBeardClient( "http://localhost:8085/api/1234/" ).episode();
    }

    @Test
    public void displayTest()
        throws SickBeardException
    {
        Episode ep = episode.display( "101501", 3, 1 ).setFullPath( true ).call();

        assertEquals( new Date( 111, 6, 28 ), ep.getAirdate() );
        assertEquals(
            "The third-season opener explores alien connections with the American West, including the claim that an alien was buried in a cemetery in Texas; Utah petroglyphs depicting unusual beings; and reports of strange creatures from 19th-century ranchers in California.",
            ep.getDescription() );
        assertEquals( "S:\\TV\\Ancient Aliens\\Season 03\\Ancient.Aliens.S03E01.Aliens.and.the.Old.West.720p.HDTV.x264-DiVERGE.mkv", ep.getLocation() );
        assertEquals( "Aliens and the Old West", ep.getName() );
        assertEquals( Quality.HD_TV, ep.getQuality() );
        assertEquals( Status.DOWNLOADED, ep.getStatus() );
    }

    @Test
    public void searchTest()
        throws SickBeardException
    {
        EpisodeSearch ep = episode.search( "101501", 3, 1 ).call();

        assertEquals( Quality.SD_TV, ep.getQuality() );
    }

    @Test
    public void setStatusTest()
        throws SickBeardException
    {
        assertNull( episode.setStatus( "101501", 3, 1, Status.ARCHIVED ).call() );
    }
}
