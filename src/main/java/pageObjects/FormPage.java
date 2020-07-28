package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	private AppiumDriver driver;

	public FormPage(AppiumDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement femaleCheck;
	
	@AndroidFindBy(id = "android:id/text1")
	public WebElement countrySelect;
	
	@AndroidFindBy(xpath = "/*[@text='Argentina']")
	public WebElement argentina;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShopButton;
	
	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	public List<WebElement> addtoCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement appbarBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public WebElement priceCount;
	
	
	public void scrollToText(String containedText)
    {
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
    }
	
}
