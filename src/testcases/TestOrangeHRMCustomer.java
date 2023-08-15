package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMCustomer;
import util.ExcelUtil;
import util.OrangeHRMCommon;

@Listeners(testcases.ListenerTest.class)

public class TestOrangeHRMCustomer {
	WebDriver driver;
	OrangeHRMCommon objCommon;
	OrangeHRMCustomer objCustomer;

	@BeforeTest(groups = { "edit-customer", "delete-customer" })
	public void beforeTest() {
		driver = new ChromeDriver();
		Reporter.log("Browser Open");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");
		driver.get("https://opensource-demo.orangehrmlive.com");
		Reporter.log("Application Started");
		objCommon = new OrangeHRMCommon(driver);
		objCommon.loginToOrangeHRM("Admin", "admin123");
		objCustomer = new OrangeHRMCustomer(driver);
		Reporter.log("Signing In");
	}

	@BeforeMethod(groups = { "edit-customer", "delete-customer" })
	public void beforeMethod() {
		objCommon.selectModule("Time");
		objCommon.selectSection("Project Info");
		objCommon.selectChildSection("Customers");
		Reporter.log("Selecting Section");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_01() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.addCustomer(ExcelUtil.getCellData(1, 2), ExcelUtil.getCellData(1, 4));
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(1, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(1, 3), ExcelUtil.getCellData(1, 4), false);
		ExcelUtil.setCellData(1, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(ExcelUtil.getCellData(1, 5))) {
			objCommon.testCompleted(1, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(1, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_02() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(1, 3));
		objCustomer.editCustomer(ExcelUtil.getCellData(2, 2), ExcelUtil.getCellData(2, 4), false);
		ExcelUtil.setCellData(2, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(ExcelUtil.getCellData(2, 5))) {
			objCommon.testCompleted(2, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(2, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_03() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(2, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(3, 2), ExcelUtil.getCellData(3, 4), false);
		ExcelUtil.setCellData(3, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(ExcelUtil.getCellData(3, 5))) {
			objCommon.testCompleted(3, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(3, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_04() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(3, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(4, 2), ExcelUtil.getCellData(4, 4), false);
		ExcelUtil.setCellData(4, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(ExcelUtil.getCellData(4, 5))) {
			objCommon.testCompleted(4, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(4, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_05() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(4, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(5, 2), ExcelUtil.getCellData(5, 4), false);
		ExcelUtil.setCellData(5, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(ExcelUtil.getCellData(5, 5))) {
			objCommon.testCompleted(5, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(5, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_06() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(5, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(6, 2), ExcelUtil.getCellData(6, 4), false);
		ExcelUtil.setCellData(6, 6, objCommon.getRequiredText());
		if (objCommon.getRequiredText().equals(ExcelUtil.getCellData(6, 5))) {
			objCommon.testCompleted(6, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(6, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_07() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(5, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(7, 2), ExcelUtil.getCellData(7, 4), false);
		ExcelUtil.setCellData(7, 6, objCommon.getRequiredText());
		if (objCommon.getRequiredText().equals(ExcelUtil.getCellData(7, 5))) {
			objCommon.testCompleted(7, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(7, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_08() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(5, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(8, 2), ExcelUtil.getCellData(8, 4), false);
		ExcelUtil.setCellData(8, 6, objCommon.getRequiredText());
		if (objCommon.getRequiredText().equals(ExcelUtil.getCellData(8, 5))) {
			objCommon.testCompleted(8, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(8, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_09() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(5, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(9, 2), ExcelUtil.getCellData(9, 4), false);
		ExcelUtil.setCellData(9, 6, objCommon.getRequiredText());
		if (objCommon.getRequiredText().equals(ExcelUtil.getCellData(9, 5))) {
			objCommon.testCompleted(9, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(9, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_10() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(5, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(10, 2), ExcelUtil.getCellData(10, 4), true);
		ExcelUtil.setCellData(10, 6, objCommon.getCurrentUrl());
		if (objCommon.getCurrentUrl().contains(ExcelUtil.getCellData(10, 5))) {
			objCommon.testCompleted(10, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(10, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "edit-customer" })
	public void TC_OHRM_EC_11() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EditCustomer");
		objCustomer.clickPencilIcon(ExcelUtil.getCellData(5, 2));
		objCustomer.editCustomer(ExcelUtil.getCellData(11, 2), ExcelUtil.getCellData(11, 4), true);
		ExcelUtil.setCellData(11, 6, objCommon.getCurrentUrl());
		if (objCommon.getCurrentUrl().contains(ExcelUtil.getCellData(11, 5))) {
			objCommon.testCompleted(11, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(11, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_01() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.addCustomer(ExcelUtil.getCellData(1, 2), ExcelUtil.getCellData(1, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.clickTrashIcon(ExcelUtil.getCellData(1, 2));
		Reporter.log("Open Delete Form");
		objCustomer.clickDeleteBtn();
		Reporter.log("Delete Customer");
		ExcelUtil.setCellData(1, 6, objCommon.getToastResult());
		objCommon.checkTestResult(1, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_02() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.addCustomer(ExcelUtil.getCellData(2, 2), ExcelUtil.getCellData(2, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.clickCheckBox(ExcelUtil.getCellData(2, 2));
		Reporter.log("Tick The Empty Box To The Left Of The Customer Name");
		objCustomer.clickDeleteSelectedBtn();
		Reporter.log("Open Delete Form");
		objCustomer.clickDeleteBtn();
		Reporter.log("Delete Customer");
		ExcelUtil.setCellData(2, 6, objCommon.getToastResult());
		objCommon.checkTestResult(2, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_03() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.addCustomer(ExcelUtil.getCellData(3, 2), ExcelUtil.getCellData(3, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.addCustomer(ExcelUtil.getCellData(3, 3), ExcelUtil.getCellData(3, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.clickMultipleCheckBoxBtn();
		Reporter.log("Tick Multiple Empty Boxes To The Left Of The Customer Name");
		objCustomer.clickDeleteSelectedBtn();
		Reporter.log("Open Delete Form");
		objCustomer.clickDeleteBtn();
		Reporter.log("Delete Customer");
		ExcelUtil.setCellData(3, 6, objCommon.getToastResult());
		objCommon.checkTestResult(3, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_04() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.addCustomer(ExcelUtil.getCellData(4, 2), ExcelUtil.getCellData(4, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.addCustomer(ExcelUtil.getCellData(4, 3), ExcelUtil.getCellData(4, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.clickMultipleCheckBoxBtn();
		Reporter.log("Tick Multiple Empty Boxes To The Left Of The Customer Name");
		objCustomer.clickTrashIcon(ExcelUtil.getCellData(4, 2));
		Reporter.log("Open Delete Form Of 1 Customer");
		objCustomer.clickDeleteBtn();
		Reporter.log("Delete Customer");
		ExcelUtil.setCellData(4, 6, objCommon.getToastResult());
		objCommon.checkTestResult(4, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_05() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.clickTrashIcon(ExcelUtil.getCellData(5, 2));
		Reporter.log("Open Delete Form");
		ExcelUtil.setCellData(5, 6, objCommon.getToastResult());
		objCommon.checkTestResult(5, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_06() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.addCustomer(ExcelUtil.getCellData(6, 2), ExcelUtil.getCellData(6, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.clickTrashIcon(ExcelUtil.getCellData(6, 2));
		Reporter.log("Open Delete Form");
		objCustomer.clickCancelBtn();
		Reporter.log("Cancel Delete");
		ExcelUtil.setCellData(6, 6, objCustomer.checkExistCustomerName(ExcelUtil.getCellData(6, 2)));
		objCommon.checkTestResult(6, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "delete-customer" })
	public void TC_OHRM_DC_07() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "DeleteCustomer");
		Reporter.log("Open File");
		objCustomer.addCustomer(ExcelUtil.getCellData(7, 2), ExcelUtil.getCellData(7, 4));
		Reporter.log("Add Sample Customer To Test");
		objCustomer.clickTrashIcon(ExcelUtil.getCellData(7, 2));
		Reporter.log("Open Delete Form");
		objCustomer.clickXBtn();
		Reporter.log("Cancel Delete");
		ExcelUtil.setCellData(7, 6, objCustomer.checkExistCustomerName(ExcelUtil.getCellData(7, 2)));
		objCommon.checkTestResult(7, 5, 6, 7);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@AfterTest(groups = { "edit-customer" })
	public void afterTestEditCustomer() throws Exception {
		objCommon.writeResult(".\\src\\data\\TestData.xlsx", "EditCustomer", 12, 7);
		driver.close();
		Reporter.log("Browser Close");
	}

	@AfterTest(groups = { "delete-customer" })
	public void afterTestDeleteCustomer() throws Exception {
		objCommon.writeResult(".\\src\\data\\TestData.xlsx", "DeleteCustomer", 8, 7);
		Reporter.log("Count Test Cases Passed");
		driver.close();
		Reporter.log("Browser Close");
	}
}