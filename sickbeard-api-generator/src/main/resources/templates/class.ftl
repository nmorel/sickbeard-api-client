<#include "package.ftl"><#nt>

<#include "imports.ftl">

public class ${className}<#include "extends.ftl"><#include "implements.ftl">
{
<#list methods as method>
    public ${method.returnType} ${method.name}(<#list method.parameters as param>${param.type} ${param.name}<#if param_has_next>, </#if></#list>)
    {
    	System.out.println(${method.name});
    }
<#if method_has_next>

</#if>
</#list>
}