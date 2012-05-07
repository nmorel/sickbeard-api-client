package com.github.nmorel.sickbeard.model.result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.ResultEnumDeserializer;
import com.github.nmorel.sickbeard.model.enums.ResultEnum;
import com.github.nmorel.sickbeard.model.result.SickBeardResult.Builder;

@JsonDeserialize( builder = Builder.class )
public class SickBeardResult
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private JsonNode data;

        private String message;

        @JsonDeserialize( using = ResultEnumDeserializer.class )
        private ResultEnum result;

        public Builder data( JsonNode data )
        {
            this.data = data;
            return this;
        }

        public Builder message( String message )
        {
            this.message = message;
            return this;
        }

        public Builder result( ResultEnum result )
        {
            this.result = result;
            return this;
        }

        public SickBeardResult build()
        {
            return new SickBeardResult( this );
        }
    }

    private JsonNode data;
    private String message;
    private ResultEnum result;

    private SickBeardResult( Builder builder )
    {
        this.data = builder.data;
        this.message = builder.message;
        this.result = builder.result;
    }

    public JsonNode getData()
    {
        return data;
    }

    public String getMessage()
    {
        return message;
    }

    public ResultEnum getResult()
    {
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "SickBeardResult{data=" );
        builder.append( data );
        builder.append( ", message=" );
        builder.append( message );
        builder.append( ", result=" );
        builder.append( result );
        builder.append( "}" );
        return builder.toString();
    }
}
