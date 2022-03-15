
package Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Base.TestBase;
//import Base.loggerTest;

public class HomePage extends TestBase{

	//private final org.apache.log4j.Logger log = loggerTest.getLogger(HomePage.class);
	
	//public static final Logger logger = Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath = "//*[@class='img-search-icon']")
	WebElement searchBoxLink;
	@FindBy(xpath="(//*[@name='q'])[3]")
	WebElement SearchBoxField;
	@FindBy(xpath="(//*[text()='Bold Series 10 Piece '])[1]")
	WebElement boldSeriesCabinet;
	@FindBy(xpath="(//*[@class='nxt-ac-products-container'])")
	WebElement productMatches;
	@FindBy(xpath="//*[@id='email_id']")
	WebElement emailField;
	@FindBy(xpath="(//*[@name='validate'])[1]")
	WebElement subscribeBtn;
	@FindBy(xpath="(//*[@class='error_message'])[2]")
	WebElement errMsg;
	@FindBy(xpath="(//*[@class='klaviyo_header'])[2]")
	WebElement successMsg;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	 

   @SuppressWarnings("deprecation")
public void searchProduct() throws InterruptedException {
	   Thread.sleep(1000);
	  
	   searchBoxLink.click();
	//   logger.info("Search product...");
	   Reporter.log("Search product...");
	   SearchBoxField.sendKeys("Garage cabinet");
	   waitForElementClickable(driver, 10, boldSeriesCabinet);
	//   logger.info("Clicking bold series cabinet...");
	   Reporter.log("Clicking bold series cabinet...");
	   boldSeriesCabinet.click();
		
		
	}
	
   public String EnterinvalidMailAndClickSubscribe(String mailid) throws InterruptedException {
	//   logger.info("Enter invalid mail id...");
	   Reporter.log("Enter invalid mail id...");
	   emailField.sendKeys(mailid);
	   Actions act=new Actions(driver);
	 //  logger.info("Clicking subscribe btn...");
	   Reporter.log("Clicking subscribe btn...");
   	   act.moveToElement(subscribeBtn).click().build().perform();
	   Thread.sleep(1000);
	   String str=errMsg.getText();
	   return str;
 
	     
   }
   public String EntervalidMailAndClickSubscribe(String mailid) throws InterruptedException {
	   emailField.clear();
	//   logger.info("Enter valid mail id...");
	   Reporter.log("Enter valid mail id...");
	   emailField.sendKeys(mailid);
	   Actions act=new Actions(driver);
	//   logger.info("Clicking subscribe btn...");
	   Reporter.log("Clicking subscribe btn...");
   	   act.moveToElement(subscribeBtn).click().build().perform();
	   Thread.sleep(1000);
	   String str=successMsg.getText();
	return str;
	   
	     
   }
	   
}

