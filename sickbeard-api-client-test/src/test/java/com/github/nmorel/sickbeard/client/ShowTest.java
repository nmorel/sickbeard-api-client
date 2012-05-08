package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.ShowCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.ShowStatus;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.Cache;
import com.github.nmorel.sickbeard.model.result.DetailedShow;
import com.github.nmorel.sickbeard.model.result.Episode;
import com.github.nmorel.sickbeard.model.result.QualityDetails;
import com.github.nmorel.sickbeard.model.result.ShowAdd;
import com.github.nmorel.sickbeard.model.result.ShowStats;

@SuppressWarnings( "deprecation" )
public class ShowTest
{
    private static ShowCommands show;

    @BeforeClass
    public static void setup()
    {
        show = new SickBeardClient( "http://localhost:8085/api/1234/" ).show();
    }

    @Test
    public void displayTest()
        throws SickBeardException
    {
        DetailedShow detailedShow = show.display( "79349" ).call();

        assertEquals( "79349", detailedShow.getTvdbId() );
        assertFalse( detailedShow.isAirByDate() );
        assertEquals( "Sunday 9:00 PM", detailedShow.getAirs() );
        assertTrue( detailedShow.getCache().isBanner() );
        assertTrue( detailedShow.getCache().isPoster() );
        assertEquals( Language.EN, detailedShow.getLanguage() );
        assertEquals( "S:\\TV\\Dexter", detailedShow.getLocation() );
        assertEquals( "Showtime", detailedShow.getNetwork() );
        assertEquals( new Date( 111, 10, 27 ), detailedShow.getNextEpAirdate() );
        assertFalse( detailedShow.isPaused() );
        assertEquals( Quality.HD, detailedShow.getQuality() );

        assertEquals( 0, detailedShow.getQualityDetails().getArchive().size() );
        assertEquals( 3, detailedShow.getQualityDetails().getInitial().size() );
        assertEquals( Quality.HD_TV, detailedShow.getQualityDetails().getInitial().get( 0 ) );
        assertEquals( Quality.HD_BR, detailedShow.getQualityDetails().getInitial().get( 1 ) );
        assertEquals( Quality.HD_WEB_DL, detailedShow.getQualityDetails().getInitial().get( 2 ) );

        assertTrue( detailedShow.isSeasonFolders() );

        assertEquals( 7, detailedShow.getSeasonList().size() );
        assertEquals( (Integer) 6, detailedShow.getSeasonList().get( 0 ) );
        assertEquals( (Integer) 5, detailedShow.getSeasonList().get( 1 ) );
        assertEquals( (Integer) 4, detailedShow.getSeasonList().get( 2 ) );
        assertEquals( (Integer) 3, detailedShow.getSeasonList().get( 3 ) );
        assertEquals( (Integer) 2, detailedShow.getSeasonList().get( 4 ) );
        assertEquals( (Integer) 1, detailedShow.getSeasonList().get( 5 ) );
        assertEquals( (Integer) 0, detailedShow.getSeasonList().get( 6 ) );

        assertEquals( "Dexter", detailedShow.getShowName() );
        assertEquals( ShowStatus.CONTINUING, detailedShow.getStatus() );
        assertEquals( "7926", detailedShow.getTvrageId() );
        assertEquals( "Dexter", detailedShow.getTvrageName() );
    }

    @Test
    public void addExistingTest()
        throws SickBeardException
    {
        ShowAdd showAdd =
            show.addExisting( "80348", "S:\\TV\\Chuck" ).setSeasonFolder( true ).setArchive( Quality.HD_BR, Quality.FULL_HD_BR )
                .setInitial( Quality.HD_WEB_DL ).call();

        assertEquals( "Chuck", showAdd.getName() );
    }

    @Test
    public void addNewTest()
        throws SickBeardException
    {
        ShowAdd showAdd =
            show.addNew( "101501" ).setLocation( "S:\\TV" ).setLanguage( Language.FR ).setStatus( Status.WANTED ).setSeasonFolder( true )
                .setArchive( Quality.HD_BR, Quality.FULL_HD_BR ).setInitial( Quality.HD_WEB_DL ).call();

        assertEquals( "Ancient Aliens", showAdd.getName() );
    }

    @Test
    public void cacheTest()
        throws SickBeardException
    {
        Cache cache = show.cache( "224041" ).call();

        assertTrue( cache.isBanner() );
        assertFalse( cache.isPoster() );
    }

    @Test
    public void deleteTest()
        throws SickBeardException
    {
        assertNull( show.delete( "224041" ).call() );
    }

