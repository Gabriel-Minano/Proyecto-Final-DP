package view;

import java.util.List;
import java.util.Scanner;
import model.Profesores;

public class ProfesoresView {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n======= MENÚ DE PROFESORES =======");
        System.out.println("1. Crear profesor");
        System.out.println("2. Ver profesor");
        System.out.println("3. Ver lista de profesores");
        System.out.println("4. Actualizar profesor");
        System.out.println("5. Eliminar profesor");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int pedirId() {
        System.out.print("Ingrese ID del profesor: ");
        return scanner.nextInt();
    }

    public Profesores pedirDatosProfesor() {
        scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Primer nombre: ");
        String pNom = scanner.nextLine();

        System.out.print("Segundo nombre: ");
        String sNom = scanner.nextLine();

        System.out.print("Primer apellido: ");
        String pApe = scanner.nextLine();

        System.out.print("Segundo apellido: ");
        String sApe = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Segunda especialidad: ");
        String segundaEspecialidad = scanner.nextLine();

        return new Profesores.Builder()
                .dni(dni)
                .primerNombre(pNom)
                .segundoNombre(sNom)
                .primerApellido(pApe)
                .segundoApellido(sApe)
                .especialidad(especialidad)
                .segundaEspecialidad(segundaEspecialidad)
                .build();
    }

    public Profesores pedirDatosParaActualizar(int id) {
        scanner.nextLine();

        System.out.print("Nuevo DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Nuevo primer nombre: ");
        String pNom = scanner.nextLine();

        System.out.print("Nuevo segundo nombre: ");
        String sNom = scanner.nextLine();

        System.out.print("Nuevo primer apellido: ");
        String pApe = scanner.nextLine();

        System.out.print("Nuevo segundo apellido: ");
        String sApe = scanner.nextLine();

        System.out.print("Nueva especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Nueva segunda especialidad: ");
        String segundaEspecialidad = scanner.nextLine();

        return new Profesores.Builder()
                .idProfesor(id)
                .dni(dni)
                .primerNombre(pNom)
                .segundoNombre(sNom)
                .primerApellido(pApe)
                .segundoApellido(sApe)
                .especialidad(especialidad)
                .segundaEspecialidad(segundaEspecialidad)
                .build();
    }

    public void mostrarProfesor(Profesores p) {
        if (p == null || p.getId_profesor() == 0) {
            System.out.println("No se encontró el profesor.");
            return;
        }
        System.out.println("\n===================================================================");
        System.out.printf("%d | %s | %s %s | %s %s | %s | %s\n", p.getId_profesor(), p.getDni(), p.getPrimer_nombre(), p.getSegundo_nombre(), p.getPrimer_apellido(), p.getSegundo_apellido(), p.getEspecialidad(), p.getSegunda_especialidad());
    }

    public void mostrarLista(List<Profesores> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE PROFESORES =====");
        for (Profesores p : lista) {
            mostrarProfesor(p);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
