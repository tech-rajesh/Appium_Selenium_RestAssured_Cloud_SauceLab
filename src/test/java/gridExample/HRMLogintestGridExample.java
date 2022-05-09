package gridExample;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLogintestGridExample {

	WebDriver driver;

	@Parameters("platform")
	@BeforeTest
	public void setup(String platform_os) throws Exception {

		
		if(platform_os.equalsIgnoreCase("win"))
		{
			String nodeURL = "http://192.168.1.5:5599/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities().chrome();

			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			

			//System.setProperty("webdriver.chrome.driver", "D:\\Jar_files\\UpdatedFolder\\grid_setup\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
			
		}
		
		else {
			
			String nodeURL = "http://192.168.1.5:5588/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities().chrome();

			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);

			//System.setProperty("webdriver.chrome.driver", "D:\\Jar_files\\UpdatedFolder\\grid_setup\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
			
		}
		

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}

	@AfterTest
	public void teardown() throws Exception {

		Thread.sleep(4000);
		driver.quit();

	}

	@Test
	public void loginWithValidUserDetails() throws Exception {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

	}

}
