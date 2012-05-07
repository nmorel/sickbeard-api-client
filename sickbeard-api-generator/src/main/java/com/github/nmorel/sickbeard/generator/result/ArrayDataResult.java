package com.github.nmorel.sickbeard.generator.result;

public class ArrayDataResult
    extends DataResult
{
    private DataResult data;

    public ArrayDataResult( DataResult data )
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
