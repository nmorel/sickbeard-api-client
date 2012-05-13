package com.github.nmorel.sickbeard.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nmorel.sickbeard.generator.parameters.Parameters;
import com.github.nmorel.sickbeard.generator.result.ArrayDataResult;
import com.github.nmorel.sickbeard.generator.result.EmptyDataResult;
import com.github.nmorel.sickbeard.generator.result.ImageResult;
import com.github.nmorel.sickbeard.generator.result.ObjectDataResult;
import com.github.nmorel.sickbeard.generator.result.StandardJsonResult;
import com.github.nmorel.sickbeard.generator.utils.FileUtils;
import com.github.nmorel.sickbeard.generator.utils.WebRequest;
import com.github.nmorel.sickbeard.generator.utils.XPathUtils;
import com.github.nmorel.sickbeard.model.enums.ResultEnum;
import com.github.nmorel.sickbeard.model.result.SickBeardResult;

import freemarker.template.TemplateException;

public class SickBeardGenerator
{
    private static final String EXAMPLES_FOLDER = "target/examples/";

    private static HttpClient client;

    private static String url;

    private static ObjectMapper mapper;

    private static HttpClient getClient()
    {
        if ( null == client )
        {
            client = new DefaultHttpClient();
        }
        return client;
    }

    private static ObjectMapper getMapper()
    {
        if ( null == mapper )
        {
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    public static void main( String[] args )
        throws JsonParseException, JsonMappingException, IOException, SAXException, TemplateException
    {
        url = args[0];

        // retrieve all the commands the api offers
        List<String> apiCommands = retrieveCommands();
        System.out.println( "assertEquals(" + apiCommands.size() + ", misc.getApiCommands().size());" );
        for ( int i = 0; i < apiCommands.size(); i++ )
        {
            System.out
                .println( "assertEquals(\"" + apiCommands.get( i ) + "\", misc.getApiCommands().get(" + i + "));" );
        }

        // retrieve the parameters and description of the commands
        Map<String, CommandInfo> commandInfos = retrieveCommandParameters( apiCommands );

        // retrieve the api examples for each command
        retrieveResultExamples( commandInfos );

        // parse the command infos
        Map<String, List<Command>> groupedCommands = parseCommands( commandInfos );

        generateClass( groupedCommands );
    }

    private static List<String> retrieveCommands()
        throws IOException, JsonParseException, JsonMappingException
    {
        HttpPost method = new HttpPost( url );
        method.setEntity( new UrlEncodedFormEntity( Arrays.asList( new BasicNameValuePair( "cmd", "sb" ) ) ) );
        HttpResponse response = getClient().execute( method );

        SickBeardResult result = getMapper().readValue( response.getEntity().getContent(), SickBeardResult.class );

        List<String> apiCommands =
            getMapper().readValue( result.getData().findValue( "api_commands" ).traverse(),
                new TypeReference<List<String>>() {} );
        return apiCommands;
    }

    private static Map<String, CommandInfo> retrieveCommandParameters( List<String> apiCommands )
        throws IOException, JsonParseException, JsonMappingException
    {
        Map<String, CommandInfo> commandInfos = new LinkedHashMap<String, CommandInfo>();
        for ( String command : apiCommands )
        {
            HttpPost method = new HttpPost( url );
            method.setEntity( new UrlEncodedFormEntity( Arrays.asList( new BasicNameValuePair( "cmd", command ),
                new BasicNameValuePair( "help", "1" ) ) ) );
            HttpResponse response = getClient().execute( method );

            SickBeardResult paramsResult =
                getMapper().readValue( response.getEntity().getContent(), SickBeardResult.class );
            JsonParser parser = paramsResult.getData().traverse();
            parser.setCodec( getMapper() );
            Parameters parameters = getMapper().readValue( parser, Parameters.class );
            CommandInfo info = new CommandInfo();
            info.setUsage( paramsResult.getMessage() );
            info.setParameters( parameters );
            commandInfos.put( command, info );
        }
        return commandInfos;
    }

    private static void retrieveResultExamples( Map<String, CommandInfo> commandInfos )
        throws IOException, SAXException, MalformedURLException
    {
        // Generating the examples
        File examplesFolder = new File( EXAMPLES_FOLDER );
        if ( examplesFolder.exists() )
        {
            for ( File file : examplesFolder.listFiles() )
            {
                file.delete();
            }
        }
        else
        {
            examplesFolder.mkdirs();
        }

        Document dom = WebRequest.getHtmlDocument( new URL( "http://sickbeard.com/api/" ) );

        // retrieve the node containing the api examples
        List<Node> examplesNodes =
            XPathUtils.selectNodes( "//DIV[contains(@id,'api-content')]//DIV[contains(@class,'example')]", dom );

        for ( Node node : examplesNodes )
        {
            String request = XPathUtils.getTextContent( node.getPreviousSibling().getPreviousSibling() );
            int endIndex = request.indexOf( "&" );
            String command;
            if ( endIndex == -1 )
            {
                command = request.substring( request.indexOf( "cmd=" ) + "cmd=".length() );
            }
            else
            {
                command = request.substring( request.indexOf( "cmd=" ) + "cmd=".length(), endIndex );
            }
            Node preOrImg = node.getChildNodes().item( 1 );
            File file;
            if ( "PRE".equalsIgnoreCase( preOrImg.getNodeName() ) )
            {
                file = saveJson( command, XPathUtils.getTextContent( preOrImg ) );
            }
            else if ( "IMG".equalsIgnoreCase( preOrImg.getNodeName() ) )
            {
                file =
                    saveImage( command, "http://sickbeard.com/api/"
                        + XPathUtils.getAttribute( "src", preOrImg ).substring( 2 ) );
            }
            else
            {
                System.out.println( preOrImg.getNodeName() + " non pris en charge" );
                continue;
            }
            commandInfos.get( command ).setResultExampleFile( file );
        }
    }

    private static File saveJson( String command, String json )
        throws IOException
    {
        String filename = command + ".json";
        File destFile = new File( EXAMPLES_FOLDER, filename );
        File fileExists = new File( "src/main/resources/examples", filename );
        if ( fileExists.exists() )
        {
            FileUtils.copy( fileExists, destFile );
        }
        else
        {
            destFile.createNewFile();
            FileWriter writer = new FileWriter( destFile );
            writer.write( json );
            writer.close();
        }
        return destFile;
    }

    private static File saveImage( String command, String imgUrl )
        throws MalformedURLException, IOException
    {
        String filename = command + imgUrl.substring( imgUrl.lastIndexOf( "." ) );
        File file = new File( EXAMPLES_FOLDER, filename );
        file.createNewFile();

        URLConnection connection = new URL( imgUrl ).openConnection();
        int contentLength = connection.getContentLength();
        InputStream in = connection.getInputStream();

        RandomAccessFile randomAccessFile = new RandomAccessFile( file, "rw" );
        randomAccessFile.setLength( contentLength );

        byte buf[] = new byte[1024];
        int len;
        int pos = 0;
        while ( ( len = in.read( buf ) ) > 0 )
        {
            synchronized ( randomAccessFile )
            {
                randomAccessFile.seek( pos );
                randomAccessFile.write( buf, 0, len );
            }
            pos += len;
        }
        in.close();
        randomAccessFile.close();

        return file;
    }

    private static Map<String, List<Command>> parseCommands( Map<String, CommandInfo> commandInfos )
        throws JsonParseException, JsonMappingException, IOException
    {
        Map<String, List<Command>> groupedCommand = new LinkedHashMap<String, List<Command>>();
        for ( Entry<String, CommandInfo> entry : commandInfos.entrySet() )
        {
            Command command = parseCommand( entry.getKey(), entry.getValue() );
            if ( null == command )
            {
                continue;
            }

            String commandName = command.getName();

            String groupBy;
            int indexOf = commandName.indexOf( "." );
            if ( indexOf == -1 )
            {
                groupBy = commandName;
            }
            else
            {
                groupBy = commandName.substring( 0, indexOf );
            }

            List<Command> commands = groupedCommand.get( groupBy );
            if ( null == commands )
            {
                commands = new ArrayList<Command>();
                groupedCommand.put( groupBy, commands );
            }
            commands.add( command );
        }
        return groupedCommand;
    }

    private static Command parseCommand( String name, CommandInfo infos )
        throws JsonParseException, JsonMappingException, IOException
    {
        File exampleFile = infos.getResultExampleFile();
        if ( null == exampleFile || !exampleFile.exists() )
        {
            return null;
        }

        Command command = new Command();
        command.setName( name );
        command.setDescription( infos.getUsage() );
        command.setParameters( infos.getParameters() );

        if ( !exampleFile.getName().endsWith( ".json" ) )
        {
            command.setResult( new ImageResult() );
            return command;
        }

        SickBeardResult result = getMapper().readValue( exampleFile, SickBeardResult.class );

        if ( !ResultEnum.SUCCESS.equals( result.getResult() ) )
        {
            // if there is a failure, the command doesn't work
            return null;
        }

        if ( result.getData().size() == 0 )
        {
            command.setResult( new StandardJsonResult( new EmptyDataResult() ) );
        }
        else if ( result.getData().isArray() )
        {
            command.setResult( new StandardJsonResult( new ArrayDataResult( null ) ) );
        }
        else if ( result.getData().isObject() )
        {
            command.setResult( new StandardJsonResult( new ObjectDataResult() ) );
        }
        else
        {
            System.out.println( "Non supported node : " + result.getData() );
        }

        return command;
    }

    private static void generateClass( Map<String, List<Command>> groupedCommands )
        throws IOException, TemplateException
    {
    }
}
