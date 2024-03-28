package genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * This class provides Implementation for ItestListener Interface pf TestNG
 * 
 */

public class ListenersImplementation implements ITestListener {

	//ExtentReports report;
	//ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//start of @Test -> Test Method  -> Method Name 
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Test Execution Started---");
	
		//For Extent Reports to recognize the @Test
		//test = report.createTest(methodname);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Test Pass---");
		
		//For login the stetus of the Test in Extent Report

	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Test Fail---");
	
		System.out.println(result.getThrowable());// print the exception
		
		//capture The ScreenShot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodname +"-"+j.Systemdate();
		
		try {
			s.capture_ScreenShot(BaseClass.sdriver , screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	}
 
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Test Skip---");
		
		System.out.println(result.getThrowable());// print the exception
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---Suite Execution Started---");
	
		//Extent Report Configuration
	/*	ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().Systemdate()+".html");
		esr.config().setDocumentTitle("Execution Report");
		esr.config().setReportName("Vtiger Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Reporter", "AMAN");
		
	*/
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("---Suite Execution Finished---");

		//Extent Report Generation
		//report.flush();
	
	}
	
	
	
	

}
