package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.DetailedEpisode.Builder;

@JsonDeserialize( builder = Builder.class )
public class DetailedEpisode
    extends Episode
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
        extends Episode.Builder
    {
        private String description;

        private String location;

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

        public DetailedEpisode build()
        {
            return new DetailedEpisode( this );
        }
    }

    private String description;
    private String location;

    private DetailedEpisode( Builder builder )
    {
        super( builder );
        this.description = builder.description;
        this.location = builder.location;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLocation()
    {
        return location;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "DetailedEpisode{description=" );
        builder2.append( description );
        builder2.append( ", location=" );
        builder2.append( location );
        builder2.append( ", getAirdate()=" );
        builder2.append( getAirdate() );
        builder2.append( ", getName()=" );
        builder2.append( getName() );
        builder2.append( ", getQuality()=" );
        builder2.append( getQuality() );
        builder2.append( ", getStatus()=" );
        builder2.append( getStatus() );
        builder2.append( "}" );
        return builder2.toString();
    }

}
