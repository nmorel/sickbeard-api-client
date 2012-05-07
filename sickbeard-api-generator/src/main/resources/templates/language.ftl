package com.github.nmorel.sickbeard.model.enums;

public enum Language
{
<#list languages as lg>
    ${lg.abbreviation?upper_case}( ${lg.id}, "${lg.abbreviation}", "${lg.name}" )<#if lg_has_next>,<#else>;</#if>
</#list>

    private int tvdbId;
    private String tvdbAbbreviation;
    private String tvdbName;

    private Language( int tvdbId, String tvdbAbbreviation, String tvdbName )
    {
        this.tvdbId = tvdbId;
        this.tvdbAbbreviation = tvdbAbbreviation;
        this.tvdbName = tvdbName;
    }

    public int getTvdbId()
    {
        return tvdbId;
    }

    public String getTvdbAbbreviation()
    {
        return tvdbAbbreviation;
    }

    public String getTvdbName()
    {
        return tvdbName;
    }

    public static Language fromTvdbId( int id )
    {
        for ( Language language : values() )
        {
            if ( language.getTvdbId() == id )
            {
                return language;
            }
        }
        return null;
    }

    public static Language fromTvdbAbbreviation( String abbreviation )
    {
        if ( null != abbreviation )
        {
            for ( Language language : values() )
            {
                if ( language.getTvdbAbbreviation().equalsIgnoreCase( abbreviation ) )
                {
                    return language;
                }
            }
        }
        return null;
    }

}