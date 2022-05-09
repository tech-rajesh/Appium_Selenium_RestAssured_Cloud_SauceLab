package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configReadExample.ReadConfigDemo;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.LoginPageFactory;

public class BaseTest {

	ReadConfigDemo config;
	WebDriver driver;
	//LoginPage lp;
	LoginPageFactory lp;
	
	
	@BeforeTest
	public void launchApp() throws Exception {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		config = new ReadConfigDemo();
		
		driver.get(config.getAppURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Create Page Object
		//lp = new LoginPage(driver);
		
		lp = new LoginPageFactory(driver);
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);	
		driver.close();

	}
	
	
}
