package test;

import java.io.IOException;
import java.util.logging.Logger;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.TestBase;
//import Base.loggerTest;
import Page.HomePage;
import Page.addToCartPage;
import Page.productPage;


public class priceTest extends TestBase{
	HomePage hp;
	productPage pp;
	addToCartPage acp;

    public WebDriver driver; 
   
	public priceTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException {
		
		initialization();
		
		hp = new HomePage();
		pp=new productPage();
		acp=new addToCartPage();
		
		
	}



@Test(priority=2)
public void verifyTotalPriceInSummary() throws InterruptedException
{   
	hp.searchProduct();
	pp.enterZipcode();
	pp.selectColour();
	pp.enterQtyAddSettocart();
	double tpiw=acp.calculateTotalPriceItemWise();
	double tsiw=acp.calculateTotalSaveItemWise();
	double sp=acp.calculateTotalPriceSummaryLevel();
	double ss=acp.calculateTotalSaveSummaryLevel();

	Assert.assertEquals(tpiw, sp);
	Assert.assertEquals(tsiw, ss);
	
	
}
@Test(priority=1)
public void verifySubscription() throws InterruptedException
{   
	
	
	
   String msgDisplay=hp.EnterinvalidMailAndClickSubscribe("nhguy878");
   Assert.assertEquals(msgDisplay,"Invalid Email Address");
   
   String msgDisplay1=hp.EntervalidMailAndClickSubscribe("nhguy878@gmail.com");
   Assert.assertEquals(msgDisplay1,"Thanks for subscribing!");
   


}
}
