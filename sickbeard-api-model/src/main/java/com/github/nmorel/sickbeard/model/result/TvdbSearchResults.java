package com.github.nmorel.sickbeard.model.result;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.deserializer.TvdbLangIdToLanguage;
import com.github.nmorel.sickbeard.model.enums.Language;
import com.github.nmorel.sickbeard.model.result.TvdbSearchResults.Builder;

@JsonDeserialize( builder = Builder.class )
public class TvdbSearchResults
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        @JsonProperty( "langid" )
        @JsonDeserialize( using = TvdbLangIdToLanguage.class )
        private Language language;

        private List<TvdbSearchResult> results;

        public Builder language( Language language )
        {
            this.language = language;
            return this;
        }

        public Builder results( List<TvdbSearchResult> results )
        {
            this.results = results;
            return this;
        }

        public TvdbSearchResults build()
        {
            return new TvdbSearchResults( this );
        }
    }

    private Language language;
    private List<TvdbSearchResult> results;

    private TvdbSearchResults( Builder builder )
    {
        this.language = builder.language;
        this.results = Collections.unmodifiableList( builder.results );
    }

    public Language getLanguage()
    {
        return language;
    }

    public List<TvdbSearchResult> getResults()
    {
        return results;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "TvdbSearchResults{language=" );
        builder2.append( language );
        builder2.append( ", results=" );
        builder2.append( results );
        builder2.append( "}" );
        return builder2.toString();
    }
}
