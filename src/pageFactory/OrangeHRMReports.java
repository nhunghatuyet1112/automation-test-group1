package pageFactory;

import static org.testng.Assert.assertEquals;

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
import org.testng.Reporter;

public class OrangeHRMReports {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public OrangeHRMReports(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h5[text()='Employee Report']")
	WebElement pageTitle;
	@FindBy(xpath = "//form/div[@class='oxd-form-row'][1]//input")
	WebElement employeeNameOrangeHRM;
	@FindBy(xpath = "//form/div[@class='oxd-form-row'][2]//input")
	WebElement projectNameOrangeHRM;
	@FindBy(xpath = "//form/div[@class='oxd-form-row'][2]//i[@class ='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement selectActivityBtn;
	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
	List<WebElement> dropdownListOptions;
	@FindBy(xpath = "//div[@class='oxd-select-option']")
	List<WebElement> activityOptions;
	@FindBy(xpath = "//form/div[@class='oxd-form-row'][3]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input")
	WebElement projectStartDate;
	@FindBy(xpath = "//form/div[@class='oxd-form-row'][3]//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input")
	WebElement projectEndDate;
	@FindBy(xpath = "//form/div[@class='oxd-form-row'][3]//span")
	WebElement includeApprovedTimesheetsBtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement viewBtn;
	
	public void scrollPageUpDown(int height) {
		wait.until(ExpectedConditions.visibilityOf(pageTitle));
		jse.executeScript("window.scrollBy(0," + height + ")");
	}
	
	public void selectEmployee(String employeeName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(viewBtn));
		employeeNameOrangeHRM.sendKeys(employeeName);
		for(int i = 1; i <= dropdownListOptions.size(); i++)  {
			WebElement dropdownListOption = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option'][" + i + "]//span"));
			wait.until(ExpectedConditions.visibilityOf(dropdownListOption));
			if(dropdownListOption.getText().contains(employeeName)) {
				dropdownListOption.click();
				break;
			} else {
				System.out.println("Cannot find any employee");
			}
		}
	}
	
	public void selectProject(String projectName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(viewBtn));
		projectNameOrangeHRM.sendKeys(projectName);
		for(int i = 1; i <= dropdownListOptions.size(); i++)  {
			WebElement dropdownListOption = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option'][" + i + "]//span"));
			wait.until(ExpectedConditions.visibilityOf(dropdownListOption));
			if(dropdownListOption.getText().contains(projectName)) {
				dropdownListOption.click();
				break;
			} else {
				System.out.println("Cannot find any project");
			}
		}
	}
	
    public void selectActivity(String activityName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(viewBtn));
        selectActivityBtn.click();
        Thread.sleep(3000);
        for(int i = 2; i <= activityOptions.size(); i++) {
        	WebElement activityOption = driver.findElement(By.xpath("//div[@class='oxd-select-option'][2]//span"));
            if(activityOption.getText().contentEquals(activityName)) {
                activityOptions.get(i-1).click();
                break;
            } else {
                System.out.println("Cannot find any activity");
            }
        }
    }
	
	public void selectDateRange(String startDate, String endDate) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(viewBtn));
		projectStartDate.click();
		projectStartDate.sendKeys(startDate);
		Thread.sleep(1000);
		projectEndDate.click();
		projectEndDate.sendKeys(endDate);
	}
	
	public void onlyApprovedTimesheets(boolean isIncluded) {
		wait.until(ExpectedConditions.visibilityOf(viewBtn));
		if(isIncluded) {
			includeApprovedTimesheetsBtn.click();
			viewBtn.click();
		} else {
			viewBtn.click();
		}
	}
	
}

