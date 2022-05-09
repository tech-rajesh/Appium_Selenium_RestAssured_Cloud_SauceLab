package log4jExample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class SendMessageAppTestOnRealDevices_Exercise {
	
	
	AndroidDriver<AndroidElement> driver;
	Logger log;
	@BeforeTest
	public void setup() throws Exception {
		
		
		//log file related setting
		log = Logger.getLogger("TCS_Appium_Logger");
		PropertyConfigurator.configure("./log4j.properties");
		
		
		
		
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
		//real device messgae - com.google.android.apps.messaging/com.google.android.apps.messaging.ui.ConversationListActivity
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		
		
		//Appium server running
		String appiumserver = "http://localhost:4723/wd/hub";
		driver = new AndroidDriver<AndroidElement>(new URL(appiumserver), caps);
		log.info("******************************");
		log.info("Appium server started");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority = 1)
	public void addThreeDigitTest() throws Exception {
		
		System.out.println("Messaging application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());
		
		log.info("Messaging application launched");
		
		//click on start chat
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Start')]").click();
		log.info("click on Start chat button");
		
		Thread.sleep(3000);
		//enter search criteria
		//driver.findElement(By.id("recipient_text_view")).sendKeys("Ramesh Boda");
		
		Thread.sleep(6000);
		//driver.findElement(By.id("contact_picker_create_group")).click();
		
		//key events
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//System.out.println("start scrolling searching element ........");
		log.info("start scrolling searching element ........");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Airtel Broadband\").instance(0))").click();
	      Thread.sleep(5000);
		
		
	      log.info("click on Airtel Broadband");
		
		//enter message
	      System.out.println("entering text into application");
	      log.info("enter message ---- hi");
		driver.findElement(By.id("compose_message_text")).sendKeys("hi....");
		
		//key events
		System.out.println("Key event : pressing enter - multiple");
		log.info("press Enter keys event");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("compose_message_text")).clear();
		
		log.info("clear the text from messaging field");
		
		driver.findElement(By.id("compose_message_text")).sendKeys("hello....");
		//key events
		driver.pressKey(new KeyEvent(AndroidKey.TAB));
		log.info("press Tab keys event");
		Thread.sleep(3000);
		
		log.info("clear the text from messaging field");
		driver.findElement(By.id("compose_message_text")).clear();
		
		 log.info("enter message ---- hi");
		driver.findElement(By.id("compose_message_text")).sendKeys("new line code....");
		System.out.println("Key event : pressing Tab");
		driver.pressKey(new KeyEvent(AndroidKey.TAB));
		Thread.sleep(3000);
		
		MobileElement ele_sendMessageIcon = (MobileElement) driver.findElementByAccessibilityId("Send SMS");
		ele_sendMessageIcon.click();
		
		 log.info("click on Send Message icon");
		
		//key events
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
//		//AccessibilityId - COntentDesc
//		//driver.findElementByAccessibilityId("Clear").click();
//		Thread.sleep(2000);
//		driver.findElements(By.id("com.google.android.dialer:id/navigation_bar_item_icon_view")).get(2).click();	
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Create new contact']")).click();
//		
//		Thread.sleep(2000);
//		MobileElement txtFirstName = driver.findElement(By.xpath("//android.widget.EditText[@text='First name']"));
//		txtFirstName.sendKeys("Ramesh");
//		Thread.sleep(2000);
//		MobileElement txtLastName = driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']"));
//		txtLastName.sendKeys("Boda");
//		MobileElement txtPhone = driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']"));
//		txtPhone.sendKeys("9998887770");
//		
//		Thread.sleep(2000);
//		MobileElement btnSave = driver.findElement(By.xpath("//android.widget.Button[@text='Save']"));
//		btnSave.click();
		
		
		
	}
	
	

}
