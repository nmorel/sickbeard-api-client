package com.github.nmorel.sickbeard.model.result;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.enums.Quality;
import com.github.nmorel.sickbeard.model.result.QualityDetails.Builder;

@JsonDeserialize( builder = Builder.class )
public class QualityDetails
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private List<Quality> archive;
        private List<Quality> initial;

        public Builder archive( List<Quality> archive )
        {
            this.archive = archive;
            return this;
        }

        public Builder initial( List<Quality> initial )
        {
            this.initial = initial;
            return this;
        }

        public QualityDetails build()
        {
            return new QualityDetails( this );
        }
    }

    private List<Quality> archive;
    private List<Quality> initial;

    private QualityDetails( Builder builder )
    {
        this.archive = Collections.unmodifiableList( builder.archive );
        this.initial = Collections.unmodifiableList( builder.initial );
    }

    public List<Quality> getArchive()
    {
        return archive;
    }

    public List<Quality> getInitial()
    {
        return initial;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "QualityDetails{archive=" );
        builder2.append( archive );
        builder2.append( ", initial=" );
        builder2.append( initial );
        builder2.append( "}" );
        return builder2.toString();
    }

}
