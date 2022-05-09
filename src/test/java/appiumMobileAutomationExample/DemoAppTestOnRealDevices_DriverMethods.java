package appiumMobileAutomationExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoAppTestOnRealDevices_DriverMethods {
	
	
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "c60c1a73");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//Installing APK file
		caps.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\appium\\APKFile\\ApiDemos-debug.apk");
		
		
		
		//real device calculator - com.coloros.calculator/com.android.calculator2.Calculator
//		caps.setCapability("appPackage", "com.coloros.calculator");
//		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		//Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		//driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);
		driver = new AndroidDriver<AndroidElement>(new URL(appiumserver), caps);
		
		
	}
	
	
	@Test(priority = 1)
	public void verifyBatteryInfo() throws Exception {
		
		System.out.println("BatteryState: " + driver.getBatteryInfo().getState());
		System.out.println("BatteryLevel: " + driver.getBatteryInfo().getLevel());
		
		
	}
	
	
	@Test(priority = 1)
	public void verifyOrientation() throws Exception {
		
		System.out.println("Orientation: " + driver.getOrientation());
		
		
		
	}
	
	@Test(priority = 2)
	public void verifyContext() throws Exception {
		
		System.out.println("Application Context: " + driver.getContext());
		
		
		
	}
	
	@Test(priority = 2)
	public void verifyLatLong() throws Exception {
		
		System.out.println(driver.location().getLatitude());
		System.out.println(driver.location().getLongitude());
		
		
	}
	
	@Test(priority = 2)
	public void verifyDeviceTime() throws Exception {
		
		System.out.println(driver.getDeviceTime());
		
		
	}
	
	
}
