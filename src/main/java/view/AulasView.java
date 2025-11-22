package view;

import java.util.Scanner;
import java.util.List;
import model.Aulas;

public class AulasView {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ AULAS =====");
        System.out.println("1. Crear aula");
        System.out.println("2. Ver aula");
        System.out.println("3. Listar aulas");
        System.out.println("4. Actualizar aula");
        System.out.println("5. Eliminar aula");
        System.out.println("0. Volver al menú principal");
        System.out.println("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int pedirId() {
        System.out.print("Ingrese ID del aula: ");
        return scanner.nextInt();
    }

    public Aulas pedirDatosAulas() {
        scanner.nextLine();
        Aulas a = new Aulas();

        System.out.print("Grado: ");
        a.setGrado(scanner.nextLine());
        System.out.print("Sección: ");
        a.setSeccion(scanner.nextLine());
        return a;
    }

    public Aulas pedirDatosParaActualizar() {
        scanner.nextLine();
        Aulas a = new Aulas();

        System.out.print("Nuevo Grado: ");
        a.setGrado(scanner.nextLine());
        System.out.print("Nueva Sección: ");
        a.setSeccion(scanner.nextLine());
        return a;
    }

    public void mostrarAula(Aulas a) {
        if (a == null || a.getId_aula() == 0) {
            System.out.println("No existe la aula.");
            return;
        }
        System.out.println("\n=============================================");
        System.out.printf("\nID: %d | Grado: %s, | Seccion: %s", a.getId_aula(), a.getGrado(), a.getSeccion());
    }

    public void mostrarLista(List<Aulas> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay aulas registrados.");
            return;
        }
        System.out.println("\n===== LISTA DE AULAS =====");
        for (Aulas a : lista) {
            mostrarAula(a);
        }

    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
