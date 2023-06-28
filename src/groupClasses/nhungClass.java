package groupClasses;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class nhungClass {
	public WebDriver driver = new ChromeDriver();
	WebElement listElement = driver.findElement(By.id("booksCheckboxes"));
	List<WebElement> childElements = listElement.findElements(By.name("books"));
	boolean isFailed = false;
	
	@Test
	public void findElement() {
		String baseUrl = "https://chandanachaitanya.github.io/selenium-practice-site/";
		driver.get(baseUrl);
		for(int i = 0; i < childElements.size(); i++) {
			if(childElements.get(i).getAttribute("value").equals("Magazines")) {
				isFailed = false;
				Assert.assertEquals(true, true);
			}
			if(isFailed) {
				Reporter.log("\"There is no expected element : \" + Magazines \r\n"
						+ "+ \" in List\"");
				Assert.assertEquals(true, false);
			}
		}
	}
}