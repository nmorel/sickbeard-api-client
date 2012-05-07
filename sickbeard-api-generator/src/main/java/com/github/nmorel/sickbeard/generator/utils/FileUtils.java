package com.github.nmorel.sickbeard.generator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtils
{
    public static boolean copy( File source, File dest )
    {
        boolean resultat = false;

        FileInputStream sourceFile = null;
        FileOutputStream destinationFile = null;
        try
        {
            // Creating dest file
            dest.createNewFile();
            // Opening streams
            sourceFile = new FileInputStream( source );
            destinationFile = new FileOutputStream( dest );
            // Reading by 0.5Mo chunk
            byte buffer[] = new byte[512 * 1024];
            int nbLecture;
            while ( ( nbLecture = sourceFile.read( buffer ) ) != -1 )
            {
                destinationFile.write( buffer, 0, nbLecture );
            }

            // Copy successful
            resultat = true;
        }
        catch ( FileNotFoundException f )
        {
        }
        catch ( IOException e )
        {
        }
        finally
        {
            // Closing streams
            try
            {
                sourceFile.close();
            }
            catch ( Exception e )
            {
            }
            try
            {
                destinationFile.close();
            }
            catch ( Exception e )
            {
            }
        }
        return ( resultat );
    }

    private FileUtils()
    {
    }
}
