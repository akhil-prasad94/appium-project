package AppiumProject.AppiumFramework;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import java.io.IOException;

public class Ecommerce_test_case1 extends Base{


	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	
	
	@Test
	public void totalValidation() throws InterruptedException, IOException {

	 service = startServer();	
		
	 AndroidDriver<AndroidElement> driver  =  capabilities("GeneralStoreApp");
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     FormPage f = new FormPage(driver);
     
     f.getNameField().sendKeys("Hello");
     
     driver.hideKeyboard();
     
     f.femaleCheck.click();
     
     f.getCountrySelection().click();
     
     Utilityclass u = new Utilityclass(driver);
     
     u.scrollToText("Argentina");
     
     f.argentina.click();
     
     f.letsShopButton.click();
     
     Thread.sleep(4000);
     
     f.addtoCart.get(0).click();
     
     f.addtoCart.get(0).click();
     
     f.appbarBtnCart.click();
   
     CheckoutPage c = new CheckoutPage(driver);
     
     c.checkProductTotal();
     
     service.stop();
     
     
//	//Mobile Gestures

//	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
	
//	TouchAction t=new TouchAction(driver);
	
//	t.tap(tapOptions().withElement(element(checkbox))).perform();

//	WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
	
//	t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
	
//	driver.findElement(By.id("android:id/button1")).click();
	
//	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();	
	}

	}



