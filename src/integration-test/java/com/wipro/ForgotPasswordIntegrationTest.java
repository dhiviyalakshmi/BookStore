
package com.wipro;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.experimental.categories.Category;
import com.wipro.IntegrationTest;

@Category(IntegrationTest.class)
public class ForgotPasswordIntegrationTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\x0271536\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}
	
	@Test
	public void forgotPasswordSuccess() {
        driver.get("http://localhost:8899/Bookstore/forgotpassword.jsp");      
        WebElement confirmpass = driver.findElement(By.name("confirmpassword"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("newpassword"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("xxx@gmail.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Book Store"));
	}
}