    @Test
    public void getBannerTest()
        throws SickBeardException, IOException
    {
        FileInputStream banner = new FileInputStream( new File( "src/test/resources", "show.getbanner.jpg" ) );
        contentEquals( banner, show.getBanner( "82066" ).call() );
    }

    @Test
    public void getPosterTest()
        throws SickBeardException, IOException
    {
        FileInputStream banner = new FileInputStream( new File( "src/test/resources", "show.getposter.jpg" ) );
        contentEquals( banner, show.getPoster( "82066" ).call() );
    }

    @Test
    public void getQualityTest()
        throws SickBeardException
    {
        QualityDetails quality = show.getQuality( "80348" ).call();

        assertEquals( 1, quality.getInitial().size() );
        assertEquals( Quality.HD_TV, quality.getInitial().get( 0 ) );

        assertEquals( 2, quality.getArchive().size() );
        assertEquals( Quality.HD_BR, quality.getArchive().get( 0 ) );
        assertEquals( Quality.HD_WEB_DL, quality.getArchive().get( 1 ) );
    }

    @Test
    public void pauseTest()
        throws SickBeardException
    {
        assertNull( show.pause( "82283" ).setPaused( true ).call() );
    }

    @Test
    public void refreshTest()
        throws SickBeardException
    {
        assertNull( show.refresh( "82283" ).call() );
    }

    @Test
    public void seasonListTest()
        throws SickBeardException
    {
        List<Integer> seasonList = show.seasonList( "80621" ).call();
        assertEquals( 5, seasonList.size() );
        assertEquals( (Integer) 4, seasonList.get( 0 ) );
        assertEquals( (Integer) 3, seasonList.get( 1 ) );
        assertEquals( (Integer) 2, seasonList.get( 2 ) );
        assertEquals( (Integer) 1, seasonList.get( 3 ) );
        assertEquals( (Integer) 0, seasonList.get( 4 ) );

        seasonList = show.seasonList( "80621" ).setAscending( true ).call();
        assertEquals( 5, seasonList.size() );
        assertEquals( (Integer) 0, seasonList.get( 0 ) );
        assertEquals( (Integer) 1, seasonList.get( 1 ) );
        assertEquals( (Integer) 2, seasonList.get( 2 ) );
        assertEquals( (Integer) 3, seasonList.get( 3 ) );
        assertEquals( (Integer) 4, seasonList.get( 4 ) );
    }

    @Test
    public void seasonTest()
        throws SickBeardException
    {
        Map<Integer, Episode> episodes = show.season( "182061", 2 ).call();

        assertEquals( 5, episodes.size() );

        Episode episode = episodes.get( 1 );
        assertEquals( new Date( 111, 8, 4 ), episode.getAirdate() );
        assertEquals( "Something Wicked This Fae Comes", episode.getName() );
        assertEquals( Quality.HD_TV, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 2 );
        assertEquals( new Date( 111, 8, 11 ), episode.getAirdate() );
        assertEquals( "I Fought the Fae (And the Fae Won)", episode.getName() );
        assertEquals( Quality.NA, episode.getQuality() );
        assertEquals( Status.WANTED, episode.getStatus() );

        episode = episodes.get( 3 );
        assertEquals( new Date( 111, 8, 18 ), episode.getAirdate() );
        assertEquals( "Scream a Little Dream", episode.getName() );
        assertEquals( Quality.NA, episode.getQuality() );
        assertEquals( Status.UNAIRED, episode.getStatus() );

        episode = episodes.get( 4 );
        assertEquals( new Date( 111, 8, 25 ), episode.getAirdate() );
        assertEquals( "Episode 4", episode.getName() );
        assertEquals( Quality.NA, episode.getQuality() );
        assertEquals( Status.UNAIRED, episode.getStatus() );

        episode = episodes.get( 5 );
        assertNull( episode.getAirdate() );
        assertEquals( "Episode 5", episode.getName() );
        assertEquals( Quality.NA, episode.getQuality() );
        assertEquals( Status.SKIPPED, episode.getStatus() );
    }

