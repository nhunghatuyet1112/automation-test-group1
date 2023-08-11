package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		objCommon = new OrangeHRMCommon(driver);
		objCommon.loginToOrangeHRM("Admin", "admin123");
		objReports = new OrangeHRMReports(driver);
	}
	
	@BeforeMethod(groups = { "employee-reports" })
	public void beforeMethod() throws Exception {
		objCommon.selectModule("Time");
		objCommon.selectSection("Reports");
		objCommon.selectChildSection("Employee Reports");
	}
	
	@Test(groups = { "employee-reports" })
	public void TC_OHRM_ER_01() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "EmployeeReports");
		objReports.selectEmployee(ExcelUtil.getCellData(0, 0));
		objReports.onlyApprovedTimesheets(false);
		ExcelUtil.setCellData(0, 0, objCommon.getTableResult());
		if(objCommon.getTableResult().equals(ExcelUtil.getCellData(0, 0))) {
			objCommon.testCompleted(0, 0, true, "PASSED");
		} else {
			objCommon.testCompleted(0, 0, false, "FAILED");
		}
	}
	
	@AfterTest(groups = { "employee-reports" })
	public void afterTestEmployeeReports() throws Exception {
		objCommon.writeResult(".\\src\\data\\TestData.xlsx", "EmployeeReports" , 10, 7);
		driver.close();
	}
}
