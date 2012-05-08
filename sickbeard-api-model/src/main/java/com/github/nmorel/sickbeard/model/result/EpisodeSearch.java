package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.result.EpisodeSearch.Builder;

@JsonDeserialize( builder = Builder.class )
public class EpisodeSearch
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private Quality quality;

        public Builder quality( Quality quality )
        {
            this.quality = quality;
            return this;
        }

        public EpisodeSearch build()
        {
            return new EpisodeSearch( this );
        }
    }

    private Quality quality;

    private EpisodeSearch( Builder builder )
    {
        this.quality = builder.quality;
    }

    public Quality getQuality()
    {
        return quality;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "EpisodeSearch{quality=" );
        builder2.append( quality );
        builder2.append( "}" );
        return builder2.toString();
    }

}