    @Test
    public void seasonsTest()
        throws SickBeardException
    {
        Map<Integer, Map<Integer, Episode>> seasons = show.seasons( "248836" ).call();

        assertEquals( 2, seasons.size() );

        Map<Integer, Episode> episodes = seasons.get( 0 );
        assertEquals( 1, episodes.size() );

        Episode episode = episodes.get( 1 );
        assertEquals( new Date( 112, 0, 24 ), episode.getAirdate() );
        assertEquals( "First Look", episode.getName() );
        assertEquals( Quality.NA, episode.getQuality() );
        assertEquals( Status.SKIPPED, episode.getStatus() );

        episodes = seasons.get( 1 );
        assertEquals( 8, episodes.size() );

        episode = episodes.get( 1 );
        assertEquals( new Date( 112, 1, 7 ), episode.getAirdate() );
        assertEquals( "Magus", episode.getName() );
        assertEquals( Quality.HD_TV, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 2 );
        assertEquals( new Date( 112, 1, 7 ), episode.getAirdate() );
        assertEquals( "Marbeley", episode.getName() );
        assertEquals( Quality.HD_TV, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 3 );
        assertEquals( new Date( 112, 1, 14 ), episode.getAirdate() );
        assertEquals( "Los Ciegos", episode.getName() );
        assertEquals( Quality.HD_TV, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 4 );
        assertEquals( new Date( 112, 1, 21 ), episode.getAirdate() );
        assertEquals( "A Better Man", episode.getName() );
        assertEquals( Quality.HD_WEB_DL, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 5 );
        assertEquals( new Date( 112, 1, 28 ), episode.getAirdate() );
        assertEquals( "Peaches", episode.getName() );
        assertEquals( Quality.HD_WEB_DL, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 6 );
        assertEquals( new Date( 112, 2, 6 ), episode.getAirdate() );
        assertEquals( "Doctor Emmet Cole", episode.getName() );
        assertEquals( Quality.HD_WEB_DL, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 7 );
        assertEquals( new Date( 112, 2, 13 ), episode.getAirdate() );
        assertEquals( "The Experiment", episode.getName() );
        assertEquals( Quality.HD_WEB_DL, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );

        episode = episodes.get( 8 );
        assertEquals( new Date( 112, 2, 20 ), episode.getAirdate() );
        assertEquals( "Row, Row, Row Your Boat", episode.getName() );
        assertEquals( Quality.HD_WEB_DL, episode.getQuality() );
        assertEquals( Status.DOWNLOADED, episode.getStatus() );
    }

    @Test
    public void setQualityTest()
        throws SickBeardException
    {
        assertNull( show.setQuality( "79488" ).setArchive( Quality.HD_BR, Quality.FULL_HD_BR ).setInitial( Quality.HD_WEB_DL ).call() );
    }

    @Test
    public void statsTest()
        throws SickBeardException
    {
        ShowStats stats = show.stats( "80270" ).call();
        assertEquals( 0, stats.getArchived() );
        assertEquals( 0, stats.getDownloaded().getFullHdBluray() );
        assertEquals( 0, stats.getDownloaded().getHdBluray() );
        assertEquals( 0, stats.getDownloaded().getHdWebDl() );
        assertEquals( 11, stats.getDownloaded().getHdTv() );
        assertEquals( 13, stats.getDownloaded().getSdDvd() );
        assertEquals( 50, stats.getDownloaded().getSdTv() );
        assertEquals( 74, stats.getDownloaded().getTotal() );
        assertEquals( 0, stats.getDownloaded().getUnknown() );
        assertEquals( 0, stats.getIgnored() );
        assertEquals( 1, stats.getSkipped() );
        assertEquals( 0, stats.getSnatched().getFullHdBluray() );
        assertEquals( 0, stats.getSnatched().getHdBluray() );
        assertEquals( 0, stats.getSnatched().getHdWebDl() );
        assertEquals( 0, stats.getSnatched().getHdTv() );
        assertEquals( 0, stats.getSnatched().getSdDvd() );
        assertEquals( 0, stats.getSnatched().getSdTv() );
        assertEquals( 0, stats.getSnatched().getTotal() );
        assertEquals( 0, stats.getSnatched().getUnknown() );
        assertEquals( 75, stats.getTotal() );
        assertEquals( 0, stats.getUnaired() );
        assertEquals( 0, stats.getWanted() );
    }

    @Test
    public void updateTest()
        throws SickBeardException
    {
        assertNull( show.update( "95011" ).call() );
    }

    public void contentEquals( InputStream input1, InputStream input2 )
        throws IOException
    {
        if ( !( input1 instanceof BufferedInputStream ) )
        {
            input1 = new BufferedInputStream( input1 );
        }
        if ( !( input2 instanceof BufferedInputStream ) )
        {
            input2 = new BufferedInputStream( input2 );
        }

        int ch = input1.read();
        while ( -1 != ch )
        {
            int ch2 = input2.read();
            if ( ch != ch2 )
            {
                fail();
            }
            ch = input1.read();
        }

        int ch2 = input2.read();
        assertTrue( ch2 == -1 );
    }
}
