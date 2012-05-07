package com.github.nmorel.sickbeard.generator;

import com.github.nmorel.sickbeard.generator.parameters.Parameters;
import com.github.nmorel.sickbeard.generator.result.Result;

public class Command
{
    private String name;

    private String description;

    private Parameters parameters;

    private Result result;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Parameters getParameters()
    {
        return parameters;
    }

    public void setParameters( Parameters parameters )
    {
        this.parameters = parameters;
    }

    public Result getResult()
    {
        return result;
    }

    public void setResult( Result result )
    {
        this.result = result;
    }

}
