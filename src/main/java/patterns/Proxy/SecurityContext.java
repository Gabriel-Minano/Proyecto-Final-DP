package patterns.Proxy;

public class SecurityContext {

    private static boolean autenticado = false;

    public static void iniciarSesion() {
        autenticado = true;
    }

    public static boolean isAutenticado() {
        return autenticado;
    }
}
