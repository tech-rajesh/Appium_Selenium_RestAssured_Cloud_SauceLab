package pageNOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver remotedriver) {

		this.driver = remotedriver;
		PageFactory.initElements(remotedriver, this);

	}

	// Identification
	@FindBy(id = "Email")
	WebElement txt_Email;

	@FindBy(xpath = "//label[@for='Email']")
	WebElement lbl_Email;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Actions/methods
	public void enterEmail(String emailValue) {

		txt_Email.clear();
		txt_Email.sendKeys(emailValue);

	}

	public void verifyEmailLabel() {

		Assert.assertTrue(lbl_Email.isDisplayed());

	}

	public void verifyEmailLabelText(String emailLabel) {

		String actualLabelText = getElementTxt(lbl_Email);
		String expectedLabelText = emailLabel;
		Assert.assertEquals(actualLabelText, expectedLabelText,"verification of Label get failed, actual value are: "+actualLabelText);

	}

	public String getElementTxt(WebElement ele) {

		return ele.getText();

	}

}
