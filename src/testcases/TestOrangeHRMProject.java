package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMProject;
import util.ExcelUtil;
import util.OrangeHRMCommon;

public class TestOrangeHRMProject {
	WebDriver driver;
	OrangeHRMCommon objCommon;
	OrangeHRMProject objProject;

	@BeforeTest(groups = { "add-project" })
	public void beforeTest() {
		driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Brower Maximized");
		driver.get("https://opensource-demo.orangehrmlive.com");
		Reporter.log("Application Started");
		objCommon = new OrangeHRMCommon(driver);
		objCommon.loginToOrangeHRM("Admin", "admin123");
		objProject = new OrangeHRMProject(driver);
		Reporter.log("Signing In");
	}

	@BeforeMethod(groups = { "add-project" })
	public void beforeMethod() {
		objCommon.selectModule("Time");
		objCommon.selectSection("Project Info");
		objCommon.selectChildSection("Projects");
		Reporter.log("Selecting Section");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_01() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(1, 2), ExcelUtil.getCellData(1, 3), ExcelUtil.getCellData(1, 4),
				ExcelUtil.getCellData(1, 5));
		Reporter.log("Enter Information With All Valid Required Fields");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(1, 7, objCommon.getToastResult());
		objCommon.checkTestResult(1, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_02() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(2, 2), ExcelUtil.getCellData(2, 3), ExcelUtil.getCellData(2, 4),
				ExcelUtil.getCellData(2, 5));
		Reporter.log("Enter Information With Name Has 1 Character And Description Has 10 characters In Length");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(2, 7, objCommon.getToastResult());
		objCommon.checkTestResult(2, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_03() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(3, 2), ExcelUtil.getCellData(3, 3), ExcelUtil.getCellData(3, 4),
				ExcelUtil.getCellData(3, 5));
		Reporter.log("Enter Information With Name Has 50 Characters And Description Has 10 Characters In Length");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(3, 7, objCommon.getToastResult());
		objCommon.checkTestResult(3, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_04() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(4, 2), ExcelUtil.getCellData(4, 3), ExcelUtil.getCellData(4, 4),
				ExcelUtil.getCellData(4, 5));
		Reporter.log("Enter Information With Name Has 5 Characters And Description Has 0 Character In Length");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(4, 7, objCommon.getToastResult());
		objCommon.checkTestResult(4, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_05() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(5, 2), ExcelUtil.getCellData(5, 3), ExcelUtil.getCellData(5, 4),
				ExcelUtil.getCellData(5, 5));
		Reporter.log("Enter Information With Name Has 5 Characters And Description Has 255 Characters In Length");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(5, 7, objCommon.getToastResult());
		objCommon.checkTestResult(5, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_06() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(6, 2), ExcelUtil.getCellData(6, 3), ExcelUtil.getCellData(6, 4),
				ExcelUtil.getCellData(6, 5));
		Reporter.log("Enter Information With Name Has 5 Characters And Description Has 10 Characters In Length");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(6, 7, objCommon.getToastResult());
		objCommon.checkTestResult(6, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_07() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProjectExceptAdmin(ExcelUtil.getCellData(7, 2), ExcelUtil.getCellData(7, 3),
				ExcelUtil.getCellData(7, 4));
		Reporter.log(
				"Enter Information With Name Has 5 Character, Description Has 10 Characters In Length And Project Admin Is Blank");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(7, 7, objCommon.getToastResult());
		objCommon.checkTestResult(7, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_08() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.setCustomerNameExceptChoose(ExcelUtil.getCellData(8, 4));
		Reporter.log("Set Customer Name");
		String resultMessage = objProject.checkChooseCustomerNameInSuggestedList(ExcelUtil.getCellData(8, 4));
		Reporter.log("Choose Customer Name And Check It In Suggested List");
		ExcelUtil.setCellData(8, 7, resultMessage);
		objCommon.checkTestResult(8, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_09() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.setProjectAdminExceptChoose(ExcelUtil.getCellData(9, 5));
		Reporter.log("Set Project Admin");
		String resultMessage = objProject.checkChooseProjectAdminInSuggestedList(ExcelUtil.getCellData(9, 5));
		Reporter.log("Choose Project Admin And Check It In Suggested List");
		ExcelUtil.setCellData(9, 7, resultMessage);
		objCommon.checkTestResult(9, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_10() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(10, 2), ExcelUtil.getCellData(10, 3), ExcelUtil.getCellData(10, 4),
				ExcelUtil.getCellData(10, 5));
		Reporter.log("Enter Information With Blank Input To 'Name' Textbox");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(10, 7, objProject.getErrorMessage());
		objCommon.checkTestResult(10, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_11() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProjectExceptCustomer(ExcelUtil.getCellData(11, 2), ExcelUtil.getCellData(11, 3),
				ExcelUtil.getCellData(11, 5));
		Reporter.log("Enter Information With Blank Input To 'Customer Name' Dropbox");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(11, 7, objProject.getErrorMessage());
		objCommon.checkTestResult(11, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_12() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProject(ExcelUtil.getCellData(12, 2), ExcelUtil.getCellData(12, 3), ExcelUtil.getCellData(12, 4),
				ExcelUtil.getCellData(12, 5));
		Reporter.log("Enter Information With Spaces Only To 'Name' Textbox");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(12, 7, objProject.getErrorMessage());
		objCommon.checkTestResult(12, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@Test(groups = { "add-project" })
	public void TC_OHRM_AP_13() throws Exception {
		ExcelUtil.openFile(".\\src\\data\\TestData.xlsx", "AddProject");
		Reporter.log("Open File");
		objProject.clickAddBtn();
		Reporter.log("Open Add Project Form");
		objProject.addProjectExceptChooseCustomer(ExcelUtil.getCellData(13, 2), ExcelUtil.getCellData(13, 3),
				ExcelUtil.getCellData(13, 4), ExcelUtil.getCellData(13, 5));
		Reporter.log("Enter Information With Spaces Only To 'Customer Name' Dropbox");
		objProject.clickSaveBtn();
		Reporter.log("Save Form");
		ExcelUtil.setCellData(13, 7, objProject.getErrorMessage());
		objCommon.checkTestResult(13, 6, 7, 8);
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".\\src\\data\\TestData.xlsx");
		Reporter.log("Save And Close File");
	}

	@AfterTest(groups = { "add-project" })
	public void afterTest() throws Exception {
		objCommon.writeResult(".\\src\\data\\TestData.xlsx", "AddProject", 14, 8);
		Reporter.log("Count Test Cases Passed");
		driver.close();
		Reporter.log("Closed Browser");
	}
}
