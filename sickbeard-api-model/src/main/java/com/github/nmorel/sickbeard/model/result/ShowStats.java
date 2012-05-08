package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.ShowStats.Builder;

@JsonDeserialize( builder = Builder.class )
public class ShowStats
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private int archived;
        private ShowDownloadStats downloaded;
        private int ignored;
        private int skipped;
        private ShowDownloadStats snatched;
        private int total;
        private int unaired;
        private int wanted;

        public Builder archived( int archived )
        {
            this.archived = archived;
            return this;
        }

        public Builder downloaded( ShowDownloadStats downloaded )
        {
            this.downloaded = downloaded;
            return this;
        }

        public Builder ignored( int ignored )
        {
            this.ignored = ignored;
            return this;
        }

        public Builder skipped( int skipped )
        {
            this.skipped = skipped;
            return this;
        }

        public Builder snatched( ShowDownloadStats snatched )
        {
            this.snatched = snatched;
            return this;
        }

        public Builder total( int total )
        {
            this.total = total;
            return this;
        }

        public Builder unaired( int unaired )
        {
            this.unaired = unaired;
            return this;
        }

        public Builder wanted( int wanted )
        {
            this.wanted = wanted;
            return this;
        }

        public ShowStats build()
        {
            return new ShowStats( this );
        }
    }

    private int archived;
    private ShowDownloadStats downloaded;
    private int ignored;
    private int skipped;
    private ShowDownloadStats snatched;
    private int total;
    private int unaired;
    private int wanted;

    private ShowStats( Builder builder )
    {
        this.archived = builder.archived;
        this.downloaded = builder.downloaded;
        this.ignored = builder.ignored;
        this.skipped = builder.skipped;
        this.snatched = builder.snatched;
        this.total = builder.total;
        this.unaired = builder.unaired;
        this.wanted = builder.wanted;
    }

    public int getArchived()
    {
        return archived;
    }

    public ShowDownloadStats getDownloaded()
    {
        return downloaded;
    }

    public int getIgnored()
    {
        return ignored;
    }

    public int getSkipped()
    {
        return skipped;
    }

    public ShowDownloadStats getSnatched()
    {
        return snatched;
    }

    public int getTotal()
    {
        return total;
    }

    public int getUnaired()
    {
        return unaired;
    }

    public int getWanted()
    {
        return wanted;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "ShowStats{archived=" );
        builder2.append( archived );
        builder2.append( ", downloaded=" );
        builder2.append( downloaded );
        builder2.append( ", ignored=" );
        builder2.append( ignored );
        builder2.append( ", skipped=" );
        builder2.append( skipped );
        builder2.append( ", snatched=" );
        builder2.append( snatched );
        builder2.append( ", total=" );
        builder2.append( total );
        builder2.append( ", unaired=" );
        builder2.append( unaired );
        builder2.append( ", wanted=" );
        builder2.append( wanted );
        builder2.append( "}" );
        return builder2.toString();
    }

}
