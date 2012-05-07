<#include "package.ftl"><#nt>

<#include "imports.ftl">

public interface ${className}<#include "extends.ftl">
{
<#list methods as method>
    ${method.returnType} ${method.name}(<#list method.parameters as param>${param.type} ${param.name}<#if param_has_next>, </#if></#list>);
<#if method_has_next>

</#if>
</#list>
}