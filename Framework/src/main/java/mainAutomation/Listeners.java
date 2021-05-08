package mainAutomation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends FrameworkBase implements ITestListener {

	ExtentReports extent = ExtentReportsNG.generateExtentReport();
	ExtentTest test;

	ThreadLocal<ExtentTest> sync = new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		// fetching the driver object from failed test case class
		WebDriver driver = null;
		sync.get().fail(result.getThrowable());
		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println(driver);
			e.printStackTrace();
		}

		String testMethodName = result.getMethod().getMethodName();

		try {
			sync.get().addScreenCaptureFromPath(getScreenShot(testMethodName, driver), testMethodName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// add the error log in the extended report

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		sync.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		sync.get().pass("Test Passed");

	}

}
