package subratpattanaik;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AndroidGestures extends BasicAppiumTest {
	@Test
	public void longPress() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();;
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//long click gesture
		// https://appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text = 'People Names']"));
		
		longPressAction(ele);
		
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration",2000
//			));
	
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		Thread.sleep(5000);

	}


	
}
