package subratpattanaik;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AndroidScrollGesture extends BasicAppiumTest {

	@Test
	public void scroll() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(5000);
	}
}
