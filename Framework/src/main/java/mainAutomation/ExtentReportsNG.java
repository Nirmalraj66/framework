package mainAutomation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportsNG {
	public static ExtentReports extent;
	public static ExtentReports generateExtentReport()
	{
		
		
		String reportPath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Test Results of XXXX");
		reporter.config().setReportName("Test Results of XXXX" );
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nirmal");
		return extent;

	}
	

}
