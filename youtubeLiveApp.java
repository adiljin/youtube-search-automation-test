import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.nativekey.*;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class youtubeLiveApp {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
        cap.setCapability("appPackage", "com.google.android.youtube");
        cap.setCapability("appActivity", "com.google.android.youtube.HomeActivity");

        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        TouchAction t = new TouchAction(driver);
        WebElement checkBox = driver.findElementsByClassName("android.support.v7.widget.LinearLayoutCompat").get(0);  //"android.widget.ImageView[@content-desc='Search']"
        t.tap(ElementOption.element(checkBox)).perform();

        driver.findElementByClassName("android.widget.EditText").sendKeys("Alex 007");

        driver.pressKey( new KeyEvent(AndroidKey.ENTER));

        WebElement alex = driver.findElementByAndroidUIAutomator("text(\"Alex007SC2\")");
        t.tap(ElementOption.element(alex)).perform();

        WebElement videos = driver.findElementByAndroidUIAutomator("text(\"VIDEOS\")");
        t.tap(ElementOption.element(videos)).perform();

        driver.findElementByAndroidUIAutomator("UiScrollable(new UiSelector()).scrollIntoView(text(\"Я ТРЕБУЮ БАН: Полный разбор игр гениального террана из грандмастер лиги StarCraft II\"))");

        WebElement vid1 = driver.findElementByAndroidUIAutomator("text(\"Я ТРЕБУЮ БАН: Полный разбор игр гениального террана из грандмастер лиги StarCraft II\")");
        t.tap(ElementOption.element(vid1)).perform();

    }


}
