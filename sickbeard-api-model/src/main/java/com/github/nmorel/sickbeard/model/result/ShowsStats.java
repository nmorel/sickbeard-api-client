package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.ShowsStats.Builder;

@JsonDeserialize( builder = Builder.class )
public class ShowsStats
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "ep_downloaded" )
        private int episodesDownloaded;

        @JsonProperty( value = "ep_total" )
        private int episodesTotal;

        @JsonProperty( value = "shows_active" )
        private int showsActive;

        @JsonProperty( value = "shows_total" )
        private int showsTotal;

        public Builder episodesDownloaded( int episodesDownloaded )
        {
            this.episodesDownloaded = episodesDownloaded;
            return this;
        }

        public Builder episodesTotal( int episodesTotal )
        {
            this.episodesTotal = episodesTotal;
            return this;
        }

        public Builder showsActive( int showsActive )
        {
            this.showsActive = showsActive;
            return this;
        }

        public Builder showsTotal( int showsTotal )
        {
            this.showsTotal = showsTotal;
            return this;
        }

        public ShowsStats build()
        {
            return new ShowsStats( this );
        }
    }

    private int episodesDownloaded;
    private int episodesTotal;
    private int showsActive;
    private int showsTotal;

    private ShowsStats( Builder builder )
    {
        this.episodesDownloaded = builder.episodesDownloaded;
        this.episodesTotal = builder.episodesTotal;
        this.showsActive = builder.showsActive;
        this.showsTotal = builder.showsTotal;
    }

    public int getEpisodesDownloaded()
    {
        return episodesDownloaded;
    }

    public int getEpisodesTotal()
    {
        return episodesTotal;
    }

    public int getShowsActive()
    {
        return showsActive;
    }

    public int getShowsTotal()
    {
        return showsTotal;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "ShowsStats{episodesDownloaded=" );
        builder2.append( episodesDownloaded );
        builder2.append( ", episodesTotal=" );
        builder2.append( episodesTotal );
        builder2.append( ", showsActive=" );
        builder2.append( showsActive );
        builder2.append( ", showsTotal=" );
        builder2.append( showsTotal );
        builder2.append( "}" );
        return builder2.toString();
    }
}
