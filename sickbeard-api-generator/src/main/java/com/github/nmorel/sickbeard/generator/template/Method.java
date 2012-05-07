package com.github.nmorel.sickbeard.generator.template;

import java.util.List;

public class Method
{
    private String name;

    private String returnType;

    private List<Parameter> parameters;

    public Method( String name, String returnType, List<Parameter> parameters )
    {
        super();
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getReturnType()
    {
        return returnType;
    }

    public void setReturnType( String returnType )
    {
        this.returnType = returnType;
    }

    public List<Parameter> getParameters()
    {
        return parameters;
    }

    public void setParameters( List<Parameter> parameters )
    {
        this.parameters = parameters;
    }

}
