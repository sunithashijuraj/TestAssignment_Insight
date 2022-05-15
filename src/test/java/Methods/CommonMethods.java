package Methods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;

	public By Logo_img = By.xpath("//img[@alt='insightsoftware logo']");
	public By random_element_to_Scroll = By.xpath("//input[@type='email']");
	public By Integrations_Link = By.xpath("//ul[@id='menu-product-sub-navigation']//child::li[3]");
	public By IntegratesWith_TextValue = By.xpath("//div[@class='container']/h2");
	public By Infortab = By.xpath("//ul[@class='nav nav-tabs nav-justified']/li[9]");
	public By Infor_img = By.xpath("//img[@alt=\"Infor\"]");
	public By Oracle_img = By.xpath("//img[@alt=\"Oracle\"]");
	public By Oracle_list = By.cssSelector("div#oracle>div:nth-of-type(2)>div a");
	public By Microsoftlist = By.cssSelector("div#microsoft>div:nth-of-type(2)>div a");
	public By SAPlist = By.cssSelector("div#sap>div:nth-of-type(2)>div a");
	public By delteklist = By.cssSelector("div#deltek>div:nth-of-type(2)>div a");

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void LaunchURL() {
		report = new ExtentReports("C:\\WorkSpace\\TestAssignment\\Reports\\report.html", true);
		test = report.startTest("Report of TestNG Execution");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Test Case Launch URL is Started");
		driver.get("https://insightsoftware.com/bizview/");
		String title = driver.getTitle();
		System.err.println(title);
		test.log(LogStatus.PASS, title);

	}

	public void Navigateback() {
		driver.navigate().back();
		System.out.println("Navigation Successfull");
	}

	public static String CaptureScreenShot(WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("src/../Screenshots/" +System.currentTimeMillis()+".png");
		String absolutepath_screen = destinationFile.getAbsolutePath();
		FileUtils.copyFile(srcFile, destinationFile);
		return absolutepath_screen;
		
	}
	
	public void quitDriver() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
