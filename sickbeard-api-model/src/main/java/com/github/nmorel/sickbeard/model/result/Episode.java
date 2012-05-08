package com.github.nmorel.sickbeard.model.result;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.DateDeserializer;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.Episode.Builder;

@JsonDeserialize( builder = Builder.class )
public class Episode
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonDeserialize( using = DateDeserializer.class )
        private Date airdate;

        private String description;

        private String location;

        private String name;

        private Quality quality;

        private Status status;

        public Builder airdate( Date airdate )
        {
            this.airdate = airdate;
            return this;
        }

        public Builder description( String description )
        {
            this.description = description;
            return this;
        }

        public Builder location( String location )
        {
            this.location = location;
            return this;
        }

        public Builder name( String name )
        {
            this.name = name;
            return this;
        }

        public Builder quality( Quality quality )
        {
            this.quality = quality;
            return this;
        }

        public Builder status( Status status )
        {
            this.status = status;
            return this;
        }

        public Episode build()
        {
            return new Episode( this );
        }
    }

    private Date airdate;
    private String description;
    private String location;
    private String name;
    private Quality quality;
    private Status status;

    private Episode( Builder builder )
    {
        this.airdate = builder.airdate;
        this.description = builder.description;
        this.location = builder.location;
        this.name = builder.name;
        this.quality = builder.quality;
        this.status = builder.status;
    }

    public Date getAirdate()
    {
        return airdate;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLocation()
    {
        return location;
    }

    public String getName()
    {
        return name;
    }

    public Quality getQuality()
    {
        return quality;
    }

    public Status getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "Episode{airdate=" );
        builder2.append( airdate );
        builder2.append( ", description=" );
        builder2.append( description );
        builder2.append( ", location=" );
        builder2.append( location );
        builder2.append( ", name=" );
        builder2.append( name );
        builder2.append( ", quality=" );
        builder2.append( quality );
        builder2.append( ", status=" );
        builder2.append( status );
        builder2.append( "}" );
        return builder2.toString();
    }

}
