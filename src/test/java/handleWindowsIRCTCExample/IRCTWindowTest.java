package handleWindowsIRCTCExample;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//1.) IRCTC App - https://www.irctc.co.in/nget/train-search
//2.) Click on OK button
//3.) click on "Hotel"
//4.) Switch to Hotel Page
//5.) Click on Login link on Hotel Page
//6.) Switch to Main IRCTC Page
//7.) Click on Contact US on Main Page
//8.) Switch To Hotel Page --- click on Login without entering userName and password
//9.) Validation Step
//	Verify "User Name is required." displayed on page 
//
//10.) Switch to Main IRCTC Page - extract email ID from Contact - imudracare@irctc.co.in

public class IRCTWindowTest {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		driver.quit();

		// close and quit

	}

	@Test
	public void SwitchingTestCase1() throws Exception {

		// switch - alert/frame/window
		// click on OK button
		driver.findElement(By.xpath("//button[contains(text(),'K')]")).click();

		// handle windows

		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);

		// click on Hotels
		driver.findElement(By.partialLinkText("HOTELS")).click();

		Set<String> AllWindowHandles = driver.getWindowHandles();

		String mainIRCTCWindow = (String) AllWindowHandles.toArray()[0];		//main window
		String hotelWindow = (String) AllWindowHandles.toArray()[1];		//hotel window
		
		
		Thread.sleep(4000);
		
		//Switch to hotelWindow
		
		driver.switchTo().window(hotelWindow);
		
		//click on Login
		
		driver.findElement(By.linkText("Login")).click();
		
		
		Thread.sleep(4000);
		
		//Switch to hotelWindow
		
		driver.switchTo().window(parentWindow);
		
		//click on Contact US
		driver.findElement(By.xpath("//a[contains(text(),'CONTACT US')]")).click();
		
		System.out.println("Main window: " + mainIRCTCWindow);
		System.out.println("-------------");
		System.out.println("parent window: " + parentWindow);
		
		System.out.println("-------------");
		System.out.println("Hotel window: " + hotelWindow);
		
		
		
		
		

	}

}
