package com.github.nmorel.sickbeard.client;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SickBeardConfig
{
    private HttpClient client;

    private String url;

    private ObjectMapper mapper;

    private SickBeardConfig( Builder builder )
    {
        if ( null == builder.url )
        {
            throw new IllegalArgumentException( "url is mandatory" );
        }
        this.url = builder.url;
        if ( null == builder.client )
        {
            // Create default client
            client = new DefaultHttpClient();
        }
        else
        {
            client = builder.client;
        }
        if ( null == builder.mapper )
        {
            mapper = new ObjectMapper();
        }
        else
        {
            mapper = builder.mapper;
        }
    }

    public HttpClient getClient()
    {
        return client;
    }

    public String getUrl()
    {
        return url;
    }

    public ObjectMapper getMapper()
    {
        return mapper;
    }

    public static class Builder
    {
        private HttpClient client;
        private String url;
        private ObjectMapper mapper;

        public Builder withUrl( String url )
        {
            this.url = url;
            return this;
        }

        public Builder withClient( HttpClient client )
        {
            this.client = client;
            return this;
        }

        public Builder withMapper( ObjectMapper mapper )
        {
            this.mapper = mapper;
            return this;
        }

        public SickBeardConfig build()
        {
            return new SickBeardConfig( this );
        }
    }

}
