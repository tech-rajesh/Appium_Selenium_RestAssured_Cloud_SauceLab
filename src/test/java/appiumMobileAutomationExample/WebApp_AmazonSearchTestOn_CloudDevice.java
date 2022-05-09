package appiumMobileAutomationExample;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import configReadExample.ReadConfigDemo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebApp_AmazonSearchTestOn_CloudDevice {

	AppiumDriver<MobileElement> driver;
	ReadConfigDemo conf;
	Logger log;
	
	//@Parameters({"browser",  "version" , "platform"})
	@BeforeMethod
	public void setUp(Method name) throws Exception {

		//System.out.println("browser name is : " + browserName);
		String methodName = name.getName();

		MutableCapabilities sauceOpts = new MutableCapabilities();
		
		//sauceOpts.setCapability("appiumVersion", "1.22.1");		//added
		sauceOpts.setCapability("appiumVersion", "1.22.1");
		
		
		sauceOpts.setCapability("name", methodName);
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");

		sauceOpts.setCapability("username", "oauth-ece.rajesh-bd0df");		//get it from sauce lab user setting
		sauceOpts.setCapability("accessKey", "50baf638-8706-4185-ac05-3c3196eecad9");		//get it from sauce lab user setting
		sauceOpts.setCapability("tags", "w3c-chrome-tests");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		//cap.setCapability("browserVersion", versionName);
		
		
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("browserName", "Chrome");
//		cap.setCapability("appium:deviceName", "Google Pixel 4a (5G) GoogleAPI Emulator");
//		cap.setCapability("appium:platformVersion", "12.0");

		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("appium:deviceName", "Google Pixel 4a (5G) GoogleAPI Emulator");
		cap.setCapability("appium:platformVersion", "12.0");
		

		
		WebDriverManager.chromedriver().setup();
		cap.setCapability("browserName", "chrome");
		
//		if (browserName.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			cap.setCapability("browserName", "chrome");
//		} else if (browserName.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			cap.setCapability("browserName", "firefox");
//		}
		
		try {
			
			
			driver = new AppiumDriver<MobileElement>(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
			
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		//config read
		conf = new ReadConfigDemo();
		
		//log4J config
		log = Logger.getLogger("TCS_Appium_Logger_WebApplication-CloudTest");
		PropertyConfigurator.configure("./log4j.properties");
		

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	

	@Test(priority = 1)
	public void addSearchItemsOnAmazonTest() throws Exception {

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
