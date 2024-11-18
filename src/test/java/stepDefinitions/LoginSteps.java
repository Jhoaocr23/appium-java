package stepDefinitions;

import io.cucumber.java.es.*;
import pages.LoginPage;
import util.DriverFactory;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Dado(": La pantalla principal de Login")
    public void la_pantalla_principal_de_login() { loginPage.clickNoPermitir();}

    @Cuando(": Selecciono el boton Iniciar Sesión")
    public void selecciono_el_boton_iniciar_sesión() {
        loginPage.clickBotonIngresar();
    }
    @Cuando(": Ingreso un email registrado correctamente")
    public void ingreso_un_email_registrado_correctamente() {
        loginPage.ingresaEmail();
    }
    @Cuando(": doy click al boton Continuar")
    public void doy_click_al_boton_continuar() {
        loginPage.clickBotonContinuar();
    }
    @Cuando(": Ingreso correctamente la contraseña")
    public void ingreso_correctamente_la_contraseña() {
        loginPage.ingresaPassword();
    }
    @Cuando(": Doy click al boton Ingresar")
    public void doy_click_al_boton_ingresar() {
        loginPage.clickIngresarCuenta();
    }
    @Entonces(": Cargara la pagina principal del dashboard")
    public void cargara_la_pagina_principal_del_dashboard() {
        loginPage.objetoHome();
    }
}
