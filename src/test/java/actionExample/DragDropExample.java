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

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);	
		driver.close();

	}

	//@Test
	public void dragDropTest() throws Exception {

		
		WebElement dragDropFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'droppable/photo')]"));
		driver.switchTo().frame(dragDropFrame);
		
		
		WebElement Image3 =driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement Image4 =driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement trash =driver.findElement(By.cssSelector("div#trash"));
		
				
		Actions act = new Actions(driver);
		act.dragAndDrop(Image3, trash).perform();
		act.dragAndDrop(Image4, trash).perform();
		
		
		
	}
	
	@Test
	public void dragDropTest2() throws Exception {

		
		WebElement dragDropFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'droppable/photo')]"));
		driver.switchTo().frame(dragDropFrame);
		
		
		WebElement Image3 =driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement Image4 =driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement trash =driver.findElement(By.cssSelector("div#trash"));
		
				
		Actions act = new Actions(driver);
		//act.dragAndDrop(Image3, trash).perform();
		
		act.clickAndHold(Image3).moveToElement(trash).release().build().perform();
		
		
	}
	
	
}
