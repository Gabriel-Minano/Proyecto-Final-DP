package patterns.Proxy;

public class LoginFacade {

    private final AuthService auth = new AuthService();

    public boolean iniciarSesion(String usuario, String contrasenha) {
        if (auth.login(usuario, contrasenha)) {
            SecurityContext.iniciarSesion();
            System.out.println("Inicio de sesión exitoso.");
            return true;
        }
        System.out.println("Usuario o contraseña incorrectos.");
        return false;
    }
}
