package com.github.nmorel.sickbeard.client;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nmorel.sickbeard.client.cmd.ExceptionsCommands;
import com.github.nmorel.sickbeard.client.exceptions.SickBeardException;

public class ExceptionsTest
{
    private static ExceptionsCommands exceptions;

    @BeforeClass
    public static void setup()
    {
        exceptions = new SickBeardClient( "http://localhost:8085/api/1234/" ).exceptions();
    }

    @Test
    public void showTest()
        throws SickBeardException
    {
        List<String> showExceptions = exceptions.show( "248261" ).call();

        assertEquals( 4, showExceptions.size() );
        assertEquals( "National Terrorism Strike Force: San Diego: Sport Utility Vehicle", showExceptions.get( 0 ) );
        assertEquals( "National Terrorism Strike Force: San Diego: SUV", showExceptions.get( 1 ) );
        assertEquals( "NTSF:SD:SUV::", showExceptions.get( 2 ) );
        assertEquals( "NTSF SD SUV", showExceptions.get( 3 ) );
    }

    @Test
    public void showsTest()
        throws SickBeardException
    {
        Map<String, List<String>> showsExceptions = exceptions.shows().call();

        assertEquals( 2, showsExceptions.size() );

        List<String> showExceptions = showsExceptions.get( "70327" );
        assertEquals( 2, showExceptions.size() );
        assertEquals( "Buffy the Vampire Slayer", showExceptions.get( 0 ) );
        assertEquals( "Buffy", showExceptions.get( 1 ) );

        showExceptions = showsExceptions.get( "70336" );
        assertEquals( 2, showExceptions.size() );
        assertEquals( "The Tonight Show with Jay Leno", showExceptions.get( 0 ) );
        assertEquals( "Jay Leno", showExceptions.get( 1 ) );
    }
}
