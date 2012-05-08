package com.github.nmorel.sickbeard.model.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.DateDeserializer;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.ShowStatus;
import com.github.nmorel.sickbeard.model.result.FutureEpisode.Builder;

@JsonDeserialize( builder = Builder.class )
public class FutureEpisode
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonDeserialize( using = DateDeserializer.class )
        private Date airdate;

        private String airs;

        @JsonProperty( value = "ep_name" )
        private String episodeName;

        @JsonProperty( value = "ep_plot" )
        private String episodePlot;

        @JsonProperty( value = "episode" )
        private int episodeNumber;

        private String network;

        private boolean paused;

        private Quality quality;

        @JsonProperty( value = "season" )
        private int seasonNumber;

        @JsonProperty( value = "show_name" )
        private String showName;

        @JsonProperty( value = "show_status" )
        private ShowStatus showStatus;

        private String tvdbid;

        private int weekday;

        public Builder airdate( Date airdate )
        {
            this.airdate = airdate;
            return this;
        }

        public Builder airs( String airs )
        {
            this.airs = airs;
            return this;
        }

        public Builder episodeName( String episodeName )
        {
            this.episodeName = episodeName;
            return this;
        }

        public Builder episodePlot( String episodePlot )
        {
            this.episodePlot = episodePlot;
            return this;
        }

        public Builder episodeNumber( int episodeNumber )
        {
            this.episodeNumber = episodeNumber;
            return this;
        }

        public Builder network( String network )
        {
            this.network = network;
            return this;
        }

        public Builder paused( boolean paused )
        {
            this.paused = paused;
            return this;
        }

        public Builder quality( Quality quality )
        {
            this.quality = quality;
            return this;
        }

        public Builder seasonNumber( int seasonNumber )
        {
            this.seasonNumber = seasonNumber;
            return this;
        }

        public Builder showName( String showName )
        {
            this.showName = showName;
            return this;
        }

        public Builder showStatus( ShowStatus showStatus )
        {
            this.showStatus = showStatus;
            return this;
        }

        public Builder tvdbid( String tvdbid )
        {
            this.tvdbid = tvdbid;
            return this;
        }

        public Builder weekday( int weekday )
        {
            this.weekday = weekday;
            return this;
        }

        public FutureEpisode build()
        {
            return new FutureEpisode( this );
        }
    }

    private Date airdate;
    private String airs;
    private String episodeName;
    private String episodePlot;
    private int episodeNumber;
    private String network;
    private boolean paused;
    private Quality quality;
    private int seasonNumber;
    private String showName;
    private ShowStatus showStatus;
    private String tvdbid;
    private int weekday;

    private FutureEpisode( Builder builder )
    {
        this.airdate = builder.airdate;
        this.airs = builder.airs;
        this.episodeName = builder.episodeName;
        this.episodePlot = builder.episodePlot;
        this.episodeNumber = builder.episodeNumber;
        this.network = builder.network;
        this.paused = builder.paused;
        this.quality = builder.quality;
        this.seasonNumber = builder.seasonNumber;
        this.showName = builder.showName;
        this.showStatus = builder.showStatus;
        this.tvdbid = builder.tvdbid;
        this.weekday = builder.weekday;
    }

    public Date getAirdate()
    {
        return airdate;
    }

    public String getAirs()
    {
        return airs;
    }

    public String getEpisodeName()
    {
        return episodeName;
    }

    public String getEpisodePlot()
    {
        return episodePlot;
    }

    public int getEpisodeNumber()
    {
        return episodeNumber;
    }

    public String getNetwork()
    {
        return network;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public Quality getQuality()
    {
        return quality;
    }

    public int getSeasonNumber()
    {
        return seasonNumber;
    }

    public String getShowName()
    {
        return showName;
    }

    public ShowStatus getShowStatus()
    {
        return showStatus;
    }

    public String getTvdbid()
    {
        return tvdbid;
    }

    public int getWeekday()
    {
        return weekday;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "FutureEpisode{airdate=" );
        builder2.append( airdate );
        builder2.append( ", airs=" );
        builder2.append( airs );
        builder2.append( ", episodeName=" );
        builder2.append( episodeName );
        builder2.append( ", episodePlot=" );
        builder2.append( episodePlot );
        builder2.append( ", episodeNumber=" );
        builder2.append( episodeNumber );
        builder2.append( ", network=" );
        builder2.append( network );
        builder2.append( ", paused=" );
        builder2.append( paused );
        builder2.append( ", quality=" );
        builder2.append( quality );
        builder2.append( ", seasonNumber=" );
        builder2.append( seasonNumber );
        builder2.append( ", showName=" );
        builder2.append( showName );
        builder2.append( ", showStatus=" );
        builder2.append( showStatus );
        builder2.append( ", tvdbid=" );
        builder2.append( tvdbid );
        builder2.append( ", weekday=" );
        builder2.append( weekday );
        builder2.append( "}" );
        return builder2.toString();
    }

}
