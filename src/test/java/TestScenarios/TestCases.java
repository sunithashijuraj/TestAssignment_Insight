package TestScenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Methods.CommonMethods;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {

	WebDriver driver;
	HomePage homepageObj;

	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 0)
	public void URLLaunch() {
		homepageObj = new HomePage(driver);
		homepageObj.LaunchURL();
	}

	@Test(priority = 1)
	public void LogoValidation() {
		homepageObj.ValidateLogo();
	}

	@Test(priority = 2)
	public void Navigation() {
		homepageObj.NavigateIntegrations();
	}

	@Test(priority = 3)
	public void ClickInforTab() throws IOException {
		homepageObj.ClickInfortab();
	}
	
	@Test(priority = 4)
	public void VerifyInfortab() {
		homepageObj.VerifyInfortab();
	}
	
	@Test(priority = 5)
	public void ClickInforLawsonLink() {
		homepageObj.ClickInforLawsonLink();
	}

	@Test(priority = 6)
	public void VerifyOracleTab() {
		homepageObj.VerifyOracleTab();
	}

	@Test(priority = 7)
	public void VerifyMicrosoftTab() {
		homepageObj.VerifyMicrosoftTab();
	}

	@Test(priority = 8)
	public void VerifySAPTab() {
		homepageObj.VerifySAPTab();
	}

	@Test(priority = 9)
	public void VerifyDeltekTab() {
		homepageObj.VerifyDeltekTab();
	}

	@AfterTest
	public void afterTest() {
		homepageObj.quitDriver();
	}
}
