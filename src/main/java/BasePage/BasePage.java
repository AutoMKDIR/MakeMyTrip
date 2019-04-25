package BasePage;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BasePage {
		
	public static WebDriver driver;
	public static FileInputStream fp;
	public static Properties prop;
	public static String repPath;

	
	public BasePage() {

		
		//System.out.println(System.getProperty("user.dir"));

		  try {
					fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
					
					prop=new Properties();
					prop.load(fp);
					
					
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
		
		 	String Browser=prop.getProperty("Browser");
		 	System.out.println(Browser);
		  	if(Browser.equals("firefox")){
		  		
		  		//C:\Users\1256525\workspace\POM2\\src\\resources\\Browserexes\\geckodriver (2).exe
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Browserexes\\geckodriver (2).exe");
				driver=new FirefoxDriver();
		  		
		  	}
		  
		  	
		  	else if(Browser.equals("chrome")){
		  		
		  		//C:\Users\1256525\workspace\POM2\\src\\resources\\Browserexes\\chromedriver.exe
		  		
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Browserexes\\chromedriver.exe");
				driver=new ChromeDriver();
		  		
		  	}
		  	
		  	
			
		
		
			System.out.println(prop.getProperty("URL"));
			driver.get(prop.getProperty("URL"));//Getting URL from properties file
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



			
			
			}
		
		
			public String getDepartureDate(){
		
				
				
				
				Date d=new Date();
			//	System.out.println(d);
				String[] s=d.toString().split(" ");
			/*	System.out.println("\n");
				System.out.println(s[0]);
				System.out.println(s[1]);
				System.out.println(s[2]);
				System.out.println(s[3]);
				System.out.println(s[4]);
				System.out.println(s[5]);*/
				
				String departureDate=s[0]+" "+s[1]+" "+s[2]+" "+s[5];
				System.out.println(departureDate);
				return departureDate;
			
			}
		
		
			
			public String getReturnDate(){
		
				
				
				Date dt=(DateUtils.addDays(new Date(), 7));
				//System.out.println(DateUtils.addDays(d, 1));
				//dt=(DateUtils.addDays(new Date(), 7));
				//System.out.println(dt);
				
				String[] s1=dt.toString().split(" ");
				
				/*System.out.println("\n");
				System.out.println(s1[0]);
				System.out.println(s1[1]);
				System.out.println(s1[2]);
				System.out.println(s1[3]);
				System.out.println(s1[4]);
				System.out.println(s1[5]);
				*/
				
				String returnDate=s1[0]+" "+s1[1]+" "+s1[2]+" "+s1[5];
				System.out.println(returnDate);
				return returnDate;

			
			}
		
			public static String getPageTitle(){
				
				String pageTitle=driver.getTitle();
				return pageTitle;
			}
		
			
			public Boolean isElementPresent(By by){
				
				
				try {
					
					driver.findElement(by);
					return true;
					
					
					
				} catch (NoSuchElementException e) {
					
					return false;
					
				}
				
			}
		
		
	
			
		
}