package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.ShowAdd.Builder;

@JsonDeserialize( builder = Builder.class )
public class ShowAdd
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private String name;

        public Builder name( String name )
        {
            this.name = name;
            return this;
        }

        public ShowAdd build()
        {
            return new ShowAdd( this );
        }
    }

    private String name;

    private ShowAdd( Builder builder )
    {
        this.name = builder.name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "ShowAdd{name=" );
        builder2.append( name );
        builder2.append( "}" );
        return builder2.toString();
    }

}
