package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ----Started");
		 test = reports.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ----Success");
		test.log(Status.PASS,methodName+"---------passed");
		test.log(Status.INFO, result.getThrowable());
		

	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ----Failure");
		test.log(Status.FAIL,methodName+"---------failed");
		test.log(Status.INFO, result.getThrowable());

		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		String screenshotname = methodName + "-" + jutil.toGetSystemDateAndTime();
		try {
			String path = wutil.toTakeScreenShot(BaseClass.sDriver, screenshotname);
		   test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ----Skipped");
		test.log(Status.SKIP,methodName+"---------skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		System.out.println("--------Suite excecution stated");

		ExtentSparkReporter htmlReports = new ExtentSparkReporter(
				"./extentReports/Report-" + new JavaUtility().toGetSystemDateAndTime() + ".html");
		htmlReports.config().setDocumentTitle("Vtiger excuation Report");
		htmlReports.config().setTheme(Theme.DARK);
		htmlReports.config().setReportName("VTIGER EXCUATION REPORT");

		reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("BaseUrl1", "http://localhost:8888/");
		reports.setSystemInfo("Base browser", "chrome");
		reports.setSystemInfo("username", "admin");
		reports.setSystemInfo("password", "password");
	}

	public void onFinish(ITestContext context) {
		System.out.println("--------Suite execution finished");
		reports.flush();

	}

}
