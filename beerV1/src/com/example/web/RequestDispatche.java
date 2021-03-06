package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDispatche extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{	
	    RequestDispatcher view = request.getRequestDispatcher( "resultado.jsp" );
	    view.forward( request, response );
	}
}