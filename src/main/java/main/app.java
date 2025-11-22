package main;

import controller.MainController;
import java.util.Scanner;
import patterns.Proxy.LoginFacade;
import view.MainView;

/**
 *
 * @author USER
 */
public class app {

    public static void main(String[] args) {
        LoginFacade login = new LoginFacade();
        Scanner sc = new Scanner(System.in);

        System.out.println("===== LOGIN ADMINISTRADOR =====");
        System.out.print("Usuario: ");
        String user = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (!login.iniciarSesion(user, pass)) {
            System.out.println("No se pudo iniciar sesión. Saliendo...");
            return;
        }

        // Sesión confirmada = SecurityContext.iniciarSesion()
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);

        mainController.iniciar();
    }
}
