package sauceLabIntegrationExample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileAutomation_RealDevice_AmazonTestWebApp extends BaseTestSauceLabMobileAppium{
	
	//AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws IOException {
		
		//device
		//application
		//appium server details
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "TCSGameMachine");
		cap.setCapability("udid", "c60c1a73");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12.0");
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		
		//browser Application - web App
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidKeepAppDataDir", true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriverManager.chromedriver().setup();
		
		
		
		driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		
	}
	
	@Test
	public void verifySearchFeature() throws Exception {
		
		System.out.println("Launching Amazon app on real device - web app");
		
//		1.) open chromeBrowser
//		2.) launch Amazon App on chrome browser
//		3.) enter value "iphone" on searchbox field
//		4.) Click on Button
//		5.) Validate Application title
//		6.) On Search Result identify "Apple iPhone 12 (128GB) - Blue" - click & getPrice
		
		Thread.sleep(5000);
		
		driver.get("https://www.amazon.in/");
		System.out.println("Application Launched");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input.nav-input")).sendKeys("iphone" + Keys.ENTER);
		
		System.out.println("Search Results on Amazon Page");
		//driver.findElementsByCssSelector("input.nav-input").get(0).sendKeys("iphone");
		
		Thread.sleep(5000);
		System.out.println("Click on Specific Searched device");
		driver.findElementByXPath("//img[contains(@alt,'Apple iPhone 13')]").click();
		Thread.sleep(8000);
		
		
	}
	
	
	
	

}
