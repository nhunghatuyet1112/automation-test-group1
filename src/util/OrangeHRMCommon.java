package util;

import java.time.Duration;
import java.util.List;

import javax.management.relation.RoleResult;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

	// Toast
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement toastResult;

	public String getToastResult() {
		wait.until(ExpectedConditions.visibilityOf(toastResult));
		return toastResult.getText();
	}

	// Assert and Excel
	public int testResult(String path, String sheetName) throws Exception {
		int countPassed = 0;
		int rowTestCase = ExcelUtil.getRowCount(path, sheetName) - 1;
		int colResult = ExcelUtil.getCellCount(path, sheetName, 1) - 1;
		for (int i = 1; i <= rowTestCase; i++) {
			if (ExcelUtil.getCellData(i, colResult).equals("PASSED")) {
				countPassed += 1;
			}
		}
		return countPassed;
	}

	public void testCompleted(int rolNum, int colNum, boolean isPassed, String message) throws Exception {
		ExcelUtil.setCellData(rolNum, colNum, message);
		if (isPassed) {
			ExcelUtil.fillGreenColour(rolNum, colNum);
		} else {
			ExcelUtil.fillRedColour(rolNum, colNum);
		}
		Assert.assertTrue(isPassed);
	}
	
	public void writeResult(String path, String sheetName, int rowResult, int colResult) throws Exception {
		ExcelUtil.openFile(path, sheetName);
		int countTested = 0;
		int rowTestCase = ExcelUtil.getRowCount(path, sheetName) - 1;
		int colTestCase = ExcelUtil.getCellCount(path, sheetName, 1) - 1;
		for (int i = 1; i <= rowTestCase; i++) {
			if (!ExcelUtil.getCellData(i, colTestCase).equals("")) {
				countTested += 1;
			}
		}
		if (countTested == rowTestCase) {
			String testResultMessage = String.valueOf(testResult(path, sheetName)) + "/"
					+ (ExcelUtil.getRowCount(path, sheetName) - 1);
			ExcelUtil.setCellDataResult(rowResult, colResult, testResultMessage);
		}
		ExcelUtil.saveAndCloseFile(path);
	}
}
