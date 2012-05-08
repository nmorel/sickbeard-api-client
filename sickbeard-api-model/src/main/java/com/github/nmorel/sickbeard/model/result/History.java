package com.github.nmorel.sickbeard.model.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.DateHourDeserializer;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.History.Builder;

@JsonDeserialize( builder = Builder.class )
public class History
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonDeserialize( using = DateHourDeserializer.class )
        private Date date;

        private int episode;

        private String provider;

        private Quality quality;

        private String resource;

        @JsonProperty( value = "resource_path" )
        private String resourcePath;

        private int season;

        @JsonProperty( value = "show_name" )
        private String showName;

        private Status status;

        private String tvdbid;

        public Builder date( Date date )
        {
            this.date = date;
            return this;
        }

        public Builder episode( int episode )
        {
            this.episode = episode;
            return this;
        }

        public Builder provider( String provider )
        {
            this.provider = provider;
            return this;
        }

        public Builder quality( Quality quality )
        {
            this.quality = quality;
            return this;
        }

        public Builder resource( String resource )
        {
            this.resource = resource;
            return this;
        }

        public Builder resourcePath( String resourcePath )
        {
            this.resourcePath = resourcePath;
            return this;
        }

        public Builder season( int season )
        {
            this.season = season;
            return this;
        }

        public Builder showName( String showName )
        {
            this.showName = showName;
            return this;
        }

        public Builder status( Status status )
        {
            this.status = status;
            return this;
        }

        public Builder tvdbid( String tvdbid )
        {
            this.tvdbid = tvdbid;
            return this;
        }

        public History build()
        {
            return new History( this );
        }
    }

    private Date date;
    private int episode;
    private String provider;
    private Quality quality;
    private String resource;
    private String resourcePath;
    private int season;
    private String showName;
    private Status status;
    private String tvdbid;

    private History( Builder builder )
    {
        this.date = builder.date;
        this.episode = builder.episode;
        this.provider = builder.provider;
        this.quality = builder.quality;
        this.resource = builder.resource;
        this.resourcePath = builder.resourcePath;
        this.season = builder.season;
        this.showName = builder.showName;
        this.status = builder.status;
        this.tvdbid = builder.tvdbid;
    }

    public Date getDate()
    {
        return date;
    }

    public int getEpisode()
    {
        return episode;
    }

    public String getProvider()
    {
        return provider;
    }

    public Quality getQuality()
    {
        return quality;
    }

    public String getResource()
    {
        return resource;
    }

    public String getResourcePath()
    {
        return resourcePath;
    }

    public int getSeason()
    {
        return season;
    }

    public String getShowName()
    {
        return showName;
    }

    public Status getStatus()
    {
        return status;
    }

    public String getTvdbid()
    {
        return tvdbid;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "History{date=" );
        builder2.append( date );
        builder2.append( ", episode=" );
        builder2.append( episode );
        builder2.append( ", provider=" );
        builder2.append( provider );
        builder2.append( ", quality=" );
        builder2.append( quality );
        builder2.append( ", resource=" );
        builder2.append( resource );
        builder2.append( ", resourcePath=" );
        builder2.append( resourcePath );
        builder2.append( ", season=" );
        builder2.append( season );
        builder2.append( ", showName=" );
        builder2.append( showName );
        builder2.append( ", status=" );
        builder2.append( status );
        builder2.append( ", tvdbid=" );
        builder2.append( tvdbid );
        builder2.append( "}" );
        return builder2.toString();
    }
}
