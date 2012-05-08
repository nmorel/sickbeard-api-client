package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.Cache.Builder;

@JsonDeserialize( builder = Builder.class )
public class Cache
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private boolean banner;
        private boolean poster;

        public Builder banner( boolean banner )
        {
            this.banner = banner;
            return this;
        }

        public Builder poster( boolean poster )
        {
            this.poster = poster;
            return this;
        }

        public Cache build()
        {
            return new Cache( this );
        }
    }

    private boolean banner;
    private boolean poster;

    private Cache( Builder builder )
    {
        this.banner = builder.banner;
        this.poster = builder.poster;
    }

    public boolean isBanner()
    {
        return banner;
    }

    public boolean isPoster()
    {
        return poster;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "Cache{banner=" );
        builder2.append( banner );
        builder2.append( ", poster=" );
        builder2.append( poster );
        builder2.append( "}" );
        return builder2.toString();
    }
}
