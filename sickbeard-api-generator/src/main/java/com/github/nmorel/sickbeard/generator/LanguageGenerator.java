package com.github.nmorel.sickbeard.generator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class LanguageGenerator
{

    /**
     * @param args
     * @throws IOException
     * @throws TemplateException
     * @throws JAXBException
     * @throws JDOMException
     */
    public static void main( String[] args )
        throws IOException, TemplateException, JAXBException, JDOMException
    {
        File languagesFile = new File( "src/main/resources", "languages.xml" );

        Configuration cfg = new Configuration();
        // Specify the data source where the template files come from.
        // Here I set a file directory for it:
        cfg.setDirectoryForTemplateLoading( new File( "src/main/resources/templates" ) );
        // Specify how templates will see the data-model. This is an advanced topic...
        // but just use this:
        cfg.setObjectWrapper( new DefaultObjectWrapper() );

        Map<String, List<Language>> map = new HashMap<String, List<Language>>();
        List<Language> listLanguage = new ArrayList<Language>();
        map.put( "languages", listLanguage );

        SAXBuilder sxb = new SAXBuilder();
        Document document = sxb.build( languagesFile );
        for ( Element elem : document.getRootElement().getChildren( "Language" ) )
        {
            listLanguage
                .add( new Language( elem.getChildText( "name" ), new Integer( elem.getChildText( "id" ) ), elem.getChildText( "abbreviation" ) ) );
        }

        Collections.sort( listLanguage );

        Template template = cfg.getTemplate( "language.ftl" );

        Writer out = new OutputStreamWriter( System.out );
        template.process( map, out );
        out.flush();
    }

}
