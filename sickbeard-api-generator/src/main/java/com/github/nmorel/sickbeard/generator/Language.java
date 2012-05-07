package com.github.nmorel.sickbeard.generator;

public class Language
    implements Comparable<Language>
{
    private String name;
    private int id;
    private String abbreviation;

    public Language( String name, int id, String abbreviation )
    {
        super();
        this.name = name;
        this.id = id;
        this.abbreviation = abbreviation;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }

    public void setAbbreviation( String abbreviation )
    {
        this.abbreviation = abbreviation;
    }

    @Override
    public int compareTo( Language o )
    {
        return Integer.compare( this.id, o.id );
    }

}
