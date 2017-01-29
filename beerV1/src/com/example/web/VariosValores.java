package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VariosValores extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{	
		String [] volume = request.getParameterValues( "volume" );
		
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		for( int i = 0; i < volume.length; i++ ) 
		{
			out.println( "<br>volume: " + volume[ i ] );
		}
		
				
	}
}