package com.github.nmorel.sickbeard.model.result;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.nmorel.sickbeard.model.result.Future.Builder;

@JsonDeserialize( builder = Builder.class )
public class Future
{
    @JsonPOJOBuilder( withPrefix = "" )
    public static class Builder
    {
        private List<FutureEpisode> later;
        private List<FutureEpisode> missed;
        private List<FutureEpisode> soon;
        private List<FutureEpisode> today;

        public Builder later( List<FutureEpisode> later )
        {
            this.later = later;
            return this;
        }

        public Builder missed( List<FutureEpisode> missed )
        {
            this.missed = missed;
            return this;
        }

        public Builder soon( List<FutureEpisode> soon )
        {
            this.soon = soon;
            return this;
        }

        public Builder today( List<FutureEpisode> today )
        {
            this.today = today;
            return this;
        }

        public Future build()
        {
            return new Future( this );
        }
    }

    private List<FutureEpisode> later;
    private List<FutureEpisode> missed;
    private List<FutureEpisode> soon;
    private List<FutureEpisode> today;

    private Future( Builder builder )
    {
        if ( null == builder.later )
        {
            this.later = Collections.emptyList();
        }
        else
        {
            this.later = Collections.unmodifiableList( builder.later );
        }

        if ( null == builder.missed )
        {
            this.missed = Collections.emptyList();
        }
        else
        {
            this.missed = Collections.unmodifiableList( builder.missed );
        }

        if ( null == builder.soon )
        {
            this.soon = Collections.emptyList();
        }
        else
        {
            this.soon = Collections.unmodifiableList( builder.soon );
        }

        if ( null == builder.today )
        {
            this.today = Collections.emptyList();
        }
        else
        {
            this.today = Collections.unmodifiableList( builder.today );
        }
    }

    public List<FutureEpisode> getLater()
    {
        return later;
    }

    public List<FutureEpisode> getMissed()
    {
        return missed;
    }

    public List<FutureEpisode> getSoon()
    {
        return soon;
    }

    public List<FutureEpisode> getToday()
    {
        return today;
    }

    @Override
    public String toString()
    {
        StringBuilder builder2 = new StringBuilder();
        builder2.append( "Future{later=" );
        builder2.append( later );
        builder2.append( ", missed=" );
        builder2.append( missed );
        builder2.append( ", soon=" );
        builder2.append( soon );
        builder2.append( ", today=" );
        builder2.append( today );
        builder2.append( "}" );
        return builder2.toString();
    }

}
