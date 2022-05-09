package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFactory {

	WebDriver driver;

	public LoginPageFactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Identification

//	By txt_UserName = By.id("txtUsername");
//	By txt_Password = By.cssSelector("input#txtPassword");
//	By btn_Login = By.cssSelector("input#btnLogin");
//	By lnk_ForgotPassword = By.linkText("Forgot your password?");
	
	@FindBy(id = "txtUsername")
	WebElement txt_UserName;
	
	@FindBy(css = "input#txtPassword")
	WebElement txt_Password;
	
	@FindBy(how = How.CSS, using = "input#btnLogin")
	WebElement btn_Login;
	
	@FindBy(css = "input#btnLogin")
	WebElement btn_Login1;
	
	@FindBy(linkText =  "Forgot your password?")
	WebElement lnk_ForgotPassword;
	

	// Actions/Methods

	public void enterUserName(String user) {
		System.out.println("enter userName : " + user);
		txt_UserName.clear();
		txt_UserName.sendKeys(user);

	}

	public void enterPassword(String pass) {

		System.out.println("enter password : " + pass);
		txt_Password.clear();
		txt_Password.sendKeys(pass);

	}

	public void clickLoginButton() {

		System.out.println("click on login button");
		btn_Login.click();

	}

	public void verifyAppTitle(String expectedTitle) {

		Assert.assertEquals(driver.getTitle(), expectedTitle);

	}
	
	public boolean verifyForgotPasswordIsDisplayed() {

		return lnk_ForgotPassword.isDisplayed();

	}

}
