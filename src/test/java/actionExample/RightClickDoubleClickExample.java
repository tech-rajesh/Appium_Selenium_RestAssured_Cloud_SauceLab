package actionExample;

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

public class RightClickDoubleClickExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);	
		driver.close();

	}

	@Test
	public void rightClickTest() throws Exception {

		
		WebElement btnRightClick =driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		//btnRightClick.click();
		
		Actions act = new Actions(driver);
		act.contextClick(btnRightClick).perform();
		
		
		WebElement btnDelete =driver.findElement(By.xpath("//span[contains(text(),'Del')]"));
		btnDelete.click();
		Thread.sleep(2000);
		Alert delAlert = driver.switchTo().alert();
		System.out.println(delAlert.getText());
		delAlert.accept();
		
	}
	
	@Test
	public void doubleClickTest() throws Exception {

		
		WebElement btnDoubleClick =driver.findElement(By.xpath("//button[contains(text(),'Double-Click ')]"));
		//btnRightClick.click();
		
		Actions act = new Actions(driver);
		act.doubleClick(btnDoubleClick).perform();
		
		
		Thread.sleep(2000);
		Alert doubleClickAlert = driver.switchTo().alert();
		System.out.println("Double CLick Alert Text: "+doubleClickAlert.getText());
		doubleClickAlert.accept();
		
	}

}
