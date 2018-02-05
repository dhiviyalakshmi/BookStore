 package com.wipro;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessLoginTest {

	//@Test
	public void testMultiply() {
		assertEquals(12, new ProcessLogin().multiply(4,3));
	}

	//@Test
	public void testMultiply1() {
		assertEquals(123, new ProcessLogin().multiply(41,3));
	}
	
	//@Test
	public void testMultiply2() {
		assertEquals(123, new ProcessLogin().multiply(41,3));
	}
}




/*package com.wipro;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertLinkPresent;
import static net.sourceforge.jwebunit.junit.JWebUnit.assertTitleEquals;
import static net.sourceforge.jwebunit.junit.JWebUnit.beginAt;
import static net.sourceforge.jwebunit.junit.JWebUnit.clickLink;
import static net.sourceforge.jwebunit.junit.JWebUnit.setBaseUrl;
import static net.sourceforge.jwebunit.junit.JWebUnit.setTestingEngineKey;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.util.TestingEngineRegistry;
public class LoginControllerTest {
	@Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
        setBaseUrl("http://localhost:8899/");
    }
    //@Test
    public void testLoginPage() {
        beginAt("index.jsp"); 
        assertTitleEquals("Login");
        assertLinkPresent("forgotpassword");
        clickLink("forgotpassword");
        assertTitleEquals("ForgotPassword");
    }
    
    //@Test
    public void testRegisterPage() {
        beginAt("index.jsp"); 
        assertTitleEquals("Login");
        assertLinkPresent("register");
        clickLink("register");
        assertTitleEquals("Register");
    }
}

*/



