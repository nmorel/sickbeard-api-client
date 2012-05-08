package com.github.nmorel.sickbeard.model.result;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.DetailedShow.Builder;

@JsonDeserialize( builder = Builder.class )
public class DetailedShow
    extends Show
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
        extends Show.Builder
    {
        @JsonProperty( value = "airs" )
        private String airs;

        @JsonProperty( value = "genre" )
        private List<String> genre;

        @JsonProperty( value = "location" )
        private String location;

        @JsonProperty( value = "quality_details" )
        private QualityDetails qualityDetails;

        @JsonProperty( value = "season_folders" )
        private boolean seasonFolders;

        @JsonProperty( value = "season_list" )
        private List<Integer> seasonList;

        public Builder airs( String airs )
        {
            this.airs = airs;
            return this;
        }

        public Builder genre( List<String> genre )
        {
            this.genre = genre;
            return this;
        }

        public Builder location( String location )
        {
            this.location = location;
            return this;
        }

        public Builder qualityDetails( QualityDetails qualityDetails )
        {
            this.qualityDetails = qualityDetails;
            return this;
        }

        public Builder seasonFolders( boolean seasonFolders )
        {
            this.seasonFolders = seasonFolders;
            return this;
        }

        public Builder seasonList( List<Integer> seasonList )
        {
            this.seasonList = seasonList;
            return this;
        }

        public DetailedShow build()
        {
            return new DetailedShow( this );
        }
    }

    private String airs;
    private List<String> genre;
    private String location;
    private QualityDetails qualityDetails;
    private boolean seasonFolders;
    private List<Integer> seasonList;

    private DetailedShow( Builder builder )
    {
        super( builder );
        this.airs = builder.airs;
        this.genre = Collections.unmodifiableList( builder.genre );
        this.location = builder.location;
        this.qualityDetails = builder.qualityDetails;
        this.seasonFolders = builder.seasonFolders;
        this.seasonList = Collections.unmodifiableList( builder.seasonList );
    }

    public String getAirs()
    {
        return airs;
    }

    public List<String> getGenre()
    {
        return genre;
    }

    public String getLocation()
    {
        return location;
    }

    public QualityDetails getQualityDetails()
    {
        return qualityDetails;
    }

    public boolean isSeasonFolders()
    {
        return seasonFolders;
    }

    public List<Integer> getSeasonList()
    {
        return seasonList;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "DetailedShow{airs=" );
        builder2.append( airs );
        builder2.append( ", genre=" );
        builder2.append( genre );
        builder2.append( ", location=" );
        builder2.append( location );
        builder2.append( ", qualityDetails=" );
        builder2.append( qualityDetails );
        builder2.append( ", seasonFolders=" );
        builder2.append( seasonFolders );
        builder2.append( ", seasonList=" );
        builder2.append( seasonList );
        builder2.append( ", getTvdbId()=" );
        builder2.append( getTvdbId() );
        builder2.append( ", isAirByDate()=" );
        builder2.append( isAirByDate() );
        builder2.append( ", getCache()=" );
        builder2.append( getCache() );
        builder2.append( ", getLanguage()=" );
        builder2.append( getLanguage() );
        builder2.append( ", getNetwork()=" );
        builder2.append( getNetwork() );
        builder2.append( ", getNextEpAirdate()=" );
        builder2.append( getNextEpAirdate() );
        builder2.append( ", isPaused()=" );
        builder2.append( isPaused() );
        builder2.append( ", getQuality()=" );
        builder2.append( getQuality() );
        builder2.append( ", getShowName()=" );
        builder2.append( getShowName() );
        builder2.append( ", getStatus()=" );
        builder2.append( getStatus() );
        builder2.append( ", getTvrageId()=" );
        builder2.append( getTvrageId() );
        builder2.append( ", getTvrageName()=" );
        builder2.append( getTvrageName() );
        builder2.append( "}" );
        return builder2.toString();
    }

}
