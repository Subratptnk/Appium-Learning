package subratpattanaik;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AndroidDragDropGestures extends BasicAppiumTest {

	@Test
	public void dragDropAction() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement element = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		HashMap<String, Object> params = new HashMap();
//		params.put("duration", 1.0);
//		params.put("fromX", 252);
//		params.put("fromY", 780);
//		params.put("toX", 831);
//		params.put("toY", 785);
//		params.put("element", ((RemoteWebElement) element).getId());
		
		((JavascriptExecutor)driver).executeScript("mobile:dragGesture",ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"endX",826,
				"endY",780  ));
		String successMesg = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(successMesg, "Dropped!");	
		Thread.sleep(5000);
	}
}

// browserstack.com/docs/app-automate/appium/advanced-features/appium-gestures