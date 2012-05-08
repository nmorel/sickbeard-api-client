package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.FutureCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.ShowStatus;
import com.github.nmorel.sickbeard.model.result.Future;
import com.github.nmorel.sickbeard.model.result.FutureEpisode;

@SuppressWarnings( "deprecation" )
public class FutureTest
{
    private static FutureCommands future;

    @BeforeClass
    public static void setup()
    {
        future = new SickBeardClient( "http://localhost:8085/api/1234/" ).future();
    }

    @Test
    public void displayTest()
        throws SickBeardException
    {
        Future fut = future.display().call();

        assertEquals( 2, fut.getMissed().size() );

        FutureEpisode ep = fut.getMissed().get( 0 );
        assertEquals( new Date( 111, 10, 21 ), ep.getAirdate() );
        assertEquals( "Monday 8:00 PM", ep.getAirs() );
        assertEquals( "The Rebound Girl", ep.getEpisodeName() );
        assertEquals(
            "Ted and Barney discuss making a life-changing decision together, and Robin tries to discourage Marshall and Lily from moving to Long Island.",
            ep.getEpisodePlot() );
        assertEquals( 11, ep.getEpisodeNumber() );
        assertEquals( "CBS", ep.getNetwork() );
        assertFalse( ep.isPaused() );
        assertEquals( Quality.HD_TV, ep.getQuality() );
        assertEquals( 7, ep.getSeasonNumber() );
        assertEquals( "How I Met Your Mother", ep.getShowName() );
        assertEquals( ShowStatus.CONTINUING, ep.getShowStatus() );
        assertEquals( "75760", ep.getTvdbid() );
        assertEquals( 1, ep.getWeekday() );

        ep = fut.getMissed().get( 1 );
        assertEquals( new Date( 111, 10, 21 ), ep.getAirdate() );
        assertEquals( "Monday 10:00 PM", ep.getAirs() );
        assertEquals( "Kill Shot", ep.getEpisodeName() );
        assertEquals(
            "A sniper on a killing spree is terrorizing New York City. With the clock ticking down to the next murder and nothing to go on except a killer with no apparent motive but to instill terror, this could prove the team's toughest case yet. The hunt is made even more complicated when Beckett begins to experience increasingly strong moments of PTSD - moments she tries hard to hide from Castle and the detectives.",
            ep.getEpisodePlot() );
        assertEquals( 9, ep.getEpisodeNumber() );
        assertEquals( "ABC", ep.getNetwork() );
        assertTrue( ep.isPaused() );
        assertEquals( Quality.SD_TV, ep.getQuality() );
        assertEquals( 4, ep.getSeasonNumber() );
        assertEquals( "Castle (2009)", ep.getShowName() );
        assertEquals( ShowStatus.CONTINUING, ep.getShowStatus() );
        assertEquals( "83462", ep.getTvdbid() );
        assertEquals( 1, ep.getWeekday() );

        assertEquals( 1, fut.getToday().size() );

        ep = fut.getToday().get( 0 );
        assertEquals( new Date( 111, 10, 22 ), ep.getAirdate() );
        assertEquals( "Monday 8:00 PM", ep.getAirs() );
        assertEquals( "Smoked Turkey", ep.getEpisodeName() );
        assertEquals(
            "Dixon tries to pursue a relationship with a resistant Adrianna, while Ivy and Raj\u2019s arguing takes a toll on their relationship. Liam plans a holiday dinner for the gang, and an unexpected guest shows up. Meanwhile, Naomi goes to extremes to prove her love to Austin.",
            ep.getEpisodePlot() );
        assertEquals( 10, ep.getEpisodeNumber() );
        assertEquals( "The CW", ep.getNetwork() );
        assertFalse( ep.isPaused() );
        assertEquals( Quality.SD_TV, ep.getQuality() );
        assertEquals( 4, ep.getSeasonNumber() );
        assertEquals( "90210", ep.getShowName() );
        assertEquals( ShowStatus.CONTINUING, ep.getShowStatus() );
        assertEquals( "82716", ep.getTvdbid() );
        assertEquals( 2, ep.getWeekday() );

        assertEquals( 0, fut.getLater().size() );

        assertEquals( 0, fut.getSoon().size() );
    }
}
