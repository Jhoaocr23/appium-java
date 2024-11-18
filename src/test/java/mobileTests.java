import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class mobileTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Set desired capabilities for the Android device
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "34261JEHN01446");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.booking");
        desiredCapabilities.setCapability("appActivity", "com.booking.startup.HomeActivity");

        // Create an instance of the AppiumDriver
        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.setSetting("waitForIdleTimeout", 100);
        // Perform some actions on the app

        //click on "No Permitir" button
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement buttonNoPermission = driver.findElementById("com.android.permissioncontroller:id/permission_deny_button");
        buttonNoPermission.click();
        System.out.println("Click on No Permitir button.");

        //Validate  "Iniciar Sesion" button is present
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement iniciarSesionButton = driver.findElementByXPath("//android.widget.Button[@resource-id='action-login']");
        if (iniciarSesionButton.isDisplayed()) {
            System.out.println("El botón 'Iniciar Sesión' está presente.");
        } else {
            System.out.println("El botón 'Iniciar Sesión' no está presente.");
        }

        //Click on  "Iniciar Sesion" button

        iniciarSesionButton.click();
        System.out.println("Click on Iniciar Sesion button.");

        // Validate "txtMail" button is present
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtEmail = driver.findElementByXPath("//android.widget.EditText[@resource-id='input-text-email']");
        System.out.println("Continuar button is present");

        // Fill input "Correo"
        txtEmail.sendKeys("testvip@mailinator.com");
        System.out.println("Fill input Numero de Documento");

        // Validate "Continuar" button is present
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement inputContinue = driver.findElementByXPath("//android.widget.Button[@resource-id='action-continue']");
        System.out.println("Continuar button is present");

        // Click on "Continuar" button
        inputContinue.click();
        System.out.println("Click on Continuar button");


        //Validate  txtPassword
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement txtPassword = driver.findElementByXPath("//android.widget.EditText[@resource-id='input-text-password']");

        if (txtPassword.isDisplayed()) {
            System.out.println("Iniciar Sesion button is present");
        } else {
            System.out.println("Iniciar Sesion button is not present.");
        }
        txtPassword.sendKeys("Comunal123.");

        driver.hideKeyboard();



        // Fill input "Ingresar"

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement btnIngresa = driver.findElementByXPath("//android.widget.Button[@resource-id='action-signin']");
        Actions actions = new Actions(driver);
        if (btnIngresa.isDisplayed()) {
            System.out.println("Boton Ingresar Presente");
            actions.moveToElement(btnIngresa).click().perform();
            actions.moveToElement(btnIngresa).click().perform();
        } else {
            System.out.println("Boton Ingresar No esta Presente");

        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement inputGPS = driver.findElementById("com.android.permissioncontroller:id/permission_deny_button");
        System.out.println("Boton GPS Presente");
        inputGPS.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement inputTxt = driver.findElementByXPath("//android.widget.TextView");
        System.out.println("Boton PopUp Presente");
        inputTxt.click();

        driver.quit();


    }
}