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

import org.junit.Before;
import org.junit.Test;

public class TimeStampServletTest {
	HttpServletResponse response;
	HttpServletRequest request;
	StringWriter stringWriter;
	PrintWriter writer;

   @Before
   public  void setUp() throws IOException{
		//create mock objects
		 response = mock(HttpServletResponse.class);
		 request = mock(HttpServletRequest.class);
		 stringWriter = new StringWriter();
		 writer = new PrintWriter(stringWriter);
	     when(response.getWriter()).thenReturn(writer);
   }
	@Test
	public void testUnixDate() throws ServletException, IOException {
		String unixDate = "1450137600";
		String expectedOutput = "{\"unixDate\":1450137600,\"naturalLanguageDate\":\"December 15, 2015\"}\n";

		when(request.getPathInfo()).thenReturn("/" + unixDate);
   
        //call servlet with mock objects
        new TimeStampServlet().doGet(request, response);
        
        assertTrue(stringWriter.toString().equals(expectedOutput)); 
	}
	@Test
	public void testNegativeUnixDate() throws ServletException, IOException {
		String unixDate = "-601084800";
		String expectedOutput = "{\"unixDate\":-601084800,\"naturalLanguageDate\":\"December 15, 1950\"}\n";

		when(request.getPathInfo()).thenReturn("/" + unixDate);
        
        //call servlet with mock objects
        new TimeStampServlet().doGet(request, response);
        
        assertTrue(stringWriter.toString().equals(expectedOutput)); 
	}

	@Test
	public void testNaturalLanguageDate() throws ServletException, IOException {
		String naturalLanguageDate = "December 15, 2015";
		String expectedOutput = "{\"unixDate\":1450137600,\"naturalLanguageDate\":\"December 15, 2015\"}\n";

		when(request.getPathInfo()).thenReturn("/" + naturalLanguageDate);
        
        //call servlet with mock objects
        new TimeStampServlet().doGet(request, response);
        
        assertTrue(stringWriter.toString().equals(expectedOutput)); 
	}
	
	
	

}
