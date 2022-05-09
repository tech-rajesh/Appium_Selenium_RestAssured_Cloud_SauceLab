package testsNOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageNOP.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	LoginPage lp ;
	
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Create Object
		
		lp = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void teardown() throws Exception {
		
		Thread.sleep(4000);
		driver.close();
	}
	
	
	
	
	
	

}
