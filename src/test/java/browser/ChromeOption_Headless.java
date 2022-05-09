package browser;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOption_Headless {

	@Test
	public void AmazonTestHeadless() throws Exception {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//RadioButton - Male
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
		//Checkbox
		driver.findElement(By.xpath("//input[@value=\"Go\"]")).click();
		
		
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("iphone"));

	}

}
