package subratpattanaik;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicAppiumTest {
	
	AndroidDriver driver; 
	@BeforeClass
	public void openAppium() throws Exception {
		
		File f = new File("src"); 
		File fs = new File(f,"ApiDemos-debug.apk");
		
//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("C://Users//asus//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingAnyFreePort().build();
//		service.start();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SubratPhone2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),cap);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
//		AndroidDriver driver = new AndroidDriver(service,cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		service.start();
	}
	@AfterClass
	public void stopServer() {
		driver.quit();
	}
	
	

}
