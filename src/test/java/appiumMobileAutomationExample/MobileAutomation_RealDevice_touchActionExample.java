package appiumMobileAutomationExample;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAutomation_RealDevice_touchActionExample {

	AndroidDriver<AndroidElement> ad;

	@BeforeTest
	public void setup() throws IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "TCSGameMachine");
		cap.setCapability("udid", "c60c1a73");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12.0");

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);

		//Installing Application
		cap.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\ApiDemos-debug.apk");
		
		ad = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), cap);
		ad.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void verifyTapOperationOnOS() throws Exception {

		System.out.println("Battery Info of real device");
		
		//touchAction
		
		AndroidTouchAction ta = new AndroidTouchAction(ad);
		
		
		Thread.sleep(4000);
		
		AndroidElement ele_OS = ad.findElementByAccessibilityId("OS");
		
		//tap operation
		ta.tap(ElementOption.element(ele_OS)).perform();
		
	

	}

	
	
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		System.out.println("------unlock a device------");
		//ad.unlockDevice();
		//close the application
		Thread.sleep(5000);
		ad.closeApp();
		Thread.sleep(5000);
		
		//ad.close();
		
	}
	
	@AfterMethod
	public void addLine() {
		
		System.out.println("***************************************");
		System.out.println("***************************************");
		
	}
	
}
