package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AddNewContactPage {

	AppiumDriver<MobileElement> driver;

	public AddNewContactPage(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "com.google.android.dialer:id/navigation_bar_item_icon_view")
	MobileElement lnl_Contact;
	
	@FindBy(xpath  = "//android.widget.TextView[@text='Create new contact']")
	MobileElement lnk_CreateNewContact;
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[@text='First name']")
	MobileElement txt_FirstName;
	
	@FindBy(xpath  = "//android.widget.EditText[@text='Last name']")
	MobileElement txt_LastName;
	
	

	// Actions/Methods

	public void clickContact() {
		
		lnl_Contact.click();

	}

	public void clickOnNewContact() {

		
		lnk_CreateNewContact.click();

	}

	public void enterFirstName(String fname) {

		System.out.println("enter value in firstName");
		txt_FirstName.clear();
		txt_FirstName.sendKeys(fname);

	}

	public void enterLastName(String fname) {

		System.out.println("enter value in lastName");
		txt_FirstName.clear();
		txt_FirstName.sendKeys(fname);

	}
	
	

}
