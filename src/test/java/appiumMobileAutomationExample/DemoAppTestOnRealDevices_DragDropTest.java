package appiumMobileAutomationExample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class DemoAppTestOnRealDevices_DragDropTest {
	
	
	AndroidDriver<WebElement> driver;
	
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
		caps.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\appium\\APKFile\\Drag Sort Demos_v0.5.0_apkpure.com.apk");
		
		
		
		//real device calculator - com.coloros.calculator/com.android.calculator2.Calculator
//		caps.setCapability("appPackage", "com.coloros.calculator");
//		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		//Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		driver = new AndroidDriver<WebElement>(new URL(appiumserver), caps);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority = 1)
	public void verifyViewFeature() throws Exception {
		
		System.out.println("Application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());
		
		TouchAction action = new TouchAction(driver);
		
		
		WebElement ele_background = driver.findElement(By.xpath("//android.widget.TextView[@text='Basic usage playground']"));
		action.tap(ElementOption.element(ele_background)).perform();
		
		//drag drop element
		
		
		WebElement source = driver.findElementsById("drag_handle").get(2);
		WebElement target = driver.findElementsById("drag_handle").get(5);
		
		
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
		
	}
	
	
}
