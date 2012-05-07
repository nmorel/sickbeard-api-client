package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.Ping.Builder;

@JsonDeserialize( builder = Builder.class )
public class Ping
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private int pid;

        public Builder pid( int pid )
        {
            this.pid = pid;
            return this;
        }

        public Ping build()
        {
            return new Ping( this );
        }
    }

    private int pid;

    private Ping( Builder builder )
    {
        this.pid = builder.pid;
    }

    public int getPid()
    {
        return pid;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Ping{pid=" );
        builder.append( pid );
        builder.append( "}" );
        return builder.toString();
    }
}
