package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	
	public CheckoutPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> priceCount;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	

	public void checkProductTotal()
	{
		int count = priceCount.size();
		
		double sum = 0;
		
		for(int i=0; i<count ; i++)
		{
			String amount1= priceCount.get(i).getText();	
			double amount=getAmount(amount1);
			sum=sum+amount;//280.97+116.97
		}
		String total = totalAmount.getText();
     
		total= total.substring(1);

		double totalValue=Double.parseDouble(total);
  
		System.out.println(totalValue+"Total value of products\n\n\n");

		Assert.assertEquals(sum, totalValue); 	
	}
	
	public static double getAmount(String value)
	{
	value= value.substring(1);
	double amount2value=Double.parseDouble(value);
	return amount2value;
    }
	
	
	
}
