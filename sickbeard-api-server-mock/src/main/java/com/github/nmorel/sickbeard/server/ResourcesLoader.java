package com.github.nmorel.sickbeard.server;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ResourcesLoader
{
    private Map<String, String> examples;

    public ResourcesLoader()
    {
        examples = new HashMap<String, String>();
        examples.put( "episode", "episode.json" );
        examples.put( "episode.search", "episode.search.json" );
        examples.put( "episode.setstatus", "episode.setstatus.json" );
        examples.put( "exceptions", "exceptions.json" );
        examples.put( "future", "future.json" );
        examples.put( "history.clear", "history.clear.json" );
        examples.put( "history", "history.json" );
        examples.put( "history.trim", "history.trim.json" );
        examples.put( "logs", "logs.json" );
        examples.put( "sb.addrootdir", "sb.addrootdir.json" );
        examples.put( "sb.checkscheduler", "sb.checkscheduler.json" );
        examples.put( "sb.deleterootdir", "sb.deleterootdir.json" );
        examples.put( "sb.forcesearch", "sb.forcesearch.json" );
        examples.put( "sb.getdefaults", "sb.getdefaults.json" );
        examples.put( "sb.getmessages", "sb.getmessages.json" );
        examples.put( "sb.getrootdirs", "sb.getrootdirs.json" );
        examples.put( "sb", "sb.json" );
        examples.put( "sb.pausebacklog", "sb.pausebacklog.json" );
        examples.put( "sb.ping", "sb.ping.json" );
        examples.put( "sb.restart", "sb.restart.json" );
        examples.put( "sb.searchtvdb", "sb.searchtvdb.json" );
        examples.put( "sb.setdefaults", "sb.setdefaults.json" );
        examples.put( "sb.shutdown", "sb.shutdown.json" );
        examples.put( "show.addexisting", "show.addexisting.json" );
        examples.put( "show.addnew", "show.addnew.json" );
        examples.put( "show.cache", "show.cache.json" );
        examples.put( "show.delete", "show.delete.json" );
        examples.put( "show.getbanner", "show.getbanner.jpg" );
        examples.put( "show.getposter", "show.getposter.jpg" );
        examples.put( "show.getquality", "show.getquality.json" );
        examples.put( "show", "show.json" );
        examples.put( "show.pause", "show.pause.json" );
        examples.put( "show.refresh", "show.refresh.json" );
        examples.put( "show.seasonlist", "show.seasonlist.json" );
        examples.put( "show.seasons", "show.seasons.json" );
        examples.put( "show.setquality", "show.setquality.json" );
        examples.put( "show.stats", "show.stats.json" );
        examples.put( "show.update", "show.update.json" );
        examples.put( "shows", "shows.json" );
        examples.put( "shows.stats", "shows.stats.json" );
    }

    public String getFilename( String cmd )
    {
        return examples.get( cmd );
    }

    public static void main( String[] args )
    {
        File resourceFolder = new File( "src/main/resources/examples/" );
        for ( File file : resourceFolder.listFiles() )
        {
            int indexOf = file.getName().lastIndexOf( "." );
            if ( indexOf != -1 )
            {
                System.out.println( "examples.put(\"" + file.getName().substring( 0, indexOf ) + "\", \"" + file.getName() + "\");" );
            }
        }
    }
}
