package sauceLabIntegrationExample;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestSauceLabMobileAppium {

	AppiumDriver<MobileElement> driver;

	@Parameters({"browser",  "version" , "platform"})
	@BeforeMethod
	public void setUp(String browserName, String versionName, String platformName ,  Method name) {

		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();

		MutableCapabilities sauceOpts = new MutableCapabilities();
		
		sauceOpts.setCapability("appiumVersion", "1.22.1");		//added
		//sauceOpts.setCapability("appiumVersion", "1.22.3");
		sauceOpts.setCapability("name", methodName);
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");

		sauceOpts.setCapability("username", "oauth-ece.rajesh-bd0df");		//get it from sauce lab user setting
		sauceOpts.setCapability("accessKey", "50baf638-8706-4185-ac05-3c3196eecad9");		//get it from sauce lab user setting
		sauceOpts.setCapability("tags", "w3c-chrome-tests");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", versionName);
		//cap.setCapability("platformName", platformName);
		
		
		//added new
		
		//android devices
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("browserName", "Chrome");
//		cap.setCapability("appium:deviceName", "Google Pixel 4 GoogleAPI Emulator");
//		cap.setCapability("appium:platformVersion", "12.0");
		
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("browserName", "Chrome");
		cap.setCapability("appium:deviceName", "Google Pixel 4a (5G) GoogleAPI Emulator");
		cap.setCapability("appium:platformVersion", "12.0");
		

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");
		}
		
		try {
			
			
			//driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
			driver = new AppiumDriver<MobileElement>(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
			
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}