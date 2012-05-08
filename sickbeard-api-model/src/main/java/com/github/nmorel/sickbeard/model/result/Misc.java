package com.github.nmorel.sickbeard.model.result;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.Misc.Builder;

@JsonDeserialize( builder = Builder.class )
public class Misc
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "api_commands" )
        private List<String> apiCommands;

        @JsonProperty( value = "api_version" )
        private String apiVersion;

        @JsonProperty( value = "sb_version" )
        private String sbVersion;

        public Builder apiCommands( List<String> apiCommands )
        {
            this.apiCommands = apiCommands;
            return this;
        }

        public Builder apiVersion( String apiVersion )
        {
            this.apiVersion = apiVersion;
            return this;
        }

        public Builder sbVersion( String sbVersion )
        {
            this.sbVersion = sbVersion;
            return this;
        }

        public Misc build()
        {
            return new Misc( this );
        }
    }

    private List<String> apiCommands;
    private String apiVersion;
    private String sbVersion;

    private Misc( Builder builder )
    {
        this.apiCommands = Collections.unmodifiableList( builder.apiCommands );
        this.apiVersion = builder.apiVersion;
        this.sbVersion = builder.sbVersion;
    }

    public List<String> getApiCommands()
    {
        return apiCommands;
    }

    public String getApiVersion()
    {
        return apiVersion;
    }

    public String getSbVersion()
    {
        return sbVersion;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "Misc{apiCommands=" );
        builder2.append( apiCommands );
        builder2.append( ", apiVersion=" );
        builder2.append( apiVersion );
        builder2.append( ", sbVersion=" );
        builder2.append( sbVersion );
        builder2.append( "}" );
        return builder2.toString();
    }
}
