package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMCustomer;
import util.OrangeHRMCommon;

public class TestOrangeHRMCustomer {
	WebDriver driver;
	OrangeHRMCommon objCommon;
	OrangeHRMCustomer objCustomer;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		objCommon = new OrangeHRMCommon(driver);
		objCommon.loginToOrangeHRM("Admin", "admin123");
		objCustomer = new OrangeHRMCustomer(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		objCommon.selectModule("Time");
		objCommon.selectSection("Project Info");
		objCommon.selectChildSection("Customers");
	}

	@Test
	public void test() {
		objCustomer.addCustomer("Van Lang University - Group 1", "Automation Test");
	}
}
