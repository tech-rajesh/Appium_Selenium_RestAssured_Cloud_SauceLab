package appiumtest;

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

public class AddNewContactTestOnRealDevices extends BaseTest{
	

	
	
	@Test(priority = 1)
	public void addContactTest() throws Exception {
		
		System.out.println("Add new contact application launched successfully.....");
		
		//click on contact
		//click on create new contact
		//enterFirstName, LastName, phone, org
		//click on save
	
		driver.findElements(By.id("com.google.android.dialer:id/navigation_bar_item_icon_view")).get(2).click();	
	
		Thread.sleep(2000);
		
		
		add.clickOnNewContact();
		add.enterFirstName("Pablo");
		
//		//XPATH
//		MobileElement CreateNewContact = driver.findElement(By.xpath("//android.widget.TextView[@text='Create new contact']"));
//		CreateNewContact.click();
//		Thread.sleep(2000);
		
//		MobileElement txtFirstName = driver.findElement(By.xpath("//android.widget.EditText[@text='First name']"));
//		txtFirstName.sendKeys("Ramesh");
//		Thread.sleep(2000);
		
		MobileElement txtLastName = driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']"));
		txtLastName.sendKeys("Boda");
		Thread.sleep(2000);
		
		MobileElement txtOrg = driver.findElement(By.xpath("//*[@text='Company']"));
		txtOrg.sendKeys("TCS");
		Thread.sleep(2000);
		
		MobileElement txtPhone = driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']"));
		txtPhone.sendKeys("9998887770");
		Thread.sleep(2000);
		
		MobileElement btnSave = driver.findElement(By.xpath("//android.widget.Button[@text='Save']"));
		btnSave.click();
		Thread.sleep(2000);
		
	}

}
