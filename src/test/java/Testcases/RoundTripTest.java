package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePage.BasePage;
import BaseTest.BaseTest;
import Pages.HomePage;

public class RoundTripTest extends BaseTest  {

	@Test
	public void serachRoundTrip(){
		
	
	test=extent.createTest("Testcase1 Initiated");
	HomePage hp=new HomePage();
	
	hp.roundTrip();
	hp.selectStations();
	hp.selectDates();
	hp.selectSearch();
	
	String actualPageTitle=BasePage.getPageTitle();
	String expectedPageTitle="MakeMyTrip";
	
	//Assert.assertEquals(actualPageTitle, expectedPageTitle);
	test.debug("Testcase Done");

	
	}
	
	
	
	
	
}
