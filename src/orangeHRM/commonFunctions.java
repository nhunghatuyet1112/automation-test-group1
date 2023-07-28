package orangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonFunctions {
	public static void toLogin(WebDriver driver, String baseUrl) throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement userNameInput = driver.findElement(By.xpath("//input[@name='username']"));
		userNameInput.sendKeys("Admin");
		WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
		passwordInput.sendKeys("admin123");
		WebElement loginBtn = driver
				.findElement(By.xpath("//div[starts-with(@class, 'oxd-form-actions')]/child::button"));
		loginBtn.click();
	}

	public static void toSelectModule(WebDriver driver, String moduleName) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> modules = driver.findElements(By.xpath("//li[@class=\"oxd-main-menu-item-wrapper\"]"));
		for (int i = 0; i < modules.size(); i++) {
			if (modules.get(i).getText().equals(moduleName)) {
				modules.get(i).click();
				break;
			}
		}
	}

	public static void toSelectSection(WebDriver driver, String sectionName, boolean isSelectChild,
			String childSectionName) throws Exception {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> sections = driver.findElements(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']"));
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getText().equals(sectionName)) {
				sections.get(i).click();
				break;
			}
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		if (isSelectChild == true) {
			List<WebElement> selectedSection = driver
					.findElements(By.xpath("//li[@class='--active oxd-topbar-body-nav-tab --parent']/ul/li"));
			for (int i = 0; i < selectedSection.size(); i++) {
				if (selectedSection.get(i).getText().equals(childSectionName)) {
					selectedSection.get(i).click();
					break;
				}
			}
		} else {
			childSectionName = "";
		}
	}

	public static void selectToEdit(WebDriver driver, String selectedName) throws Exception {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> nameColumns = driver
				.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']/div/div[2]"));
		for (int i = 0; i < nameColumns.size(); i++) {
			if (nameColumns.get(i).getText().equals(selectedName)) {
				WebElement editButton = driver
						.findElement(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][" + (i + 1)
								+ "]/div/div[4]/div/button[2]"));
				editButton.click();
				break;

			}
		}
	}

	public static void toAddDemoCustomer(WebDriver driver, String customerName, String customerDescription) throws Exception {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement addButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		addButton.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement name = driver.findElement(By.xpath("//form//div[@class='oxd-form-row'][1]//input"));
		name.sendKeys(customerName);
		WebElement description = driver.findElement(By.xpath("//form//div[@class='oxd-form-row'][2]//textarea"));
		description.sendKeys(customerDescription);
		WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
		saveButton.click();
	}
}