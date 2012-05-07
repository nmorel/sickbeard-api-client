package com.github.nmorel.sickbeard.generator.result;

public class StandardJsonResult
    extends Result
{
    private DataResult data;

    public StandardJsonResult( DataResult data )
    {
        this.data = data;
    }

    public DataResult getData()
    {
        return data;
    }

    public void setData( DataResult data )
    {
        this.data = data;
    }

}
