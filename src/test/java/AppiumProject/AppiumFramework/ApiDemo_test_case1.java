package AppiumProject.AppiumFramework;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemo_test_case1 extends Base{

	
	@Test
	public  void apiDemos() throws IOException {
		// TODO Auto-generated method stub
		
	 AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     HomePage h = new HomePage(driver);
     
     h.Preferences.click();
     
     Preferences p = new Preferences(driver);
     
     p.dependencies.click();
     
     p.checkbox1.click();
     
     p.wifisettings.click();
     
     p.typein.sendKeys("hello gugticks");
     
     p.buttons.get(1).click();
     
     driver.quit();
    
     //driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//     driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
     
//     driver.findElementById("android:id/checkbox").click();
//     driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//     driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
     
//     driver.findElementsByClassName("android.widget.Button").get(1).click(); 
	}

}
