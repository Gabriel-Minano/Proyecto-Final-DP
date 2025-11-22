package view;

import java.util.Scanner;
import java.util.List;
import model.Administradores;

public class AdministradoresView {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ ADMINISTRADORES =====");
        System.out.println("1. Crear administrador");
        System.out.println("2. Ver administrador");
        System.out.println("3. Listar administradores");
        System.out.println("4. Actualizar administrador");
        System.out.println("5. Eliminar administrador");
        System.out.println("0. Volver al menú principal");
        System.out.println("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int pedirId() {
        System.out.print("Ingrese ID del administrador: ");
        return scanner.nextInt();
    }

    public Administradores pedirDatosAdministradores() {
        scanner.nextLine();

        Administradores a = new Administradores();
        System.out.print("Usuario: ");
        a.setUsuario(scanner.nextLine());
        System.out.print("Contraseña: ");
        a.setContrasenha(scanner.nextLine());
        return a;
    }

    public Administradores pedirDatosParaActualizar() {
        scanner.nextLine();
        Administradores a = new Administradores();

        System.out.print("Nuevo usuario: ");
        a.setUsuario(scanner.nextLine());
        System.out.print("Nueva contraseña: ");
        a.setContrasenha(scanner.nextLine());
        return a;
    }

    public void mostrarAdministrador(Administradores a) {
        if (a == null || a.getId_admin() == 0) {
            System.out.println("No existe el administrador.");
            return;
        }
        System.out.println("\n=============================================");
        System.out.printf("\nID: %d | Usuario: %s, | Contraseña: %s", a.getId_admin(), a.getUsuario(), a.getContrasenha());
    }

    public void mostrarLista(List<Administradores> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay administradores registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE ADMINISTRADORES =====");
        for (Administradores a : lista) {
            mostrarAdministrador(a);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
