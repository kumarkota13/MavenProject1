package res;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.pack.test.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Listener extends BaseTest implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//IT/estListener.super.onTestStart(result);
		test=reports.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		System.out.println("Testcase Passed");
		
		
		 TakesScreenshot scrShot =((TakesScreenshot) driver);
				 //Call getScreenshotAs method to create image file
	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	            //Move image file to new destination
	                Random r=new Random();
	        		int val=r.nextInt(1000);
	                
	                String dest="/Users/Naresh/Desktop/Automation/workspace/test1/Screenshot/"+result.getName()+val+"Pass.png";
	              File DestFile=new File(dest);
	                
	                String imgpath=dest;
	                
	                //Copy file at destination
	                try {
						FileUtils.copyFile(SrcFile, DestFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	               String img=test.addScreenCapture(imgpath);
			
			test.log(LogStatus.PASS, img);
		

		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		System.out.println("Testcase Failed");
		
		 TakesScreenshot scrShot =((TakesScreenshot) driver);
				 //Call getScreenshotAs method to create image file
	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	            //Move image file to new destination
	                Random r=new Random();
	        		int val=r.nextInt(1000);
	                
	                String dest="/Users/Naresh/Desktop/Automation/workspace/test1/Screenshot/"+result.getName()+val+"error.png";
	              File DestFile=new File(dest);
	                
	                String imgpath=dest;
	                
	                //Copy file at destination
	                try {
						FileUtils.copyFile(SrcFile, DestFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	                String img=test.addScreenCapture(imgpath);
			
			test.log(LogStatus.FAIL, img);
		
		
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	reports=new ExtentReports(System.getProperty("user.dir")+"/Reports/myreport.html");
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		reports.endTest(test);
		reports.flush();
		//reports.close();
	}

	
}
