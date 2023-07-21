package orangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleteCustomer extends commonFunctions {
	private ChromeOptions options;
	private WebDriver driver;
	private JavascriptExecutor jse;
	private String baseUrl;

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		jse = (JavascriptExecutor) driver;
		baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		commonFunctions.toLogin(driver, baseUrl);
	}

	@Test
	public void TC_OHRM_DC_01() throws Exception {
		String expectedResult = "Successfully Deleted";
		String customerName = "Van Lang University - Group 1";
		String customerDescription = "Automation Test";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		commonFunctions.toAddDemoCustomer(driver, customerName, customerDescription);
		Thread.sleep(10000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement trashIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-trash']"));
		trashIcon.click();
		Thread.sleep(1000);
		WebElement deleteButton = driver.findElement(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
		deleteButton.click();
		Thread.sleep(1000);
		WebElement toastResult = driver.findElement(
				By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actualResult = toastResult.getText();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TC_OHRM_DC_02() throws Exception {
		String expectedResult = "Successfully Deleted";
		String customerName = "Van Lang University - Group 1";
		String customerDescription = "Automation Test";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		commonFunctions.toAddDemoCustomer(driver, customerName, customerDescription);
		Thread.sleep(10000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement checkBox = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/parent::div/child::div[1]//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
		checkBox.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(1000);
		WebElement deleteSelectedButton = driver.findElement(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']"));
		deleteSelectedButton.click();
		Thread.sleep(1000);
		WebElement deleteButton = driver.findElement(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
		deleteButton.click();
		Thread.sleep(1000);
		WebElement toastResult = driver.findElement(
				By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actualResult = toastResult.getText();
		jse.executeScript("window.scrollBy(0,200)");
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TC_OHRM_DC_03() throws Exception {
		String expectedResult = "Successfully Deleted";
		String customerName1 = "Van Lang University - Group 1 - 01";
		String customerDescription1 = "Automation Test";
		String customerName2 = "Van Lang University - Group 1 - 02";
		String customerDescription2 = "Automation Test";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		commonFunctions.toAddDemoCustomer(driver, customerName1, customerDescription1);
		Thread.sleep(7000);
		commonFunctions.toAddDemoCustomer(driver, customerName2, customerDescription2);
		Thread.sleep(10000);
		WebElement multipleCheckBox = driver.findElement(By.xpath(
				"//div[text()='Name']/parent::div/child::div[1]//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
		multipleCheckBox.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(1000);
		WebElement deleteSelectedButton = driver.findElement(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']"));
		deleteSelectedButton.click();
		Thread.sleep(1000);
		WebElement deleteButton = driver.findElement(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
		deleteButton.click();
		Thread.sleep(1000);
		WebElement toastResult = driver.findElement(
				By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actualResult = toastResult.getText();
		jse.executeScript("window.scrollBy(0,200)");
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TC_OHRM_DC_04() throws Exception {
		String expectedResult = "Successfully Deleted";
		String customerName1 = "Van Lang University - Group 1 - 01";
		String customerDescription1 = "Automation Test";
		String customerName2 = "Van Lang University - Group 1 - 02";
		String customerDescription2 = "Automation Test";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		commonFunctions.toAddDemoCustomer(driver, customerName1, customerDescription1);
		Thread.sleep(7000);
		commonFunctions.toAddDemoCustomer(driver, customerName2, customerDescription2);
		Thread.sleep(10000);
		WebElement multipleCheckBox = driver.findElement(By.xpath(
				"//div[text()='Name']/parent::div/child::div[1]//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
		multipleCheckBox.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement trashIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='"
				+ customerName1 + "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-trash']"));
		trashIcon.click();
		Thread.sleep(1000);
		WebElement deleteButton = driver.findElement(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
		deleteButton.click();
		Thread.sleep(1000);
		WebElement toastResult = driver.findElement(
				By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actualResult = toastResult.getText();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TC_OHRM_DC_05() throws Exception {
		String expectedResult = "Not allowed to delete customer(s) associated with projects that have time logged against them";
		String customerName = "The Coca-Cola Company";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement trashIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-trash']"));
		trashIcon.click();
		Thread.sleep(1000);
		WebElement toastResult = driver.findElement(
				By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actualResult = toastResult.getText();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TC_OHRM_DC_06() throws Exception {
		Boolean expectedResult = true;
		Boolean actualResult = false;
		String customerName = "Van Lang University - Group 1 - 03";
		String customerDescription = "Automation Test";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		commonFunctions.toAddDemoCustomer(driver, customerName, customerDescription);
		Thread.sleep(10000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement trashIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-trash']"));
		trashIcon.click();
		Thread.sleep(1000);
		WebElement cancelButton = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']"));
		cancelButton.click();
		List<WebElement> customerNameList = driver
				.findElements(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName + "']"));
		if (customerNameList.size() > 0) {
			actualResult = true;
		}
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TC_OHRM_DC_07() throws Exception {
		Boolean expectedResult = true;
		Boolean actualResult = false;
		String customerName = "Van Lang University - Group 1 - 04";
		String customerDescription = "Automation Test";
		commonFunctions.toSelectModule(driver, "Time");
		commonFunctions.toSelectSection(driver, "Project Info", true, "Customers");
		commonFunctions.toAddDemoCustomer(driver, customerName, customerDescription);
		Thread.sleep(10000);
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		WebElement trashIcon = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName
				+ "']/parent::div/following-sibling::div[2]//i[@class='oxd-icon bi-trash']"));
		trashIcon.click();
		Thread.sleep(1000);
		WebElement xButton = driver
				.findElement(By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']"));
		xButton.click();
		List<WebElement> customerNameList = driver
				.findElements(By.xpath("//div[@class='oxd-table-body']//div[text()='" + customerName + "']"));
		if (customerNameList.size() > 0) {
			actualResult = true;
		}
		Assert.assertEquals(actualResult, expectedResult);
	}
}
