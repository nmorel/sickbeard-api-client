package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.Message.Builder;

@JsonDeserialize( builder = Builder.class )
public class Message
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private String message;
        private String title;
        private String type;

        public Builder message( String message )
        {
            this.message = message;
            return this;
        }

        public Builder title( String title )
        {
            this.title = title;
            return this;
        }

        public Builder type( String type )
        {
            this.type = type;
            return this;
        }

        public Message build()
        {
            return new Message( this );
        }
    }

    private String message;
    private String title;
    private String type;

    private Message( Builder builder )
    {
        this.message = builder.message;
        this.title = builder.title;
        this.type = builder.type;
    }

    public String getMessage()
    {
        return message;
    }

    public String getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "Message{message=" );
        builder2.append( message );
        builder2.append( ", title=" );
        builder2.append( title );
        builder2.append( ", type=" );
        builder2.append( type );
        builder2.append( "}" );
        return builder2.toString();
    }

}
