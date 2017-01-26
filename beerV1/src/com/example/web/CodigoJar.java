package com.example.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodigoJar extends HttpServlet 
{
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{	
		response.setContentType( "application/jar" );
		response.setHeader( "Content-Disposition", "attachment; filename=mysql-connector-java-5.1.37-bin.jar" );
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream( "/mysql-connector-java-5.1.37-bin.jar" );
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		OutputStream os = response.getOutputStream();
		
		while ( ( read = is.read( bytes ) ) != -1 ) 
		{
			os.write( bytes, 0, read );
		}
		
		os.flush();
		os.close();
	}
}