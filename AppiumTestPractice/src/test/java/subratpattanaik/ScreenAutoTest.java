package subratpattanaik;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScreenAutoTest extends BasicAppiumTest {

	@Test
	public void startServer() throws Exception {
		openAppium();
	}
	
	
	public void testCase1() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Preferences from XML")).click();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.CheckBox")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
//		driver.findElement(AppiumBy.accessibilityId("android:id/edit")).sendKeys("Dog");
//		Thread.sleep(5000);
//		driver.findElement(AppiumBy.accessibilityId("android:id/button1")).click();
	}
	
	//tagname[@attribute='Value']; --< xpath creation by own method
	
	@Test
	public void wifiSettingTest() {
		System.out.println("wifiSettingTest Testing starts");
		System.out.println("------------------------------");
		WebElement preferenceButton  = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceButton.click();
		
		WebElement preferenceDependancyButton = driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies"));
		preferenceDependancyButton.click();

		String wifiSettingVisible = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).getText();
		assertNotEquals(wifiSettingVisible,"WiFi settings");
		WebElement wifiCheckBox = driver.findElement(By.id("android:id/checkbox"));
		wifiCheckBox.click();
//		wifiSettingVisible = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).getText();
//		assertEquals(wifiSettingVisible, "WiFi settings");
//		
		WebElement wifiSettingButton = driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"));
		wifiSettingButton.click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Subs");
		String wifiName = driver.findElement(By.id("android:id/edit")).getText();
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		System.out.println("Wifi Name set to "+wifiName);
		System.out.println("------------------------------");
		System.out.println("wifiSettingTest Testing completed");
	}
	

	
}
