package hrmLoginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configReadExample.ReadConfigDemo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginExample {

	WebDriver driver;
	ReadConfigDemo config;

	@BeforeTest
	public void launchApp() throws Exception {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		config = new ReadConfigDemo();
		
		
		System.out.println(config.getAppURL());;
		
		
		
		driver.get(config.getAppURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);	
		driver.close();

	}

	
	
	@Test
	public void loginWithValidUserDetails() throws Exception {

		
		driver.findElement(By.id("txtUsername")).sendKeys(config.getAdminUser());
		driver.findElement(By.id("txtPassword")).sendKeys(config.getAdminPassword());
		driver.findElement(By.id("btnLogin")).click();
		
		
		
	}
	
	
}
