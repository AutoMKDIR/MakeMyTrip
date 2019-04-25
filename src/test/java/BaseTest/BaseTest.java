package BaseTest;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {

	
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
    
	
	@BeforeTest
	public void Setup(){
		
		
		//System.getProperty("user.dir")+"\\src\\resources\\Properties\\OR.properties");
	
	//	System.out.println("stp1-->"+repPath);
		htmlReporter=new ExtentHtmlReporter("D:\\JAVA_WORKSPACE\\MakemyTripApp\\target\\Report\\myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localHost");
	//	System.out.println("stp1-->"+repPath);
		

	}
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
	
	    if(result.getStatus() == ITestResult.SUCCESS)
	    {
	    	System.out.println("passed");

	      test.log(Status.PASS, result.getName()+":is PASSED");
	      test.debug("PASSED");
	      String path="C:/Users/1256525/Downloads/5acadc92f3c7d.image.JPG";
/*	      
	      String ScreenShot=takeScreenshot(result.getName());
	      System.out.println(ScreenShot);
	      test.addScreenCaptureFromPath(ScreenShot);
	      */
	      
	
	  	test.debug("<a href=\"C:\\Users\\1256525\\"+result.getName()+".png\"; target='blank'> PASS--SCREENSHOT </a>");
	  	test.debug("<a href="+path+"` target='blank'> PASS--SCREENSHOT </a>");
	  	test.info("Screenshot attached!!!");
/*	      
	      test.debug("<a href='+ScreenShot+' target='parent'>click here to view the defect </a>");   
	       test.debug("<a href="+ScreenShot+" target='blank'>click here to view the defect </a>");   
	       
	    		  
	      test.debug("<a href='C:/Users/1256525/"+filename+".png' target='blank'> Pass Screenshot</a>");
	      
	      test.debug("<a href='C:\\Users\\1256525\\nopCommerceRegistration.png'>PASS-SCREENSHOT</a>");
	   */
	    
	    }

	    else if(result.getStatus() == ITestResult.FAILURE)
	    {
	    	
	    	
	    	System.out.println("failed");
	    	test.log(Status.FAIL, result.getName()+":is FAILED");
	    	test.debug("FAILED");
	    	
/*	   
	    			      String ScreenShot=takeScreenshot(result.getName());
		      System.out.println(ScreenShot);
		      test.debug("<a href="+ScreenShot+" target='blank'>click here to view the defect </a>");  
	    	
	    	*/
	    	
	    		
	    	//	test.debug("<a href='C:\\Users\\1256525\\Downloads\\5acadc92f3c7d.image.JPG' target='blank'> Error Screenshot</a>");
	    	//file:///C:/Users/1256525/workspace/ExtentReport/test-output/Report1/path
//	    /	file:///C:/Users/1256525/workspace/ExtentReport/test-output/Report1/path
	    		String path="C:/Users/1256525/Downloads/5acadc92f3c7d.image.JPG";
				test.debug("<a href="+path+" target='blank'> Error Screenshot</a>");
				test.debug("<a href="+path+" target='blank'> Error Screenshot1</a>");
			
				
				test.info("Screenshot attached!!!");
			
	    	
	    }
	 
	     else if(result.getStatus() == ITestResult.SKIP ){

	    	 System.err.println("skipped");
	    	 
	    	 test.log(Status.SKIP, result.getName()+":is SKIPPED");
	    	 test.debug("SKIPPED");

	    }
	    
	
 }
	
	
	
		@AfterTest
	public void TearDown(){
		
		
	
		     extent.flush();
		     
		    // BasePage.driver.get("C:\\Users\\1256525\\workspace\\POM2\\test-output\\Report1\\Report2.html");
		
		//BasePage.driver.quit();
		System.out.println("AfterTest");

		
	}
		
		
		
		
		
		
	
	
	
	
	
}

	

