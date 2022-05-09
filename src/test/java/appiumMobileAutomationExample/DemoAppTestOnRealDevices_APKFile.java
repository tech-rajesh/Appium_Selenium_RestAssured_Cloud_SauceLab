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
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoAppTestOnRealDevices_APKFile {
	
	
	AppiumDriver<MobileElement> driver;
	
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
		driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);
		
		
	}
	
	
	@Test(priority = 1)
	public void verifyViewFeature() throws Exception {
		
		System.out.println("Application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());
		
		//click on view - done
		//click on Gallery - done
		//click on photo
		//resoucseID
		
		
		//driver.findElement(By.id("android:id/text1")).click();			// default - first element
		//driver.findElements(By.id("android:id/text1")).get(2).click();
		
		//AccessibilityId or Content-Desc
		driver.findElementByAccessibilityId("Views").click();
		
		//AccessibilityId or Content-Desc
		//driver.findElementByAccessibilityId("Gallery").click();
		
		//XPATH
		//driver.findElementByXPath("//*[@index='10']").click();
		//driver.findElementByXPath("//*[@text='Gallery']").click();
		driver.findElementByXPath("//*[contains(@text,'llery')]").click();
		
		//index - default
		driver.findElement(By.id("android:id/text1")).click();			//first element
		//driver.findElements(By.id("android:id/text1")).get(1).click();
		
		
		
		
	}
	
	
}
