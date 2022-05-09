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

public class ContactAppTestOnRealDevices {
	
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "c60c1a73");		//unique id of device udid    // adb devices --- SDK manager
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//adb shell command
		//adb shell dumpsys window | find "mCurrentFocus"
		
		//real device calculator - com.coloros.calculator/com.android.calculator2.Calculator
		//real device dialer - com.google.android.dialer/com.google.android.dialer.extensions.GoogleDialtactsActivity
		caps.setCapability("appPackage", "com.google.android.dialer");
		caps.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
		
		//Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);
		
		
	}
	
	
	@Test(priority = 1)
	public void addThreeDigitTest() throws Exception {
		
		System.out.println("calculator application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());
		
		
		//AccessibilityId - COntentDesc
		//driver.findElementByAccessibilityId("Clear").click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.google.android.dialer:id/navigation_bar_item_icon_view")).get(2).click();	
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Create new contact']")).click();
		
		Thread.sleep(2000);
		MobileElement txtFirstName = driver.findElement(By.xpath("//android.widget.EditText[@text='First name']"));
		txtFirstName.sendKeys("Ramesh");
		Thread.sleep(2000);
		MobileElement txtLastName = driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']"));
		txtLastName.sendKeys("Boda");
		MobileElement txtPhone = driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']"));
		txtPhone.sendKeys("9998887770");
		
		Thread.sleep(2000);
		MobileElement btnSave = driver.findElement(By.xpath("//android.widget.Button[@text='Save']"));
		btnSave.click();
		
		
		
	}
	
	

}
