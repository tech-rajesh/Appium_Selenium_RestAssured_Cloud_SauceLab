package sauceLabIntegrationExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTestSauceLab{
	
	
	
	public void doLogin() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(priority = 1)
	public void check_DashboardTest() throws Exception {
		doLogin();
		Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
	}

	@Test(priority = 2)
	public void check_WelcomeTest() throws Exception {
		doLogin();
		Thread.sleep(2000);
		String welcomePaul = driver.findElement(By.id("welcome")).getText();
		Assert.assertTrue(welcomePaul.contains("Welcome"));
	}
	

}
