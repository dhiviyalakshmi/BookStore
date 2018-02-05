package com.wipro;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ForgotPasswordControllerTest extends Mockito{
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 RequestDispatcher rd;
	 @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }

    @Test
    public void testForgotPassword() throws Exception {
        when(request.getParameter("email")).thenReturn("xxx@gmail.com");
        when(request.getParameter("newpassword")).thenReturn("1234");
        when(request.getParameter("confirmpassword")).thenReturn("1234");
        when(request.getRequestDispatcher("index.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new ForgotPasswordController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("password updated", result);
      
    }
   
}