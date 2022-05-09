package appiumMobileAutomationExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorAppTestOnVirtualDevices {
	
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		//device
		//deviceName
		//uniqueID device
		//platform Name
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "emulator-5554");		//unique id of device udid    // adb devices --- SDK manager
		//C:\Users\Act\AppData\Local\Android\Sdk\platform-tools
		//caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		//get appPackage & appActivity
		//Application Setting
		//appPackage & appActivity
		
		//method1
		//APK info
		
		//com.dencreak.dlcalculator.DLCalculatorActivity 
		
		caps.setCapability("appPackage", "com.dencreak.dlcalculator");
		caps.setCapability("appActivity", "com.dencreak.dlcalculator.DLCalculatorActivity");
		
		
		//Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);
		
		
	}
	
	
	@Test
	public void addTest() {
		
		System.out.println("calculator application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());
		
		
		driver.findElement(By.id("")).click();
		
		
	}
	
	
	
	
	

}
