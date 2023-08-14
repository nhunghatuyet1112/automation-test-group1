package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMCustomer {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public OrangeHRMCustomer(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[text()='Customers']")
	WebElement pageTitle;
	@FindBy(xpath = "//form//div[@class='oxd-form-row'][1]//input")
	WebElement customerNameOrangeHRM;
	@FindBy(xpath = "//form//div[@class='oxd-form-row'][2]//textarea")
	WebElement customerDescriptionOrangeHRM;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addBtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	WebElement cancelEditBtn;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	WebElement deleteBtn;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']")
	WebElement cancelBtn;
	@FindBy(xpath = "//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")
	WebElement xBtn;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")
	WebElement deleteSelectedBtn;
	@FindBy(xpath = "//div[text()='Name']/parent::div/child::div[1]//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
	WebElement multipleCheckBoxBtn;
	@FindBy(xpath = "//div[@class='oxd-table-body']/child::div/child::div/child::div[2]/div")
	List<WebElement> customerNames;

	public void scrollPageUpDown(int height) {
		wait.until(ExpectedConditions.visibilityOf(pageTitle));
		jse.executeScript("window.scrollBy(0," + height + ")");
	}

	public void addCustomer(String customerName, String customerDescription) {
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
		customerNameOrangeHRM.sendKeys(customerName);
		customerDescriptionOrangeHRM.sendKeys(customerDescription);
		saveBtn.click();
	}
	
	public void editCustomer(String customerName, String customerDescription, boolean isCancel) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		customerNameOrangeHRM.click();
		customerNameOrangeHRM.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
		customerNameOrangeHRM.sendKeys(customerName);
		Thread.sleep(2000);
		customerDescriptionOrangeHRM.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
		customerDescriptionOrangeHRM.sendKeys(customerDescription);
		if (isCancel) {
			Thread.sleep(1000);
			cancelEditBtn.click();
		} else {
			Thread.sleep(1000);
			saveBtn.click();
		}
			
	}
	
	public void clickPencilIcon(String customerName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement pencilIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-pencil-fill']"));
		Thread.sleep(2000);
		pencilIcon.click();
	}

	public void editCustomer(String customerName, String customerDescription, boolean isCancel)
			throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		customerNameOrangeHRM.click();
		customerNameOrangeHRM.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
		customerNameOrangeHRM.sendKeys(customerName);
		Thread.sleep(2000);
		customerDescriptionOrangeHRM.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
		customerDescriptionOrangeHRM.sendKeys(customerDescription);
		if (isCancel) {
			Thread.sleep(1000);
			cancelEditBtn.click();
		} else {
			Thread.sleep(1000);
			saveBtn.click();
		}

	}

	public void clickPencilIcon(String customerName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement pencilIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='"
				+ customerName + "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-pencil-fill']"));
		Thread.sleep(2000);
		pencilIcon.click();
	}

	public void clickTrashIcon(String customerName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement trashIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-trash']"));
		trashIcon.click();
	}

	public void clickCheckBox(String customerName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement checkBox = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/parent::div/child::div[1]//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
		checkBox.click();
	}

	public void clickDeleteBtn() {
		wait.until(ExpectedConditions.visibilityOf(deleteBtn));
		deleteBtn.click();
	}

	public void clickCancelBtn() {
		wait.until(ExpectedConditions.visibilityOf(cancelBtn));
		cancelBtn.click();
	}

	public void clickXBtn() {
		wait.until(ExpectedConditions.visibilityOf(xBtn));
		xBtn.click();
	}

	public void clickDeleteSelectedBtn() {
		wait.until(ExpectedConditions.visibilityOf(deleteSelectedBtn));
		deleteSelectedBtn.click();
	}

	public void clickMultipleCheckBoxBtn() {
		multipleCheckBoxBtn.click();
	}

	public String checkExistCustomerName(String customerName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(customerNames));
		String isExist = "";
		for (int i = 0; i < customerNames.size(); i++) {
			if (customerNames.get(i).getText().equals(customerName)) {
				isExist = "Exist on the table";
				break;
			}
		}
		return isExist;
	}
}
