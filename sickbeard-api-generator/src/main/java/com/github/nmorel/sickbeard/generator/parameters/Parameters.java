package com.github.nmorel.sickbeard.generator.parameters;

import java.util.Map;

public class Parameters
{
    private Map<String, Parameter> optionalParameters;
    private Map<String, Parameter> requiredParameters;

    public Map<String, Parameter> getOptionalParameters()
    {
        return optionalParameters;
    }

    public void setOptionalParameters( Map<String, Parameter> optionalParameters )
    {
        this.optionalParameters = optionalParameters;
    }

    public Map<String, Parameter> getRequiredParameters()
    {
        return requiredParameters;
    }

    public void setRequiredParameters( Map<String, Parameter> requiredParameters )
    {
        this.requiredParameters = requiredParameters;
    }

    @Override
    public String toString()
    {
        return "SickBeardHelp [optionalParameters=" + optionalParameters + ", requiredParameters=" + requiredParameters + "]";
    }

}
