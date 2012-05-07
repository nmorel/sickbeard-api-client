package com.github.nmorel.sickbeard.generator.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class WebRequest
{

    public static Document getHtmlDocument( URL url )
        throws IOException, SAXException
    {
        return getHtmlDocument( url.openConnection() );
    }

    public static Document getHtmlDocument( URLConnection connection )
        throws IOException, SAXException
    {
        return getHtmlDocument( getReader( connection ) );
    }

    public static Reader getReader( URLConnection connection )
        throws IOException
    {
        try
        {
            connection.addRequestProperty( "Accept-Encoding", "gzip,deflate" );
            connection.addRequestProperty( "Accept-Charset", "UTF-8,ISO-8859-1" );
        }
        catch ( IllegalStateException e )
        {
            // too bad, can't request gzipped document anymore
        }

        Charset charset = getCharset( connection.getContentType() );
        String encoding = connection.getContentEncoding();

        InputStream inputStream = connection.getInputStream();

        if ( "gzip".equalsIgnoreCase( encoding ) )
            inputStream = new GZIPInputStream( inputStream );
        else if ( "deflate".equalsIgnoreCase( encoding ) )
        {
            inputStream = new InflaterInputStream( inputStream, new Inflater( true ) );
        }

        return new InputStreamReader( inputStream, charset );
    }

    public static Document getHtmlDocument( Reader reader )
        throws SAXException, IOException
    {
        DOMParser parser = new DOMParser();
        parser.setFeature( "http://xml.org/sax/features/namespaces", false );
        parser.parse( new InputSource( reader ) );

        return parser.getDocument();
    }

    public static Document getDocument( URL url )
        throws IOException, SAXException
    {
        return getDocument( url.openConnection() );
    }

    public static Document getDocument( URLConnection connection )
        throws IOException, SAXException
    {
        return getDocument( new InputSource( getReader( connection ) ) );
    }

    public static Document getDocument( InputSource source )
        throws IOException, SAXException
    {
        try
        {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( source );
        }
        catch ( ParserConfigurationException e )
        {
            // will never happen
            throw new RuntimeException( e );
        }
    }

    private static Charset getCharset( String contentType )
    {
        if ( contentType != null )
        {
            // e.g. Content-Type: text/html; charset=iso-8859-1
            Matcher matcher = Pattern.compile( "charset=(\\p{Graph}+)" ).matcher( contentType );

            if ( matcher.find() )
            {
                try
                {
                    return Charset.forName( matcher.group( 1 ) );
                }
                catch ( IllegalArgumentException e )
                {
                    e.printStackTrace();
                }
            }

            // use http default encoding only for text/html
            if ( contentType.equals( "text/html" ) )
            {
                return Charset.forName( "ISO-8859-1" );
            }
        }

        // use UTF-8 if we don't know any better
        return Charset.forName( "UTF-8" );
    }

    public static String encodeParameters( Map<String, String> parameters )
    {
        StringBuilder sb = new StringBuilder();

        for ( Entry<String, String> entry : parameters.entrySet() )
        {
            if ( sb.length() > 0 )
                sb.append( "&" );

            sb.append( entry.getKey() );
            sb.append( "=" );

            try
            {
                sb.append( URLEncoder.encode( entry.getValue(), "UTF-8" ) );
            }
            catch ( UnsupportedEncodingException e )
            {
                // will never happen
                throw new RuntimeException( e );
            }
        }

        return sb.toString();
    }

    /**
     * Dummy constructor to prevent instantiation.
     */
    private WebRequest()
    {
        throw new UnsupportedOperationException();
    }
}
