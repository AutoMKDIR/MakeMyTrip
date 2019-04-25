package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;

public class HomePage extends BasePage {

	public void roundTrip(){
		
		
	//This method will be select RoundTrip radio button 
	
		driver.findElement(By.xpath("//div[@class='makeFlex']//ul//li[2]//span")).click();
		//div[@class="makeFlex"]//ul//li[2]//span[@class="tabsCircle appendRight5"]
		
	}
	
	public void selectStations(){
		
	
		//This method will be select Departure station and Return station 
		driver.findElement(By.id("fromCity")).click();
		List<WebElement> fromCity = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//following::li[starts-with(@id,'react-auto')]"));
		System.out.println(fromCity.size());
		for (int i = 0; i < fromCity.size(); i++) {
			if (fromCity.get(i).getText().contains("Delhi")) {
				fromCity.get(i).click();
				break;
			}
			
		}
		System.out.println("depart is done");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("toCity"));
		js.executeScript("arguments[0].click();", element);
		System.out.println("done sure");
		List<WebElement> toCity = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//following::li[starts-with(@id,'react-auto')]"));
		System.out.println(toCity.size());
		for (int i = 0; i < toCity.size(); i++) {
			System.out.println(toCity.get(i).getText());
			if (toCity.get(i).getText().contains("Bengaluru")) {
				System.out.println("okk");
				toCity.get(i).click();
				break;
			}
		}
		
		System.out.println("depart is done");
		
	}
	
	public void selectDates(){
		
		//This method will be select Departure date and Return date 
		
		String departureDate=getDepartureDate();
		String returnDate=getReturnDate();
		//System.out.print("departureDate"+"\n"+"returnDate");
		//Wed May 15 2019
		//WebElement departDate = driver.findElement(By.id("departure"));
		//System.out.println(departDate.getAttribute("value"));
		//departDate.click();
		List<WebElement> calList = driver.findElements(By.xpath("//div[starts-with(@class,'DayPicker-Day')]"));
		System.out.println(calList.size());
		for (int i = 1; i < calList.size(); i++) {
			//	System.out.println(calList.get(i).getAttribute("aria-label"));
			if (calList.get(i).getAttribute("aria-label") != null && calList.get(i).getAttribute("aria-label").equals(departureDate)){
					calList.get(i).click();
			}
			if (calList.get(i).getAttribute("aria-label") != null && calList.get(i).getAttribute("aria-label").equals(returnDate)) {
				calList.get(i).click();
				break;
			}
	
		}
	}
	
	
	public void selectSearch(){
		
		
		//This method will be enter serach button 
		WebElement searchButton=driver.findElement(By.xpath("//a[text()='Search']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", searchButton);
		System.out.println("done sure");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
