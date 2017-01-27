package com.example.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirecionamento extends HttpServlet
{
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{	
	    response.sendRedirect( "/beerV1/stuff.html" );
	}
}