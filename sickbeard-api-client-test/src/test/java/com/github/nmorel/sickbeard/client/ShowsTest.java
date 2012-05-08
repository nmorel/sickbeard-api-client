package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.ShowsCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.ShowStatus;
import com.github.nmorel.sickbeard.model.enums.ShowsSort;
import com.github.nmorel.sickbeard.model.result.Show;
import com.github.nmorel.sickbeard.model.result.ShowsStats;

@SuppressWarnings( "deprecation" )
public class ShowsTest
{
    private static ShowsCommands shows;

    @BeforeClass
    public static void setup()
    {
        shows = new SickBeardClient( "http://localhost:8085/api/1234/" ).shows();
    }

    @Test
    public void displaySortByIdTest()
        throws SickBeardException
    {
        List<Show> showList = shows.display().setPaused( true ).call();

        assertEquals( 4, showList.size() );

        Show show = showList.get( 0 );
        assertEquals( "71489", show.getTvdbId() );
        assertFalse( show.isAirByDate() );
        assertTrue( show.getCache().isBanner() );
        assertTrue( show.getCache().isPoster() );
        assertEquals( Language.EN, show.getLanguage() );
        assertEquals( "USA Network", show.getNetwork() );
        assertNull( show.getNextEpAirdate() );
        assertFalse( show.isPaused() );
        assertEquals( Quality.HD, show.getQuality() );
        assertEquals( "Law & Order: Criminal Intent", show.getShowName() );
        assertEquals( ShowStatus.ENDED, show.getStatus() );
        assertEquals( "4203", show.getTvrageId() );
        assertEquals( "Law & Order: Criminal Intent", show.getTvrageName() );

        show = showList.get( 1 );
        assertEquals( "140141", show.getTvdbId() );
        assertFalse( show.isAirByDate() );
        assertFalse( show.getCache().isBanner() );
        assertFalse( show.getCache().isPoster() );
        assertEquals( Language.FR, show.getLanguage() );
        assertEquals( "CBS", show.getNetwork() );
        assertEquals( new Date( 112, 0, 15 ), show.getNextEpAirdate() );
        assertFalse( show.isPaused() );
        assertEquals( Quality.ANY, show.getQuality() );
        assertEquals( "Undercover Boss (US)", show.getShowName() );
        assertEquals( ShowStatus.CONTINUING, show.getStatus() );
        assertEquals( "22657", show.getTvrageId() );
        assertEquals( "Undercover Boss", show.getTvrageName() );

        show = showList.get( 2 );
        assertEquals( "194751", show.getTvdbId() );
        assertTrue( show.isAirByDate() );
        assertTrue( show.getCache().isBanner() );
        assertTrue( show.getCache().isPoster() );
        assertEquals( Language.EN, show.getLanguage() );
        assertEquals( "TBS Superstation", show.getNetwork() );
        assertEquals( new Date( 111, 10, 28 ), show.getNextEpAirdate() );
        assertFalse( show.isPaused() );
        assertEquals( Quality.CUSTOM, show.getQuality() );
        assertEquals( "Conan (2010)", show.getShowName() );
        assertEquals( ShowStatus.CONTINUING, show.getStatus() );
        assertEquals( "0", show.getTvrageId() );
        assertEquals( "", show.getTvrageName() );

        show = showList.get( 3 );
        assertEquals( "248261", show.getTvdbId() );
        assertFalse( show.isAirByDate() );
        assertTrue( show.getCache().isBanner() );
        assertTrue( show.getCache().isPoster() );
        assertEquals( Language.EN, show.getLanguage() );
        assertEquals( "Cartoon Network", show.getNetwork() );
        assertNull( show.getNextEpAirdate() );
        assertTrue( show.isPaused() );
        assertEquals( Quality.CUSTOM, show.getQuality() );
        assertEquals( "NTSF:SD:SUV::", show.getShowName() );
        assertEquals( ShowStatus.CONTINUING, show.getStatus() );
        assertEquals( "28439", show.getTvrageId() );
        assertEquals( "NTSF:SD:SUV", show.getTvrageName() );
    }

