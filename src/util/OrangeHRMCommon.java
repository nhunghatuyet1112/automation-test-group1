package util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMCommon {
	WebDriver driver;
	WebDriverWait wait;

	public OrangeHRMCommon(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Login
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameOrangeHRM;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordOrangeHRM;
	@FindBy(xpath = "//div[starts-with(@class, 'oxd-form-actions')]/child::button")
	WebElement loginBtn;

	public void setUserName(String userName) {
		usernameOrangeHRM.sendKeys(userName);
	}

	public void setPassword(String password) {
		passwordOrangeHRM.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void loginToOrangeHRM(String userName, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogin();
	}

	// Dashboard
	@FindBy(xpath = "//li[@class=\"oxd-main-menu-item-wrapper\"]")
	List<WebElement> modules;
	@FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent']")
	List<WebElement> sections;
	@FindBy(xpath = "//li[@class='--active oxd-topbar-body-nav-tab --parent']/ul/li")
	List<WebElement> childSections;

	public void selectModule(String moduleName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(modules));
		for (int i = 0; i < modules.size(); i++) {
			if (modules.get(i).getText().equals(moduleName)) {
				modules.get(i).click();
				break;
			}
		}
	}

	public void selectSection(String sectionName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(sections));
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getText().equals(sectionName)) {
				sections.get(i).click();
				break;
			}
		}
	}

	public void selectChildSection(String childSectionName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(childSections));
		for (int i = 0; i < childSections.size(); i++) {
			if (childSections.get(i).getText().equals(childSectionName)) {
				childSections.get(i).click();
				break;
			}
		}
	}
}
