package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{

	
	
	@Test(priority = 1)
	public void verifyAppTitle() {
		
		lp.verifyAppTitle("OrangeHRM");
	}
	
	@Test(priority = 2)
	public void verifyLoginWithValidUserdetails() {
		
		System.out.println("login test case");
		lp.enterUserName(config.getAdminUser());
		lp.enterPassword(config.getAdminPassword());
		lp.clickLoginButton();
		
		//validation Step
		
		
		
	}
	
	@Test(priority = 3)
	public void verifyLogout() {
		
		System.out.println("logout test case");
		
	}
	
	
	@Test(priority = 1)
	public void verifyforgotPassword() {
		
		System.out.println("Is forgot password displayed on login page: " +lp.verifyForgotPasswordIsDisplayed());
		Assert.assertTrue(lp.verifyForgotPasswordIsDisplayed());
	}
	
	
}
