package com.github.nmorel.sickbeard.generator;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.github.nmorel.sickbeard.generator.template.Method;
import com.github.nmorel.sickbeard.generator.template.Parameter;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class TemplateTest
{
    public static void main( String[] args )
        throws Exception
    {
        Configuration cfg = new Configuration();
        // Specify the data source where the template files come from.
        // Here I set a file directory for it:
        cfg.setDirectoryForTemplateLoading( new File( "src/main/resources/templates" ) );
        // Specify how templates will see the data-model. This is an advanced topic...
        // but just use this:
        cfg.setObjectWrapper( new DefaultObjectWrapper() );

        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "package", "com.github.nmorel.sickbeard.model" );
        map.put( "imports", Arrays.asList( "java.util.List", "java.util.Map" ) );
        map.put( "className", "TestInteface" );
        map.put( "extends", Arrays.asList( "ArrayList" ) );
        map.put( "implements", Arrays.asList( "List" ) );
        map.put(
            "methods",
            Arrays.asList( new Method( "method1", "void", new ArrayList<Parameter>() ),
                new Method( "method2", "Map", Arrays.asList( new Parameter( "int", "key" ), new Parameter( "String", "value" ) ) ) ) );

        Template template = cfg.getTemplate( "class.ftl" );

        Writer out = new OutputStreamWriter( System.out );
        template.process( map, out );
        out.flush();
    }

}
