# language: es

Característica: Login HappyPath

  @Login-IngresoCorrecto
  Escenario: Ingreso exitoso a la aplicación
    Dado : La pantalla principal de Login
    Cuando : Selecciono el boton Iniciar Sesión
    E : Ingreso un email registrado correctamente
    Y : doy click al boton Continuar
    E : Ingreso correctamente la contraseña
    Y : Doy click al boton Ingresar
    Entonces : Cargara la pagina principal del dashboard
