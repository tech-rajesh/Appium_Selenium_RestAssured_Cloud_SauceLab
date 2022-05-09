package appiumtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class RealDeviceTouchAction {
	
	AndroidDriver<AndroidElement> ad;
	
	@BeforeTest
	public void LaunchApp() throws IOException {
		//configuration
		
		//Devices - adb devices
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("udid", "c60c1a73"); // unique id of device udid // adb devices --- SDK manager
		cap.setCapability("platformVersion", "12.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		
//		cap.setCapability("udid", "c60c1a73"); 					//JSON
//		cap.setCapability("deviceName", "RajeshMachine");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
//		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//APK file
		cap.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\appium\\APKFile\\ApiDemos-debug.apk");
		
		//Application
		//APK info
		//adb shell
		//adb shell dumpsys window | find "mCurrentFocus"
		
		//cap.setCapability("appPackage", "com.coloros.calculator");
		//cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		//Appium Server - IP details
		
		ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		ad.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}
	
	

	@Test
	public void verifyAddTestWithThreeDigitNumber() throws Exception {
		
		Thread.sleep(5000);
		System.out.println("Installing and launching APK application");
		
		//Creating and Object of touchActions
		AndroidTouchAction ta = new AndroidTouchAction(ad);
		
		Thread.sleep(5000);
		//Tap
		AndroidElement eleOS_xpath = ad.findElement(By.xpath("//android.widget.TextView[@text='OS']"));
		AndroidElement eleOS_accID = ad.findElementByAccessibilityId("OS");
		
		
		ta.tap(ElementOption.element(eleOS_accID)).perform();
		
		
		
	}
	
	
}
