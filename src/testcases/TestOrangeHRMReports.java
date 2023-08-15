package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMReports;
import util.ExcelUtil;
import util.OrangeHRMCommon;

public class TestOrangeHRMReports {
	WebDriver driver;
	OrangeHRMCommon objCommon;
	OrangeHRMReports objReports;

	@BeforeTest(groups = { "employee-reports" })
	public void beforeTest() throws Exception {
		driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Brower Maximized");
		driver.get("https://opensource-demo.orangehrmlive.com");
		Reporter.log("Application Started");
		objCommon = new OrangeHRMCommon(driver);
		objCommon.loginToOrangeHRM("Admin", "admin123");
		objReports = new OrangeHRMReports(driver);
		Reporter.log("Signing In");
	}

	@BeforeMethod(groups = { "employee-reports" })
	public void beforeMethod() throws Exception {
		objCommon.selectModule("Time");
		objCommon.selectSection("Reports");
		objCommon.selectChildSection("Employee Reports");
		Reporter.log("Selecting Section");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_01() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(1, 2));
		Reporter.log("Selecting Employee");
		objReports.onlyApprovedTimesheets(false);
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(1, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(1, 9))) {
			objCommon.testCompleted(1, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(1, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_02() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(2, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(2, 3));
		Reporter.log("Selecting Project");
		objReports.onlyApprovedTimesheets(false);
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(2, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(2, 9))) {
			objCommon.testCompleted(2, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(2, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_03() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(3, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(3, 3));
		Reporter.log("Selecting Project");
		objReports.selectActivity(ExcelUtil.getCellData(3, 4));
		Reporter.log("Selecting Activity");
		objReports.onlyApprovedTimesheets(false);
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(3, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(3, 9))) {
			objCommon.testCompleted(3, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(3, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");

		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_04() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(4, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(4, 3));
		Reporter.log("Selecting Project");
		objReports.selectDateRange(ExcelUtil.getCellData(4, 5), ExcelUtil.getCellData(4, 6));
		Reporter.log("Selecting Date Range");
		objReports.onlyApprovedTimesheets(false);
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(4, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(4, 9))) {
			objCommon.testCompleted(4, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(4, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_05() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(5, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(5, 3));
		Reporter.log("Selecting Project");
		objReports.selectActivity(ExcelUtil.getCellData(5, 4));
		Reporter.log("Selecting Activity");
		objReports.selectDateRange(ExcelUtil.getCellData(5, 5), ExcelUtil.getCellData(5, 6));
		Reporter.log("Selecting Date Range");
		objReports.onlyApprovedTimesheets(false);
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(5, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(5, 9))) {
			objCommon.testCompleted(5, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(5, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_06() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(6, 2));
		Reporter.log("Selecting Employee");
		objReports.onlyApprovedTimesheets(true);
		Reporter.log("Selecting Only Included Approved Timesheets");
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(6, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(6, 9))) {
			objCommon.testCompleted(6, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(6, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_07() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(7, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(7, 3));
		Reporter.log("Selecting Project");
		objReports.onlyApprovedTimesheets(true);
		Reporter.log("Selecting Only Included Approved Timesheets");
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(7, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(7, 9))) {
			objCommon.testCompleted(7, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(7, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_08() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(8, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(8, 3));
		Reporter.log("Selecting Project");
		objReports.selectActivity(ExcelUtil.getCellData(8, 4));
		Reporter.log("Selecting Activity");
		objReports.onlyApprovedTimesheets(true);
		Reporter.log("Selecting Only Included Approved Timesheets");
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(8, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(8, 9))) {
			objCommon.testCompleted(8, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(8, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "employee-reports" })
	public void TC_OHRM_EP_09() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		Reporter.log("Open File");
		objReports.selectEmployee(ExcelUtil.getCellData(9, 2));
		Reporter.log("Selecting Employee");
		objReports.selectProject(ExcelUtil.getCellData(9, 3));
		Reporter.log("Selecting Project");
		objReports.selectActivity(ExcelUtil.getCellData(9, 4));
		Reporter.log("Selecting Activity");
		objReports.selectDateRange(ExcelUtil.getCellData(9, 5), ExcelUtil.getCellData(9, 6));
		Reporter.log("Selecting Date Range");
		objReports.onlyApprovedTimesheets(true);
		Reporter.log("Selecting Only Included Approved Timesheets");
		Reporter.log("View");
		objCommon.getTableResult();
		ExcelUtil.setCellData(9, 9, objCommon.getTableResult());
		if (objCommon.getTableResult().equals(ExcelUtil.getCellData(9, 9))) {
			objCommon.testCompleted(9, 10, true, "PASSED");
		} else {
			objCommon.testCompleted(9, 10, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@AfterTest(groups = { "employee-reports" })
	public void afterTestEmployeeReports() throws Exception {
		objCommon.writeResult(".\\src\\data\\TestData.xlsx", "EmployeeReports", 10, 10);
		driver.close();
		Reporter.log("Closed Browser");
	}
}
