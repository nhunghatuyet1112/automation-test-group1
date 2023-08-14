package pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMProject {
	WebDriver driver;
	WebDriverWait wait;

	public OrangeHRMProject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addBtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//label[text()='Name']/parent::div/parent::div/child::div[2]/input")
	WebElement projectNameOrangeHRM;
	@FindBy(xpath = "//label[text()='Description']/parent::div/parent::div/child::div[2]/textarea")
	WebElement projectDescriptionOrangeHRM;
	@FindBy(xpath = "//label[text()='Customer Name']/parent::div/parent::div/child::div[2]//input")
	WebElement customerNameOrangeHRM;
	@FindBy(xpath = "//label[text()='Project Admin']/parent::div/parent::div/child::div[2]//input")
	WebElement projectAdminOrangeHRM;
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	WebElement errorMessage;

	public void clickAddBtn() {
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
	}

	public void setProjectName(String projectName) {
		wait.until(ExpectedConditions.visibilityOf(projectNameOrangeHRM));
		projectNameOrangeHRM.sendKeys(projectName);
	}

	public void setProjectDescription(String projectDescription) {
		wait.until(ExpectedConditions.visibilityOf(projectDescriptionOrangeHRM));
		projectDescriptionOrangeHRM.sendKeys(projectDescription);
	}

	public void setCustomerName(String customerName) {
		wait.until(ExpectedConditions.visibilityOf(customerNameOrangeHRM));
		customerNameOrangeHRM.sendKeys(customerName);
		chooseName(customerName);
	}

	public void setCustomerNameExceptChoose(String customerName) {
		wait.until(ExpectedConditions.visibilityOf(customerNameOrangeHRM));
		customerNameOrangeHRM.sendKeys(customerName);
	}

	public void setProjectAdmin(String projectAdmin) {
		wait.until(ExpectedConditions.visibilityOf(projectAdminOrangeHRM));
		projectAdminOrangeHRM.sendKeys(projectAdmin);
		chooseName(projectAdmin);
	}

	public void setProjectAdminExceptChoose(String projectAdmin) {
		wait.until(ExpectedConditions.visibilityOf(projectAdminOrangeHRM));
		projectAdminOrangeHRM.sendKeys(projectAdmin);
	}

	public void chooseName(String name) {
		WebElement nameChose = driver.findElement(By.xpath("//div[@role='listbox']/div/span[text()='" + name + "']"));
		wait.until(ExpectedConditions.visibilityOf(nameChose));
		nameChose.click();
	}

	public void addProject(String projectName, String projectDescription, String customerName, String projectAdmin) {
		setProjectName(projectName);
		setProjectDescription(projectDescription);
		setCustomerName(customerName);
		setProjectAdmin(projectAdmin);
	}

	public void addProjectExceptCustomer(String projectName, String projectDescription, String projectAdmin) {
		setProjectName(projectName);
		setProjectDescription(projectDescription);
		setProjectAdmin(projectAdmin);
	}

	public void addProjectExceptChooseCustomer(String projectName, String projectDescription, String customerName,
			String projectAdmin) {
		setProjectName(projectName);
		setProjectDescription(projectDescription);
		setCustomerNameExceptChoose(customerName);
		setProjectAdmin(projectAdmin);
	}

	public void addProjectExceptAdmin(String projectName, String projectDescription, String customerName) {
		setProjectName(projectName);
		setProjectDescription(projectDescription);
		setCustomerName(customerName);
	}

	public void clickSaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
	}

	public String checkChooseCustomerNameInSuggestedList(String customerName) {
		String result = "Chose value out of the suggested list";
		WebElement customerNameChose = driver
				.findElement(By.xpath("//div[@role='listbox']/div/span[text()='" + customerName + "']"));
		wait.until(ExpectedConditions.visibilityOf(customerNameChose));
		String customerNameChoseData = customerNameChose.getText();
		customerNameChose.click();
		if (customerNameOrangeHRM.getAttribute("value").equals(customerNameChoseData)) {
			result = "Chose value in the suggested list";
		}
		return result;
	}

	public String checkChooseProjectAdminInSuggestedList(String projectAdmin) {
		String result = "Chose value out of the suggested list";
		WebElement projectAdminChose = driver
				.findElement(By.xpath("//div[@role='listbox']/div/span[text()='" + projectAdmin + "']"));
		wait.until(ExpectedConditions.visibilityOf(projectAdminChose));
		projectAdminChose.click();
		if (projectAdminOrangeHRM.getAttribute("value").equals(projectAdmin)) {
			result = "Chose value in the suggested list";
		}
		return result;
	}

	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
	}
}
