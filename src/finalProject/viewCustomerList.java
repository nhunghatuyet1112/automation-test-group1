package finalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class viewCustomerList {
	private ChromeOptions options;
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	}
	
	@Test
	public void firstTest() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(5000);
		
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		login.click();
	}
}
