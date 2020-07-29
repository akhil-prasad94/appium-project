package AppiumProject.AppiumFramework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilityclass {

	
	AndroidDriver<AndroidElement> driver;
	
	public Utilityclass(AndroidDriver<AndroidElement> driver) 
	{
		
		this.driver = driver;
		
	}
	
	public void scrollToText(String containedText)
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));	
	}
	
	
}
