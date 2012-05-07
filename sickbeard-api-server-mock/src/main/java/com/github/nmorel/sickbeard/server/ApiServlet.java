package com.github.nmorel.sickbeard.server;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiServlet
    extends HttpServlet
{
    private ResourcesLoader resources;

    @Override
    public void init()
        throws ServletException
    {
        resources = new ResourcesLoader();
    }

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
        throws ServletException, IOException
    {
        doPost( req, resp );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse response )
        throws ServletException, IOException
    {
        String cmd = req.getParameter( "cmd" );
        String filename = resources.getFilename( cmd );

        if ( filename.endsWith( ".json" ) )
        {
            response.setContentType( "application/json;charset=UTF-8" );
        }
        else
        {
            response.setContentType( "image/jpeg" );
        }

        InputStream in = getClass().getClassLoader().getResourceAsStream( "/examples/" + filename );
        ServletOutputStream out = response.getOutputStream();
        int nextChar;
        while ( ( nextChar = in.read() ) != -1 )
        {
            out.write( nextChar );
        }
        out.flush();
    }
}
