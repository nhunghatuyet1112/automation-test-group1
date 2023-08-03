package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMCustomer {
	WebDriver driver;
	WebDriverWait wait;

	public OrangeHRMCustomer(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//form//div[@class='oxd-form-row'][1]//input")
	WebElement customerNameOrangeHRM;
	@FindBy(xpath = "//form//div[@class='oxd-form-row'][2]//textarea")
	WebElement customerDescriptionOrangeHRM;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addBtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	public void addCustomer(String customerName, String customerDescription) {
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
		customerNameOrangeHRM.sendKeys(customerName);
		customerDescriptionOrangeHRM.sendKeys(customerDescription);
		saveBtn.click();
	}
}
