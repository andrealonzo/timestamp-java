package com.aalonzo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class TimeStampServletTest {

	@Test
	public void testUnixDate() throws ServletException, IOException {
		String unixDate = "1450137600";
		String expectedOutput = "{\"unixDate\":1450137600,\"naturalLanguageDate\":\"December 15, 2015\"}\n";

		//create mock objects
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpServletRequest request = mock(HttpServletRequest.class);

		when(request.getPathInfo()).thenReturn("/" + unixDate);
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		
        when(response.getWriter()).thenReturn(writer);
        
        //call servlet with mock objects
        new TimeStampServlet().doGet(request, response);
        
        assertTrue(stringWriter.toString().equals(expectedOutput)); 
	}
	@Test
	public void testNegativeUnixDate() throws ServletException, IOException {
		String unixDate = "-601084800";
		String expectedOutput = "{\"unixDate\":-601084800,\"naturalLanguageDate\":\"December 15, 1950\"}\n";

		//create mock objects
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpServletRequest request = mock(HttpServletRequest.class);

		when(request.getPathInfo()).thenReturn("/" + unixDate);
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		
        when(response.getWriter()).thenReturn(writer);
        
        //call servlet with mock objects
        new TimeStampServlet().doGet(request, response);
        
        assertTrue(stringWriter.toString().equals(expectedOutput)); 
	}

	@Test
	public void testNaturalLanguageDate() throws ServletException, IOException {
		String naturalLanguageDate = "December 15, 2015";
		String expectedOutput = "{\"unixDate\":1450137600,\"naturalLanguageDate\":\"December 15, 2015\"}\n";

		//create mock objects
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpServletRequest request = mock(HttpServletRequest.class);

		when(request.getPathInfo()).thenReturn("/" + naturalLanguageDate);
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		
        when(response.getWriter()).thenReturn(writer);
        
        //call servlet with mock objects
        new TimeStampServlet().doGet(request, response);
        
        assertTrue(stringWriter.toString().equals(expectedOutput)); 
	}
	
	
	

}
