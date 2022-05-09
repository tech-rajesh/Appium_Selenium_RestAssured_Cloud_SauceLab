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

public class DemoAppTestOnRealDevices_action {
	
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		//device
		//deviceName
		//uniqueID device
		//platform Name
		//Real device Setting
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "c60c1a73");		//unique id of device udid    // adb devices --- SDK manager
		//C:\Users\Act\AppData\Local\Android\Sdk\platform-tools
		//caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//get appPackage & appActivity
		//Application Setting
		//appPackage & appActivity
		
		//method1
		//APK info
		
		//com.dencreak.dlcalculator.DLCalculatorActivity 
		
		
		
		
		//method2
		
		//adb shell command
		//adb shell dumpsys window | find "mCurrentFocus"
		
		//Calculator application
		//com.dencreak.dlcalculator/com.dencreak.dlcalculator.DLCalculatorActivity
		//com.google.android.calculator/com.android.calculator2.Calculator
		
		//dialer application
		//com.android.dialer/com.android.dialer.main.impl.MainActivity
		
//		caps.setCapability("appPackage", "com.android.dialer");
//		caps.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");
		
		//com.android.calculator2.Calculator - Calculator
		
		
		//real device calculator - com.coloros.calculator/com.android.calculator2.Calculator
		//Installing Application
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Act\\Downloads\\Drag Sort Demos_v0.5.0_apkpure.com.apk");
		
		
		//Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);
		
		
	}
	
	
	@Test(priority = 1)
	public void addThreeDigitTest() throws Exception {
		
		System.out.println("calculator application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());
		
		//clear Results
		
		
		
	}
	
	
	
	
	

}
