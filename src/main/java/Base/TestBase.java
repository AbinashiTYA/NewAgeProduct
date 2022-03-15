package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import test.priceTest;


public class TestBase {
	//public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static  WebDriver driver;
    @SuppressWarnings("deprecation")
   
    public static void initialization() throws IOException{
    	   // loadPropertiesFile();
			System.setProperty("webdriver.chrome.driver", "C:/Users/Sunil/Desktop/chromedriver.exe");	
		//	logger.info("Opening Browser...");
			driver = new ChromeDriver(); 
			driver.manage().deleteAllCookies();
		//	logger.info("Maximizing browser...");
			driver.manage().window().maximize();
		//	logger.info("Opening Shopnewage...");
			driver.navigate().to("https://shopnewage.com/");
			
			

		}
    
	public WebElement waitForElementVisible(WebDriver driver,long time,WebElement element){
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public WebElement waitForElementClickable(WebDriver driver,long time,WebElement element){
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	
	public void impliciteWait(long time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void closePopup(WebDriver driver,WebElement closePopup1,WebElement element2)
	
	{ /*int attempts = 0;
    while(attempts < 2) {*/
        try {
        	
		
		if(closePopup1.isDisplayed())
		{   Thread.sleep(2000);
			Actions act=new Actions(driver);
			//logger.info("Closing popup...");
	    	act.moveToElement(closePopup1).click().build().perform();
		}
		else if(element2.isDisplayed())
		{   element2.click();
			Actions act=new Actions(driver);
		//	logger.info("Closing popup...");
	    	act.moveToElement(closePopup1).click().build().perform();
		}
	 //break;
              } 
        catch(Exception e) {
    }
    //attempts++ ;
    }

  public String formatter(String s)
  
  {
	    String dot=".";
		String str=s. replaceAll("[^0-9]", "");//$23499----234.99
		String dollarcent=str.substring(0,str.length()-2)+dot+str.substring(str.length()-2, str.length());
		return dollarcent;  
  }
 /* public static void loadPropertiesFile() throws IOException{
		
	  String configLFilename="\\Users\\Sunil\\workspace1\\A\\src\\main\\resources\\log4j.properties";
		PropertyConfigurator.configure(configLFilename);
		
  }*/

  public static void main(String[] args) throws Exception {
		TestBase test = new TestBase();
	//	test.loadPropertiesFile();
	
		

	}
	
   /* @AfterSuite
    public void closeApplication()
    {
    	driver.close();
    }*/
	
	}
	
	
	
	
	
	
	
	

