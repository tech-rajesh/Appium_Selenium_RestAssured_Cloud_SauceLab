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
import io.appium.java_client.remote.MobileCapabilityType;

//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAutomation_RealDevice_DriverMethod2 {

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
	public void verifyBatteryState() throws Exception {

		System.out.println("Battery Info of real device");
		Thread.sleep(4000);
		System.out.println("Battery Info: " + ad.getBatteryInfo().getState());
		System.out.println("Battery Info in details: " + ad.getBatteryInfo());
		System.out.println("Battery Info in details: " + ad.getBatteryInfo().getLevel());
		Assert.assertEquals(ad.getBatteryInfo().getState().toString(), "CHARGING");	

	}

	
	@Test(priority = 2)
	public void verifyDeviceLocked() throws Exception {

		System.out.println("------verifyDeviceLocked real device------");
		Thread.sleep(4000);
		System.out.println("Battery Info: " + ad.isDeviceLocked()); 			//false
		Assert.assertFalse(ad.isDeviceLocked(), "verification of device locked state");
			

	}
	
	@Test(priority = 3)
	public void verifyApplictionDetails() throws Exception {

		System.out.println("------verifyApplictionDetails real device------");
		Thread.sleep(4000);
		System.out.println("Application Info: " + ad.getCurrentPackage());			// this will give package info of application
		System.out.println("Context Info: " + ad.getContext());
		Assert.assertEquals(ad.getCurrentPackage(), "io.appium.android.apis");
		Assert.assertEquals(ad.getContext(), "NATIVE_APP");	

	}
	
	
	@Test(priority = 4)
	public void verifyDeviceOrientation() throws Exception {

		System.out.println("------verifyDeviceOrientation real device------");
		Thread.sleep(4000);
		System.out.println("Device Orientation Info: " + ad.getOrientation());			// the current screen orientation of the browser
		Assert.assertEquals(ad.getOrientation().toString(), "PORTRAIT");	

	}
	
	@Test(priority = 5)
	public void verifyDeviceLocation() throws Exception {

		System.out.println("------verifyDeviceLocation real device------");
		Thread.sleep(4000);
		System.out.println("Device Location Info: " + ad.location());
		System.out.println("Device Location Info, Latitude: " + ad.location().getLatitude());
		System.out.println("Device Location Info, Longitude: " + ad.location().getLongitude());
		System.out.println("Device Location Info, Altitude: " + ad.location().getAltitude());
		//Validation Steps for location	

	}
	
	@Test(priority = 6)
	public void verifyViewFeature() throws Exception {

		System.out.println("------verifyViewFeature on API demo application real device------");
		Thread.sleep(4000);
		ad.findElementByXPath("//android.widget.TextView[@index='11']").click();
		//ad.findElementByXPath("//android.widget.TextView[@text='Views']").click();

	}
	
	
	@Test(priority = 7)
	public void verifyLockDeviceFeature() throws Exception {

		System.out.println("------lock a device------");
		Thread.sleep(4000);
		ad.lockDevice();				//lock a device
		
		System.out.println("Device lock/unlock Info: " + ad.isDeviceLocked()); 			//true
		Assert.assertTrue(ad.isDeviceLocked(), "verification of device locked state");

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
		
		ad.close();
		
	}
	
	@AfterMethod
	public void addLine() {
		
		System.out.println("***************************************");
		System.out.println("***************************************");
		
	}
	
}
