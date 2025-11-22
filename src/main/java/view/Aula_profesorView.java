package view;

import java.util.Scanner;
import java.util.List;
import model.Aula_profesor;
import model.Aulas;
import model.Profesores;

public class Aula_profesorView {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n===== MENÚ ASIGNACIÓN AULA-PROFESOR =====");
        System.out.println("1. Crear asignación");
        System.out.println("2. Ver asignación");
        System.out.println("3. Listar asignaciones");
        System.out.println("4. Actualizar asignación");
        System.out.println("5. Eliminar asignación");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int pedirId() {
        System.out.print("Ingrese ID de la asignación: ");
        return scanner.nextInt();
    }

    public Aula_profesor pedirDatosAulaProfesor() {
        scanner.nextLine();
        Aula_profesor ap = new Aula_profesor();

        Aulas aula = new Aulas();
        Profesores profesor = new Profesores();

        System.out.print("ID del aula: ");
        aula.setId_aula(scanner.nextInt());
        scanner.nextLine();

        System.out.print("ID del profesor: ");
        profesor.setId_profesor(scanner.nextInt());
        scanner.nextLine();

        ap.setAula(aula);
        ap.setProfesor(profesor);

        return ap;
    }

    public Aula_profesor pedirDatosParaActualizar() {
        scanner.nextLine();
        Aula_profesor ap = new Aula_profesor();

        Aulas aula = new Aulas();
        Profesores profesor = new Profesores();

        System.out.print("Nuevo ID del aula: ");
        aula.setId_aula(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nuevo ID del profesor: ");
        profesor.setId_profesor(scanner.nextInt());
        scanner.nextLine();

        ap.setAula(aula);
        ap.setProfesor(profesor);

        return ap;
    }

    public void mostrarAsignacion(Aula_profesor ap) {
        if (ap == null || ap.getId_asignacion() == 0) {
            System.out.println("No existe la asignación.");
            return;
        }
        System.out.println("\n=============================================");
        System.out.printf("ID Asignación: %d | ID Aula: %d | ID Profesor: %d",ap.getId_asignacion(),ap.getAula().getId_aula(),ap.getProfesor().getId_profesor());
    }

    public void mostrarLista(List<Aula_profesor> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay asignaciones registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE ASIGNACIONES AULA-PROFESOR =====");
        for (Aula_profesor ap : lista) {
            mostrarAsignacion(ap);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
