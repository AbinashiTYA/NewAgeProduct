package Page;

import java.util.List;
import java.util.Set;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Base.TestBase;

public class productPage extends TestBase{
	//public static final Logger logger = Logger.getLogger(productPage.class.getName());
	@FindBy(xpath="//*[@class='bookCusltaionFree text-center']/parent::div//*[@class='bookcunsult_close_modal klaviyo_header_close']")
	WebElement closePopup1;
	@FindBy(xpath="(//a[@class='klaviyo_close_modal klaviyo_header_close'])[2]")
	WebElement closePopup2;
	@FindBy(xpath="(//*[@id='EnterLocation'])[1]")
	WebElement deliverToLink;
	@FindBy(xpath="//*[text()='Red']/parent::div")
	WebElement colour;
	@FindBy(xpath="(//*[@name='quantity'])[1]")
	WebElement qty;
	@FindBy(xpath="//span[text()='Add To Cart']")
	WebElement addToCart;
	@FindBy(xpath="(//button[text()='Add to your set'])[1]")
	WebElement addToSet;
	@FindBy(xpath="//input[@id='postalCode']")
	WebElement enterZip;
	@FindBy(xpath="//*[@id='postal_code_submit_button']")
	WebElement update;
	@FindBy(xpath="(//*[@class='select row row-center adding_padding_swatches'])[1]")
	WebElement fieldsArea;
	@FindBy(xpath="(//*[@class='fs-30 white'])[2]")
	WebElement cart;
	@FindBy(xpath="//a[text()='View cart']")
	WebElement viewcart;
	
	public productPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void enterZipcode() throws InterruptedException {
		impliciteWait(1000);
		Thread.sleep(1000);
		closePopup(driver, closePopup1, closePopup2);
		Thread.sleep(1000);
	//	logger.info("opening zip code textbox....");
		Reporter.log("opening zip code textbox....");
		deliverToLink.click();
		Thread.sleep(500);
		closePopup(driver, closePopup1, closePopup2);
	//	logger.info("Entering zipcode....");
		Reporter.log("Entering zipcode....");
		
		enterZip.sendKeys("90210");
		closePopup(driver, closePopup1, closePopup2);
	//	logger.info("clicking update button.....");
		Reporter.log("clicking update button.....");
		update.click();
	}
	public void selectColour() throws InterruptedException {
		impliciteWait(1000);
		closePopup(driver, closePopup1, closePopup2);
		Thread.sleep(500);
		closePopup(driver, closePopup1, closePopup2);
	//	logger.info("Selecting colour....");
		Reporter.log("Selecting colour....");
		colour.click();
	}
	public void enterQtyAddSettocart() throws InterruptedException {
		impliciteWait(1000);
		qty.clear();
		closePopup(driver, closePopup1, closePopup2);
		Thread.sleep(1000);
	//	logger.info("Entering qty ....");
		Reporter.log("Entering qty ....");
		qty.sendKeys("4");
		closePopup(driver, closePopup1, closePopup2);
		Thread.sleep(1000);
	//	logger.info("Adding to cart....");
		Reporter.log("Adding to cart....");
		addToCart.click();
		Thread.sleep(1000);
	//	closePopup(driver, closePopup1, closePopup2);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",addToSet);
		closePopup(driver, closePopup1, closePopup2);
	//	logger.info("Adding to set......");
		Reporter.log("Adding to set......");
		addToSet.click();
		Thread.sleep(500);
		closePopup(driver, closePopup1, closePopup2);
	//	logger.info("viewing cart.....");
		Reporter.log("viewing cart.....");
		viewcart.click();
		}
		   

}

