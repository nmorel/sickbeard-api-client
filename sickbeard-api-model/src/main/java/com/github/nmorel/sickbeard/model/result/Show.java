package com.github.nmorel.sickbeard.model.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.DateDeserializer;
import com.github.nmorel.sickbeard.model.deserializer.ShowStatusDeserializer;
import com.github.nmorel.sickbeard.model.deserializer.TvdbLangAbbreviationToLanguage;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.ShowStatus;
import com.github.nmorel.sickbeard.model.result.Show.Builder;

@JsonDeserialize( builder = Builder.class )
public class Show
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "tvdbid" )
        private String tvdbId;

        @JsonProperty( value = "air_by_date" )
        private boolean airByDate;

        @JsonProperty( value = "cache" )
        private Cache cache;

        @JsonDeserialize( using = TvdbLangAbbreviationToLanguage.class )
        private Language language;

        @JsonProperty( value = "network" )
        private String network;

        @JsonProperty( value = "next_ep_airdate" )
        @JsonDeserialize( using = DateDeserializer.class )
        private Date nextEpAirdate;

        @JsonProperty( value = "paused" )
        private boolean paused;

        @JsonProperty( value = "quality" )
        private Quality quality;

        @JsonProperty( value = "show_name" )
        private String showName;

        @JsonDeserialize( using = ShowStatusDeserializer.class )
        @JsonProperty( value = "status" )
        private ShowStatus status;

        @JsonProperty( value = "tvrage_id" )
        private String tvrageId;

        @JsonProperty( value = "tvrage_name" )
        private String tvrageName;

        public Builder tvdbId( String tvdbId )
        {
            this.tvdbId = tvdbId;
            return this;
        }

        public Builder airByDate( boolean airByDate )
        {
            this.airByDate = airByDate;
            return this;
        }

        public Builder cache( Cache cache )
        {
            this.cache = cache;
            return this;
        }

        public Builder language( Language language )
        {
            this.language = language;
            return this;
        }

        public Builder network( String network )
        {
            this.network = network;
            return this;
        }

        public Builder nextEpAirdate( Date nextEpAirdate )
        {
            this.nextEpAirdate = nextEpAirdate;
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

        public Builder showName( String showName )
        {
            this.showName = showName;
            return this;
        }

        public Builder status( ShowStatus status )
        {
            this.status = status;
            return this;
        }

        public Builder tvrageId( String tvrageId )
        {
            this.tvrageId = tvrageId;
            return this;
        }

        public Builder tvrageName( String tvrageName )
        {
            this.tvrageName = tvrageName;
            return this;
        }

        public Show build()
        {
            return new Show( this );
        }
    }

    private String tvdbId;
    private boolean airByDate;
    private Cache cache;
    private Language language;
    private String network;
    private Date nextEpAirdate;
    private boolean paused;
    private Quality quality;
    private String showName;
    private ShowStatus status;
    private String tvrageId;
    private String tvrageName;

    protected Show( Builder builder )
    {
        this.tvdbId = builder.tvdbId;
        this.airByDate = builder.airByDate;
        this.cache = builder.cache;
        this.language = builder.language;
        this.network = builder.network;
        this.nextEpAirdate = builder.nextEpAirdate;
        this.paused = builder.paused;
        this.quality = builder.quality;
        this.showName = builder.showName;
        this.status = builder.status;
        this.tvrageId = builder.tvrageId;
        this.tvrageName = builder.tvrageName;
    }

    public String getTvdbId()
    {
        return tvdbId;
    }

    public boolean isAirByDate()
    {
        return airByDate;
    }

    public Cache getCache()
    {
        return cache;
    }

    public Language getLanguage()
    {
        return language;
    }

    public String getNetwork()
    {
        return network;
    }

    public Date getNextEpAirdate()
    {
        return nextEpAirdate;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public Quality getQuality()
    {
        return quality;
    }

    public String getShowName()
    {
        return showName;
    }

    public ShowStatus getStatus()
    {
        return status;
    }

    public String getTvrageId()
    {
        return tvrageId;
    }

    public String getTvrageName()
    {
        return tvrageName;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Show{tvdbId=" );
        builder.append( tvdbId );
        builder.append( ", airByDate=" );
        builder.append( airByDate );
        builder.append( ", cache=" );
        builder.append( cache );
        builder.append( ", language=" );
        builder.append( language );
        builder.append( ", network=" );
        builder.append( network );
        builder.append( ", nextEpAirdate=" );
        builder.append( nextEpAirdate );
        builder.append( ", paused=" );
        builder.append( paused );
        builder.append( ", quality=" );
        builder.append( quality );
        builder.append( ", showName=" );
        builder.append( showName );
        builder.append( ", status=" );
        builder.append( status );
        builder.append( ", tvrageId=" );
        builder.append( tvrageId );
        builder.append( ", tvrageName=" );
        builder.append( tvrageName );
        builder.append( "}" );
        return builder.toString();
    }
}
