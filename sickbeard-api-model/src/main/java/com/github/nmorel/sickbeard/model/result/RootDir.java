package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.RootDir.Builder;

@JsonDeserialize( builder = Builder.class )
public class RootDir
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( value = "default" )
        private boolean defaultDir;

        private String location;

        private boolean valid;

        public Builder defaultDir( boolean defaultDir )
        {
            this.defaultDir = defaultDir;
            return this;
        }

        public Builder location( String location )
        {
            this.location = location;
            return this;
        }

        public Builder valid( boolean valid )
        {
            this.valid = valid;
            return this;
        }

        public RootDir build()
        {
            return new RootDir( this );
        }
    }

    private boolean defaultDir;
    private String location;
    private boolean valid;

    private RootDir( Builder builder )
    {
        this.defaultDir = builder.defaultDir;
        this.location = builder.location;
        this.valid = builder.valid;
    }

    public boolean isDefaultDir()
    {
        return defaultDir;
    }

    public String getLocation()
    {
        return location;
    }

    public boolean isValid()
    {
        return valid;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "RootDir{defaultDir=" );
        builder2.append( defaultDir );
        builder2.append( ", location=" );
        builder2.append( location );
        builder2.append( ", valid=" );
        builder2.append( valid );
        builder2.append( "}" );
        return builder2.toString();
    }

}
