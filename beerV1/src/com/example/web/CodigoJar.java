package com.example.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class CodigoJar extends HttpServlet 
{
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{	
	    ServletContext context = getServletContext(); 
	    
		response.setContentType( "application/jar" );
		response.setHeader( "Content-Disposition", "attachment; filename=mysql-connector-java-5.1.37-bin.jar" );
		InputStream is = context.getResourceAsStream( "/mysql-connector-java-5.1.37-bin.jar" );
		
		int read = 0;
		byte[] binario = new byte[ 1024 ];
		
		OutputStream os = response.getOutputStream();
		
		while ( ( read = is.read( binario ) ) != -1 ) 
		{
			os.write( binario, 0, read );
		}
		
		os.flush();
		os.close();
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{	
		Part part = request.getPart( "arquivo" );
		//String originalFileName = CodigoJar.getFileName( part );
		String nomeDoArquivo = Paths.get( part.getSubmittedFileName() ).getFileName().toString();
		InputStream inputStream = part.getInputStream();
		FileOutputStream arquivo = new FileOutputStream( new File( "C:\\" + nomeDoArquivo ) );
		byte[] buffer = new byte[ 1024 ];
		int bytes;
		
		while( ( bytes = inputStream.read( buffer ) ) != -1 )
		{
			arquivo.write(buffer, 0, bytes);
		}
		
		arquivo.close();
		inputStream.close();
	}
	
	public static String getFileName( Part part ) 
	{
		String header = part.getHeader("content-disposition");
		String[] sections = header.split("\\s*;\\s*");
		
		for( String s : sections ) 
		{
			if( s.startsWith( "filename=" ) ) 
			{
				return s.substring( 9 ).replace( "\"", "" );
			}
		}
		
		return null;
	}
}