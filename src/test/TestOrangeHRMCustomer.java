package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMCustomer;
import util.ExcelUtil;
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
	public void TC_OHRM_DC_01() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		objCustomer.addCustomer(ExcelUtil.getCellData(1, 2), ExcelUtil.getCellData(1, 4));
		objCustomer.clickTrashIcon(ExcelUtil.getCellData(1, 2));
		objCustomer.clickDeleteBtn();
		ExcelUtil.setCellData(1, 6, objCommon.getToastResult());
		if(objCommon.getToastResult().equals(ExcelUtil.getCellData(1, 5))) {
			Assert.assertTrue(true);
			ExcelUtil.setCellData(1, 7, "PASSED");
			ExcelUtil.fillGreenColour(1, 7);
		} else {
			Assert.assertTrue(false);
			ExcelUtil.setCellData(1, 7, "FAILED");
			ExcelUtil.fillRedColour(1, 7);
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(enabled=false)
	public void TC_OHRM_DC_02() {
		objCustomer.addCustomer("Van Lang University - Group 1", "Automation Test");
		objCustomer.clickCheckBox("Van Lang University - Group 1");
		objCustomer.clickDeleteSelectedBtn();
		objCustomer.clickDeleteBtn();
		Assert.assertTrue(objCommon.getToastResult().equals("Successfully Deleted"));
	}

	@Test(enabled=false)
	public void TC_OHRM_DC_03() {
		objCustomer.addCustomer("Van Lang University - Group 1 - 01", "Automation Test");
		objCustomer.addCustomer("Van Lang University - Group 1 - 02", "Automation Test");
		objCustomer.clickMultipleCheckBoxBtn();
		objCustomer.clickDeleteSelectedBtn();
		objCustomer.clickDeleteBtn();
		Assert.assertTrue(objCommon.getToastResult().equals("Successfully Deleted"));
	}

	@Test(enabled=false)
	public void TC_OHRM_DC_04() {
		objCustomer.addCustomer("Van Lang University - Group 1 - 01", "Automation Test");
		objCustomer.addCustomer("Van Lang University - Group 1 - 02", "Automation Test");
		objCustomer.clickMultipleCheckBoxBtn();
		objCustomer.clickTrashIcon("Van Lang University - Group 1 - 01");
		objCustomer.clickDeleteBtn();
		Assert.assertTrue(objCommon.getToastResult().equals("Successfully Deleted"));
	}

	@Test(enabled=false)
	public void TC_OHRM_DC_05() {
		objCustomer.clickTrashIcon("The Coca-Cola Company");
		Assert.assertTrue(objCommon.getToastResult().equals(
				"Not allowed to delete customer(s) associated with projects that have time logged against them"));
	}

	@Test(enabled=false)
	public void TC_OHRM_DC_06() {
		objCustomer.addCustomer("Van Lang University - Group 1 - 03", "Automation Test");
		objCustomer.clickTrashIcon("Van Lang University - Group 1 - 03");
		objCustomer.clickCancelBtn();
		Assert.assertEquals(objCustomer.checkExistCustomerName("Van Lang University - Group 1 - 03"), true);
	}

	@Test(enabled=false)
	public void TC_OHRM_DC_07() {
		objCustomer.addCustomer("Van Lang University - Group 1 - 04", "Automation Test");
		objCustomer.clickTrashIcon("Van Lang University - Group 1 - 04");
		objCustomer.clickXBtn();
		Assert.assertEquals(objCustomer.checkExistCustomerName("Van Lang University - Group 1 - 04"), true);
	}

	@AfterTest(enabled=false)
	public void afterTest() throws Exception {
		driver.close();
	}
}
