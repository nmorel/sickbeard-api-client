package com.github.nmorel.sickbeard.model.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.CountdownDeserializer;
import com.github.nmorel.sickbeard.model.deserializer.DateDeserializer;
import com.github.nmorel.sickbeard.model.result.Scheduler.Builder;

@JsonDeserialize( builder = Builder.class )
public class Scheduler
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "backlog_is_paused" )
        private boolean backlogPaused;

        @JsonProperty( value = "backlog_is_running" )
        private boolean backlogRunning;

        @JsonDeserialize( using = DateDeserializer.class )
        @JsonProperty( value = "last_backlog" )
        private Date lastBacklog;

        @JsonDeserialize( using = DateDeserializer.class )
        @JsonProperty( value = "next_backlog" )
        private Date nextBacklog;

        @JsonDeserialize( using = CountdownDeserializer.class )
        @JsonProperty( value = "next_search" )
        private Date nextSearch;

        @JsonProperty( value = "search_is_running" )
        private boolean searchRunning;

        public Builder backlogPaused( boolean backlogPaused )
        {
            this.backlogPaused = backlogPaused;
            return this;
        }

        public Builder backlogRunning( boolean backlogRunning )
        {
            this.backlogRunning = backlogRunning;
            return this;
        }

        public Builder lastBacklog( Date lastBacklog )
        {
            this.lastBacklog = lastBacklog;
            return this;
        }

        public Builder nextBacklog( Date nextBacklog )
        {
            this.nextBacklog = nextBacklog;
            return this;
        }

        public Builder nextSearch( Date nextSearch )
        {
            this.nextSearch = nextSearch;
            return this;
        }

        public Builder searchRunning( boolean searchRunning )
        {
            this.searchRunning = searchRunning;
            return this;
        }

        public Scheduler build()
        {
            return new Scheduler( this );
        }
    }

    private boolean backlogPaused;
    private boolean backlogRunning;
    private Date lastBacklog;
    private Date nextBacklog;
    private Date nextSearch;
    private boolean searchRunning;

    private Scheduler( Builder builder )
    {
        this.backlogPaused = builder.backlogPaused;
        this.backlogRunning = builder.backlogRunning;
        this.lastBacklog = builder.lastBacklog;
        this.nextBacklog = builder.nextBacklog;
        this.nextSearch = builder.nextSearch;
        this.searchRunning = builder.searchRunning;
    }

    public boolean isBacklogPaused()
    {
        return backlogPaused;
    }

    public boolean isBacklogRunning()
    {
        return backlogRunning;
    }

    public Date getLastBacklog()
    {
        return lastBacklog;
    }

    public Date getNextBacklog()
    {
        return nextBacklog;
    }

    public Date getNextSearch()
    {
        return nextSearch;
    }

    public boolean isSearchRunning()
    {
        return searchRunning;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "CheckScheduler{backlogPaused=" );
        builder2.append( backlogPaused );
        builder2.append( ", backlogRunning=" );
        builder2.append( backlogRunning );
        builder2.append( ", lastBacklog=" );
        builder2.append( lastBacklog );
        builder2.append( ", nextBacklog=" );
        builder2.append( nextBacklog );
        builder2.append( ", nextSearch=" );
        builder2.append( nextSearch );
        builder2.append( ", searchRunning=" );
        builder2.append( searchRunning );
        builder2.append( "}" );
        return builder2.toString();
    }

}
