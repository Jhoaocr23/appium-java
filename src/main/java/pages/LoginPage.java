package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    public MobileElement noPermitir;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='action-go-login']")
    public MobileElement clickIniciarSesion;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='input-text-email']")
    public MobileElement ingresarEmail;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='action-continue']")
    public MobileElement botonContinue;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='input-text-password']")
    public MobileElement txtPassword;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='action-signin']")
    public MobileElement btnIngresar;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    public MobileElement btnGPSOnlyOne;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup)[2]")
    public MobileElement objetcHome;


    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        driver.setSetting("waitForIdleTimeout", 100);
        // Perform some actions on the app
    }

    public void clickNoPermitir() {

        noPermitir.click();
        System.out.println("Click on No Permitir.");
    }

    public void clickBotonIngresar() {
        if (clickIniciarSesion.isDisplayed()) {
            System.out.println("El botón 'Iniciar Sesión' está presente.");
        } else {
            System.out.println("El botón 'Iniciar Sesión' no está presente.");
        }
        clickIniciarSesion.click();

    }

    public void ingresaEmail() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(ingresarEmail)); // Espera hasta que el elemento sea visible
        ingresarEmail.sendKeys("testvip@mailinator.com");
    }

    public void clickBotonContinuar(){
        botonContinue.click();
    }

    public void ingresaPassword(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        if (txtPassword.isDisplayed())
            System.out.println("El boton esta presente");
        else
            System.out.println("No esta Presente");
        txtPassword.sendKeys("Comunal123.");
    }

    public void clickIngresarCuenta(){
        btnIngresar.click();
        btnIngresar.click();

    }

    public void objetoHome(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(btnGPSOnlyOne));
        btnGPSOnlyOne.click();
        WebDriverWait wait1 = new WebDriverWait(driver,5);
        wait1.until(ExpectedConditions.visibilityOf(objetcHome));
        if (objetcHome.isDisplayed())
            System.out.println("El boton esta presente");
        else
            System.out.println("No esta Presente");
        driver.quit();

    }

}
