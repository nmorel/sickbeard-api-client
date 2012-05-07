package com.github.nmorel.sickbeard.generator;

import java.io.File;

import com.github.nmorel.sickbeard.generator.parameters.Parameters;

public class CommandInfo
{
    private String usage;

    private Parameters parameters;

    private File resultExampleFile;

    public String getUsage()
    {
        return usage;
    }

    public void setUsage( String usage )
    {
        this.usage = usage;
    }

    public Parameters getParameters()
    {
        return parameters;
    }

    public void setParameters( Parameters parameters )
    {
        this.parameters = parameters;
    }

    public File getResultExampleFile()
    {
        return resultExampleFile;
    }

    public void setResultExampleFile( File resultExampleFile )
    {
        this.resultExampleFile = resultExampleFile;
    }

    @Override
    public String toString()
    {
        return "CommandInfo [usage=" + usage + ", parameters=" + parameters + ", resultExampleFile=" + resultExampleFile + "]";
    }

}
