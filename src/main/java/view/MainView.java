package view;

import java.util.Scanner;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("\n=========== SISTEMA DE GESTIÓN ===========");
        System.out.println("1. Gestionar Administradores");
        System.out.println("2. Gestionar Profesores");
        System.out.println("3. Gestionar Alumnos");
        System.out.println("4. Gestionar Aulas");
        System.out.println("5. Gestionar Asignaciones"); //FALTA TERMINAR ESTE MÓDULO Y AÑADIR COMMAND A MAINCONTROLLER
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }
}