    @Test
    public void displaySortByNameTest()
        throws SickBeardException
    {
        List<Show> showList = shows.display().setPaused( true ).setSort( ShowsSort.NAME ).call();

        assertEquals( 4, showList.size() );

        Show show = showList.get( 0 );
        assertEquals( "194751", show.getTvdbId() );
        assertTrue( show.isAirByDate() );
        assertTrue( show.getCache().isBanner() );
        assertTrue( show.getCache().isPoster() );
        assertEquals( Language.EN, show.getLanguage() );
        assertEquals( "TBS Superstation", show.getNetwork() );
        assertEquals( new Date( 111, 10, 28 ), show.getNextEpAirdate() );
        assertFalse( show.isPaused() );
        assertEquals( Quality.CUSTOM, show.getQuality() );
        assertEquals( "Conan (2010)", show.getShowName() );
        assertEquals( ShowStatus.CONTINUING, show.getStatus() );
        assertEquals( "0", show.getTvrageId() );
        assertEquals( "", show.getTvrageName() );

        show = showList.get( 1 );
        assertEquals( "71489", show.getTvdbId() );
        assertFalse( show.isAirByDate() );
        assertTrue( show.getCache().isBanner() );
        assertTrue( show.getCache().isPoster() );
        assertEquals( Language.EN, show.getLanguage() );
        assertEquals( "USA Network", show.getNetwork() );
        assertNull( show.getNextEpAirdate() );
        assertFalse( show.isPaused() );
        assertEquals( Quality.HD, show.getQuality() );
        assertEquals( "Law & Order: Criminal Intent", show.getShowName() );
        assertEquals( ShowStatus.ENDED, show.getStatus() );
        assertEquals( "4203", show.getTvrageId() );
        assertEquals( "Law & Order: Criminal Intent", show.getTvrageName() );

        show = showList.get( 2 );
        assertEquals( "248261", show.getTvdbId() );
        assertFalse( show.isAirByDate() );
        assertTrue( show.getCache().isBanner() );
        assertTrue( show.getCache().isPoster() );
        assertEquals( Language.EN, show.getLanguage() );
        assertEquals( "Cartoon Network", show.getNetwork() );
        assertNull( show.getNextEpAirdate() );
        assertTrue( show.isPaused() );
        assertEquals( Quality.CUSTOM, show.getQuality() );
        assertEquals( "NTSF:SD:SUV::", show.getShowName() );
        assertEquals( ShowStatus.CONTINUING, show.getStatus() );
        assertEquals( "28439", show.getTvrageId() );
        assertEquals( "NTSF:SD:SUV", show.getTvrageName() );

        show = showList.get( 3 );
        assertEquals( "140141", show.getTvdbId() );
        assertFalse( show.isAirByDate() );
        assertFalse( show.getCache().isBanner() );
        assertFalse( show.getCache().isPoster() );
        assertEquals( Language.FR, show.getLanguage() );
        assertEquals( "CBS", show.getNetwork() );
        assertEquals( new Date( 112, 0, 15 ), show.getNextEpAirdate() );
        assertFalse( show.isPaused() );
        assertEquals( Quality.ANY, show.getQuality() );
        assertEquals( "Undercover Boss (US)", show.getShowName() );
        assertEquals( ShowStatus.CONTINUING, show.getStatus() );
        assertEquals( "22657", show.getTvrageId() );
        assertEquals( "Undercover Boss", show.getTvrageName() );
    }

    @Test
    public void statsTest()
        throws SickBeardException
    {
        ShowsStats stats = shows.stats().call();
        assertEquals( 2754, stats.getEpisodesDownloaded() );
        assertEquals( 2808, stats.getEpisodesTotal() );
        assertEquals( 49, stats.getShowsActive() );
        assertEquals( 61, stats.getShowsTotal() );
    }
}
