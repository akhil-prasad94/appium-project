package AppiumProject.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;		 
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
		 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base {
	
	static AppiumDriver driver;
	
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		
	FileInputStream fis = new FileInputStream("C:\\Users\\akhil\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\AppiumProject\\AppiumFramework\\global.properties");
	
	Properties prop = new Properties();	
	
	prop.load(fis);			
		
	AndroidDriver<AndroidElement> driver;
		
	File f = new File("src");
	
	File fs = new File(f, (String)prop.getProperty(appName));
	
	DesiredCapabilities cap = new DesiredCapabilities();
	
	String device = (String) prop.get("device");
	
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "APTicksEmulator");
	
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
	
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
	
	cap.setCapability(MobileCapabilityType.VERSION, "9.0");
	
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	
	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	
	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	}	
	}
