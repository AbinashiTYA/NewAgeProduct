

package Page;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class addToCartPage extends TestBase {
	public static final Logger logger = Logger.getLogger(addToCartPage.class.getName());
	@FindBy(xpath="(//*[text()='Sale Items'])[4]/parent::div//p[@class='sales_price_cart black fs-16']")
	WebElement saleItemPrice;
	@FindBy(xpath="(//*[text()='Bundled Items'])[4]/parent::div//p[@class='bundles_price black fs-16']")
	WebElement BundleItemPrice;
	@FindBy(xpath="(//*[text()='Regular Priced Items'])[4]/parent::div//p[@class='regular_price_cart black fs-16']")
	WebElement regularPriceItem;
	@FindBy(xpath="(//*[text()='Delivery'])[4]/parent::div//*[@class='premium_delivery premium_delivery_price ']")
	WebElement delivery;
	@FindBy(xpath="(//*[text()='TOTAL'])[4]/parent::div//*[@class='final_price ff-pb fs-30 blue total_amt']")
	WebElement total;
	@FindBy(xpath="(//*[@class=' blue ff-pb  fs-16 sales_tax_val'])[4]")
	WebElement savedPrice;
    @FindBy(xpath="//*[contains(@class,'onSalePrice')]")
    List<WebElement> productPrice;
	@FindBy(xpath="//*[contains(text(),'Save $')]")
	List<WebElement> save;

	public addToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public double calculateTotalPriceItemWise() throws InterruptedException {
		double price=0;
	
	  	for(WebElement eachProPrice :productPrice)
	  	{
	  		String s=eachProPrice.getText();
	  		String dollarcent=formatter(s);
	  		try{
	  			double price1=Double.parseDouble(dollarcent);
	  		System.out.println(price1);
	  		price=price+price1;
	  		System.out.println(price);
	  		}
			catch(Exception e)
			{
				System.out.println("Not a number");
			}
	  	}
	  	//System.out.println("Item level total Price"+"-->"+price);
	  	return price;
	}
	

	public double calculateTotalSaveItemWise() throws InterruptedException {
		
		double saving=0;
	 	for(WebElement eachProsave :save)
	  	{
	 		
	  		String s1=eachProsave.getText();
	  		String s2=s1.substring(0,s1.indexOf('('));
	  		String dollarcent=formatter(s2);
	  		try
	  		{
	  		double saving1=Double.parseDouble(dollarcent);
	  		System.out.println(saving1);
	  		saving=saving+saving1;
	  		}
	  	
		catch(Exception e)
		{
			System.out.println("Not a number");
		}
	  	}
	 	//System.out.println("Item level total save"+"-->"+saving);
		return saving;
	}	
		public double calculateTotalPriceSummaryLevel() throws InterruptedException {
			
			double sum=0;
			String salep=saleItemPrice.getText();
			String dollarcent1=formatter(salep);
			String bundlep=BundleItemPrice.getText();
			String dollarcent2=formatter(bundlep);
			String saregplep=regularPriceItem.getText();
			String dollarcent3=formatter(saregplep);
			String delp=delivery.getText();
			String dollarcent4=formatter(delp);
			String totalp=total.getText();
			String dollarcent5=formatter(totalp);
			try{
			sum=Double.parseDouble(dollarcent1)+Double.parseDouble(dollarcent2)+Double.parseDouble(dollarcent3)+Double.parseDouble(dollarcent4);
			}
			catch(Exception e)
			{
				System.out.println("Not a number");
			}
		//	System.out.println("Summary level total price"+"-->"+sum);
			return sum;
			
		}
		public double calculateTotalSaveSummaryLevel() throws InterruptedException {
			
			{
				
		  		String saveSum=savedPrice.getText();
		  		String dollarcent1=formatter(saveSum);
		  		double ss=Double.parseDouble(dollarcent1);
		  		//System.out.println("Summary level total save"+"-->"+ss);
		  		
				
		  		return ss;
			}
			
		}}
		
			
		
	
	


