package AppiumProject.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
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
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class Base {
	
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag)
		{	
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch(IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		
	System.getProperty("user.dir"); // this gets the path dynamically in whichever system the test is being executed
		
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AppiumProject\\AppiumFramework\\global.properties");
	
	Properties prop = new Properties();	
	
	prop.load(fis);			
		
	AndroidDriver<AndroidElement> driver;
		
	File f = new File("src");
	
	File fs = new File(f, (String)prop.getProperty(appName));
	
	DesiredCapabilities cap = new DesiredCapabilities();
	
	String device = (String) prop.get("device");
	
	if(device.contains("Emulator"))
	{
		startEmulator();
	}
	
	
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
