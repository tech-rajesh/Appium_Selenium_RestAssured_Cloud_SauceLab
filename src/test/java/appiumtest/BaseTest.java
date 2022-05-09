package appiumtest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.AddNewContactPage;

public class BaseTest {
	AddNewContactPage add;
	WebDriverWait wait;

	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "c60c1a73"); // unique id of device udid // adb devices --- SDK manager
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);

		// adb shell command
		// adb shell dumpsys window | find "mCurrentFocus"

		// com.google.android.dialer/com.google.android.dialer.extensions.GoogleDialtactsActivity

		caps.setCapability("appPackage", "com.google.android.dialer");
		caps.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");

		// Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		driver = new AppiumDriver<MobileElement>(new URL(appiumserver), caps);

		// Create a page object
		add = new AddNewContactPage(driver);

	}
	
	
	public void conditionalWait(AppiumDriver<MobileElement> ele) {
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf((WebElement) ele));
		
		
		
	}

}
