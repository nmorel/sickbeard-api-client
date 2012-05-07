package com.github.nmorel.sickbeard.generator.parameters;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.nmorel.sickbeard.generator.AllowedValuesDeserializer;

public class Parameter
{
    @JsonDeserialize( using = AllowedValuesDeserializer.class )
    private List<Object> allowedValues;

    private Object defaultValue;

    private String desc;

    public List<Object> getAllowedValues()
    {
        return allowedValues;
    }

    public void setAllowedValues( List<Object> allowedValues )
    {
        this.allowedValues = allowedValues;
    }

    public Object getDefaultValue()
    {
        return defaultValue;
    }

    public void setDefaultValue( Object defaultValue )
    {
        this.defaultValue = defaultValue;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc( String desc )
    {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return "SickBeardParameter [allowedValues=" + allowedValues + ", defaultValue=" + defaultValue + ", desc=" + desc + "]";
    }

}
