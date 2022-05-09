package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {

		this.driver = rdriver;

	}

	// Identification

	By txt_UserName = By.id("txtUsername");
	By txt_Password = By.cssSelector("input#txtPassword");
	By btn_Login = By.cssSelector("input#btnLogin");
	By lnk_ForgotPassword = By.linkText("Forgot your password?");
	
	

	// Actions/Methods

	public void enterUserName(String user) {

		driver.findElement(txt_UserName).clear();
		driver.findElement(txt_UserName).sendKeys(user);

	}

	public void enterPassword(String pass) {

		driver.findElement(txt_Password).clear();
		driver.findElement(txt_Password).sendKeys(pass);

	}

	public void clickLoginButton() {

		driver.findElement(txt_Password).click();

	}

	public void verifyAppTitle(String expectedTitle) {

		Assert.assertEquals(driver.getTitle(), expectedTitle);

	}
	
	public boolean verifyForgotPasswordIsDisplayed() {

		return driver.findElement(lnk_ForgotPassword).isDisplayed();

	}

}
