package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.ShowDownloadStats.Builder;

@JsonDeserialize( builder = Builder.class )
public class ShowDownloadStats
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "1080p_bluray" )
        private int fullHdBluray;

        @JsonProperty( value = "720p_bluray" )
        private int hdBluray;

        @JsonProperty( value = "720p_web-dl" )
        private int hdWebDl;

        @JsonProperty( value = "hd_tv" )
        private int hdTv;

        @JsonProperty( value = "sd_dvd" )
        private int sdDvd;

        @JsonProperty( value = "sd_tv" )
        private int sdTv;

        private int total;

        private int unknown;

        public Builder fullHdBluray( int fullHdBluray )
        {
            this.fullHdBluray = fullHdBluray;
            return this;
        }

        public Builder hdBluray( int hdBluray )
        {
            this.hdBluray = hdBluray;
            return this;
        }

        public Builder hdWebDl( int hdWebDl )
        {
            this.hdWebDl = hdWebDl;
            return this;
        }

        public Builder hdTv( int hdTv )
        {
            this.hdTv = hdTv;
            return this;
        }

        public Builder sdDvd( int sdDvd )
        {
            this.sdDvd = sdDvd;
            return this;
        }

        public Builder sdTv( int sdTv )
        {
            this.sdTv = sdTv;
            return this;
        }

        public Builder total( int total )
        {
            this.total = total;
            return this;
        }

        public Builder unknown( int unknown )
        {
            this.unknown = unknown;
            return this;
        }

        public ShowDownloadStats build()
        {
            return new ShowDownloadStats( this );
        }
    }

    private int fullHdBluray;
    private int hdBluray;
    private int hdWebDl;
    private int hdTv;
    private int sdDvd;
    private int sdTv;
    private int total;
    private int unknown;

    private ShowDownloadStats( Builder builder )
    {
        this.fullHdBluray = builder.fullHdBluray;
        this.hdBluray = builder.hdBluray;
        this.hdWebDl = builder.hdWebDl;
        this.hdTv = builder.hdTv;
        this.sdDvd = builder.sdDvd;
        this.sdTv = builder.sdTv;
        this.total = builder.total;
        this.unknown = builder.unknown;
    }

    public int getFullHdBluray()
    {
        return fullHdBluray;
    }

    public int getHdBluray()
    {
        return hdBluray;
    }

    public int getHdWebDl()
    {
        return hdWebDl;
    }

    public int getHdTv()
    {
        return hdTv;
    }

    public int getSdDvd()
    {
        return sdDvd;
    }

    public int getSdTv()
    {
        return sdTv;
    }

    public int getTotal()
    {
        return total;
    }

    public int getUnknown()
    {
        return unknown;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "ShowDownloadStats{fullHdBluray=" );
        builder2.append( fullHdBluray );
        builder2.append( ", hdBluray=" );
        builder2.append( hdBluray );
        builder2.append( ", hdWebDl=" );
        builder2.append( hdWebDl );
        builder2.append( ", hdTv=" );
        builder2.append( hdTv );
        builder2.append( ", sdDvd=" );
        builder2.append( sdDvd );
        builder2.append( ", sdTv=" );
        builder2.append( sdTv );
        builder2.append( ", total=" );
        builder2.append( total );
        builder2.append( ", unknown=" );
        builder2.append( unknown );
        builder2.append( "}" );
        return builder2.toString();
    }
}
