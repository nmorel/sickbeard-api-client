package com.github.nmorel.sickbeard.model.result;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.enums.Status;
import com.github.nmorel.sickbeard.model.result.Defaults.Builder;

@JsonDeserialize( builder = Builder.class )
public class Defaults
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private List<Quality> archive;

        @JsonProperty( value = "future_show_paused" )
        private boolean futureShowPaused;

        private List<Quality> initial;

        @JsonProperty( value = "season_folders" )
        private boolean seasonFolders;

        private Status status;

        public Builder archive( List<Quality> archive )
        {
            this.archive = archive;
            return this;
        }

        public Builder futureShowPaused( boolean futureShowPaused )
        {
            this.futureShowPaused = futureShowPaused;
            return this;
        }

        public Builder initial( List<Quality> initial )
        {
            this.initial = initial;
            return this;
        }

        public Builder seasonFolders( boolean seasonFolders )
        {
            this.seasonFolders = seasonFolders;
            return this;
        }

        public Builder status( Status status )
        {
            this.status = status;
            return this;
        }

        public Defaults build()
        {
            return new Defaults( this );
        }
    }

    private List<Quality> archive;
    private boolean futureShowPaused;
    private List<Quality> initial;
    private boolean seasonFolders;
    private Status status;

    private Defaults( Builder builder )
    {
        this.archive = Collections.unmodifiableList( builder.archive );
        this.futureShowPaused = builder.futureShowPaused;
        this.initial = Collections.unmodifiableList( builder.initial );
        this.seasonFolders = builder.seasonFolders;
        this.status = builder.status;
    }

    public List<Quality> getArchive()
    {
        return archive;
    }

    public boolean isFutureShowPaused()
    {
        return futureShowPaused;
    }

    public List<Quality> getInitial()
    {
        return initial;
    }

    public boolean isSeasonFolders()
    {
        return seasonFolders;
    }

    public Status getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "Defaults{archive=" );
        builder2.append( archive );
        builder2.append( ", futureShowPaused=" );
        builder2.append( futureShowPaused );
        builder2.append( ", initial=" );
        builder2.append( initial );
        builder2.append( ", seasonFolders=" );
        builder2.append( seasonFolders );
        builder2.append( ", status=" );
        builder2.append( status );
        builder2.append( "}" );
        return builder2.toString();
    }
}
