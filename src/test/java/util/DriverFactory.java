package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {

            // Set desired capabilities for the Android device
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability("appium:platformVersion", "14");
            desiredCapabilities.setCapability("appium:deviceName", "RZCWA0EV6BR");
            desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
            desiredCapabilities.setCapability("appium:appPackage", "com.comunalworkplace");
            desiredCapabilities.setCapability("appium:appActivity", "com.comunalworkplace.MainActivity");

            try {
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), desiredCapabilities);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;

    }


        public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
