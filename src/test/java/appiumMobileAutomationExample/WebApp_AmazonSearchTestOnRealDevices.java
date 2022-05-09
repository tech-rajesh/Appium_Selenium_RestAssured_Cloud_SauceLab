package appiumMobileAutomationExample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import configReadExample.ReadConfigDemo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebApp_AmazonSearchTestOnRealDevices {

	AppiumDriver<MobileElement> driver;
	Logger log;
	ReadConfigDemo conf;

	@BeforeTest
	public void setup() throws Exception {

		// log file related setting
		log = Logger.getLogger("TCS_Appium_Logger_WebApplication");
		PropertyConfigurator.configure("./log4j.properties");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "c60c1a73");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);

		// browser Application - web App
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability("chromeOptions", ImmutableMap.of("w3c", false));

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidKeepAppDataDir", true);
		caps.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriverManager.chromedriver().setup();

		// Appium server running
		String appiumserver = "http://localhost:4723/wd/hub";
		driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);

		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Create a object of config 
		conf = new ReadConfigDemo();
		

	}

	@Test(priority = 1)
	public void addContactTest() throws Exception {

		driver.get(conf.getQAAppURL());
		System.out.println("Amazon Web application launched successfully on device.....");
		log.info("Amazon Web application launched successfully on device....., URL: " + conf.getQAAppURL());
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='k']")).sendKeys("iphone" + Keys.ENTER);
		log.info("enter value in serach field and perform keyboard operation - ENTER " );
		Thread.sleep(2000);
		
		log.info("click on search results items" );
		
		driver.findElement(By.xpath("//img[contains(@alt,'pple iPhone 13 (256GB) - Pink')]")).click();
		Thread.sleep(4000);
		
		//validation 

	}

}
