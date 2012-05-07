package com.github.nmorel.sickbeard.model.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.DateDeserializer;
import com.github.nmorel.sickbeard.model.result.TvdbSearchResult.Builder;

@JsonDeserialize( builder = Builder.class )
public class TvdbSearchResult
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "first_aired" )
        @JsonDeserialize( using = DateDeserializer.class )
        private Date firstAired;

        private String name;

        private String tvdbid;

        public Builder firstAired( Date firstAired )
        {
            this.firstAired = firstAired;
            return this;
        }

        public Builder name( String name )
        {
            this.name = name;
            return this;
        }

        public Builder tvdbid( String tvdbid )
        {
            this.tvdbid = tvdbid;
            return this;
        }

        public TvdbSearchResult build()
        {
            return new TvdbSearchResult( this );
        }
    }

    private Date firstAired;
    private String name;
    private String tvdbid;

    private TvdbSearchResult( Builder builder )
    {
        this.firstAired = builder.firstAired;
        this.name = builder.name;
        this.tvdbid = builder.tvdbid;
    }

    public Date getFirstAired()
    {
        return firstAired;
    }

    public String getName()
    {
        return name;
    }

    public String getTvdbid()
    {
        return tvdbid;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "TvdbSearchResult{firstAired=" );
        builder2.append( firstAired );
        builder2.append( ", name=" );
        builder2.append( name );
        builder2.append( ", tvdbid=" );
        builder2.append( tvdbid );
        builder2.append( "}" );
        return builder2.toString();
    }

}
