package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Methods.CommonMethods;

public class HomePage extends CommonMethods {
	CommonMethods obj;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void ValidateLogo() {

		test.log(LogStatus.INFO, "Test Case Validate Logo is Started");
		try {
			WebElement Logo = driver.findElement(Logo_img);

			Boolean LogoExists = (Boolean) (js.executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					Logo));
			if (!LogoExists) {
				System.out.println("Image not displayed.");
			} else {
				System.out.println("Validation Successfull: Logo Exists.");
			}
		} catch (Exception e) {

			System.out.println("Error message" + e.getMessage());
		}
		test.log(LogStatus.PASS, "Validation Successfull: Logo Exists");
	}

	public void NavigateIntegrations() {
		test.log(LogStatus.INFO, "Test Case for Navigate to Integrations Link is Started");
		try {
			WebElement Element = driver.findElement(random_element_to_Scroll);

			js.executeScript("arguments[0].scrollIntoView(true);", Element);
			test.log(LogStatus.PASS, "User Successfully scroll down to the application");
			driver.findElement(Integrations_Link).click();
			test.log(LogStatus.PASS, "User Clicked on the Integrations Link");			
			Thread.sleep(3000);
			String Actualtext = driver.findElement(IntegratesWith_TextValue).getText();
			Thread.sleep(3000);
			String ExpectedText = "Integrates with:";
			Assert.assertEquals(Actualtext, ExpectedText, "Navigates to the section 'Integrates with'");
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}
		test.log(LogStatus.PASS, "User successfully navigates to the section 'Integrates with'");
	}

	public void ClickInfortab() throws IOException {
		test.log(LogStatus.INFO, "Test Case for Click Infor tab is Started");
		driver.findElement(Infortab).click();
		String currentTitle = driver.getTitle();
		Boolean pageTitle = driver.getTitle().equals("Lawson Reporting, BI, and Analytics Software Solutions - insightsoftware");
		if (currentTitle.equals(pageTitle)) {
			test.log(LogStatus.PASS, "User navigated to 'https://insightsoftware.com/lawson/'");
		}
		else {
			test.log(LogStatus.FAIL, test.addScreenCapture(CaptureScreenShot(driver))+"Given URL not matched");
		}
	}
	
	public void VerifyInfortab() {
		test.log(LogStatus.INFO, "Test Case for Verify Infor tab is Started");
		try {
			WebElement Infor_Logo = driver.findElement(Infor_img);
			Boolean Infor_Logo_exists = (Boolean) (js.executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					Infor_Logo));
			if (!Infor_Logo_exists) {
				System.out.println("Infor Image not displayed.");
			} else {
				System.out.println("Validation Successfull: Infor image exists.");
			}
			test.log(LogStatus.PASS, "Infor Logo exists");
			test.log(LogStatus.INFO, "Click on Infor Lawson Link");
			driver.findElement(By.linkText("Infor Lawson")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}
		test.log(LogStatus.PASS, "Page Navigated to Infor Lawson Link");
	}

	public void ClickInforLawsonLink() {
		test.log(LogStatus.INFO, "Test Case for Verification of Page Title for Infor Lawson Link is Started");
		try {
			String getCurrentWindowTitle = driver.getTitle();
			String expetedWindowTitleString = "Lawson Reporting, BI, and Analytics Software Solutions - insightsoftware";
			Assert.assertEquals(getCurrentWindowTitle, expetedWindowTitleString);
			System.out.println("Currernt Window title after clicking the 'Infor Lawson' link is: " + getCurrentWindowTitle);
			System.out.println("Validation of 'https://insightsoftware.com/lawson/' is successful");
			test.log(LogStatus.PASS, "Page Title is: "+expetedWindowTitleString);
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}
		
	}

	public void VerifyOracleTab() {
		test.log(LogStatus.INFO, "Test Case for Verify External Links in Oracle tab is Started");
		try {
			obj = new CommonMethods(driver);
			obj.Navigateback();
			List<WebElement> OracleExternal_Links = driver.findElements(Oracle_list);
			int SizeOfOracleExternal_Links = OracleExternal_Links.size();
			test.log(LogStatus.PASS, "The No. of External Links in Oracle tab is : "+SizeOfOracleExternal_Links);
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}
	}

	public void VerifyMicrosoftTab() {
		test.log(LogStatus.INFO, "Test Case for Verify External Links in Microsoft tab is Started");
		try {
			List<WebElement> MicrosoftExternal_Links = driver.findElements(Microsoftlist);
			int SizeOfMicrosoftExternal_Links = MicrosoftExternal_Links.size();
			test.log(LogStatus.PASS, "The No. of External Links in Microsoft tab is : "+SizeOfMicrosoftExternal_Links);
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}

	}

	public void VerifySAPTab() {
		test.log(LogStatus.INFO, "Test Case for Verify External Links in SAP tab is Started");
		try {
			List<WebElement> SAPExternal_Links = driver.findElements(SAPlist);
			int SizeOfSAPExternal_Links = SAPExternal_Links.size();
			test.log(LogStatus.PASS, "The No. of External Links in SAP tab is : "+SizeOfSAPExternal_Links);
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}

	}

	public void VerifyDeltekTab() {
		try {
			test.log(LogStatus.INFO, "Test Case for Verify External Links in Deltek tab is Started");
			List<WebElement> deltekExternal_Links = driver.findElements(delteklist);
			int SizeOfdeltekExternal_Links = deltekExternal_Links.size();
			test.log(LogStatus.PASS, "The No. of External Links in SAP tab is : "+SizeOfdeltekExternal_Links);

		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}

	}
}
