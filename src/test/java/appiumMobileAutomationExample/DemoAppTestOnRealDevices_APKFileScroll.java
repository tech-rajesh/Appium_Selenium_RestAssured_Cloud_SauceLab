package appiumMobileAutomationExample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoAppTestOnRealDevices_APKFileScroll {

	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void setup() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "c60c1a73");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "TCSGameMachine");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);

		// Installing APK file
		caps.setCapability(MobileCapabilityType.APP, "D:\\Jar_files\\appium\\APKFile\\ApiDemos-debug.apk");

		// Appium server running
		String appiumserver = "http://192.168.1.5:4723/wd/hub";
		driver = new AndroidDriver<MobileElement>(new URL(appiumserver), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void verifyViewFeature() throws Exception {

		System.out.println("Application launched successfully.....");
		System.out.println("Orientation: " + driver.getOrientation());

		driver.findElementByXPath("//*[contains(@text,'Views')]").click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))")
				.click();
		Thread.sleep(5000);

		driver.quit();

	}

}
