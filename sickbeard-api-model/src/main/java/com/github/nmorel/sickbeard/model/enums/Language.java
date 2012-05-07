package com.github.nmorel.sickbeard.model.enums;

public enum Language
{
    EN( 7, "en", "English" ),
    SV( 8, "sv", "Svenska" ),
    NO( 9, "no", "Norsk" ),
    DA( 10, "da", "Dansk" ),
    FI( 11, "fi", "Suomeksi" ),
    NL( 13, "nl", "Nederlands" ),
    DE( 14, "de", "Deutsch" ),
    IT( 15, "it", "Italiano" ),
    ES( 16, "es", "Espa\u00f1ol" ),
    FR( 17, "fr", "Fran\u00e7ais" ),
    PL( 18, "pl", "Polski" ),
    HU( 19, "hu", "Magyar" ),
    EL( 20, "el", "\u0395\u03bb\u03bb\u03b7\u03bd\u03b9\u03ba\u03ac" ),
    TR( 21, "tr", "T\u00fcrk\u00e7e" ),
    RU( 22, "ru", "\u0440\u0443\u0441\u0441\u043a\u0438\u0439 \u044f\u0437\u044b\u043a" ),
    HE( 24, "he", " \u05e2\u05d1\u05e8\u05d9\u05ea" ),
    JA( 25, "ja", "\u65e5\u672c\u8a9e" ),
    PT( 26, "pt", "Portugu\u00eas" ),
    ZH( 27, "zh", "\u4e2d\u6587" ),
    CS( 28, "cs", "\u010de\u0161tina" ),
    SL( 30, "sl", "Slovenski" ),
    HR( 31, "hr", "Hrvatski" ),
    KO( 32, "ko", "\ud55c\uad6d\uc5b4" );

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