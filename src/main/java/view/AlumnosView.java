package view;

import java.util.List;
import java.util.Scanner;
import model.Alumnos;

public class AlumnosView {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n======= MENÚ DE ALUMNOS =======");
        System.out.println("1. Crear alumno");
        System.out.println("2. Ver alumno");
        System.out.println("3. Ver lista de alumnos");
        System.out.println("4. Actualizar alumno");
        System.out.println("5. Eliminar alumno");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int pedirId() {
        System.out.print("Ingrese ID del alumno: ");
        return scanner.nextInt();
    }

    public Alumnos pedirDatosAlumnos() {
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

        System.out.print("ID aula: ");
        int idAula = scanner.nextInt();

        return new Alumnos.Builder()
                .dni(dni)
                .primerNombre(pNom)
                .segundoNombre(sNom)
                .primerApellido(pApe)
                .segundoApellido(sApe)
                .idAula(idAula)
                .build();
    }

    public Alumnos pedirDatosParaActualizar(int id) {
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

        System.out.print("Nuevo ID aula: ");
        int idAula = scanner.nextInt();

        return new Alumnos.Builder()
                .idAlumno(id)
                .dni(dni)
                .primerNombre(pNom)
                .segundoNombre(sNom)
                .primerApellido(pApe)
                .segundoApellido(sApe)
                .idAula(idAula)
                .build();
    }

    public void mostrarAlumno(Alumnos a) {
        if (a == null || a.getId_alumno() == 0) {
            System.out.println("No se encontró el alumno.");
            return;
        }
        System.out.println("\n===================================================================");
        System.out.printf("\n%d | %s, | %s %s | %s %s | %d", a.getId_alumno(), a.getDni(), a.getPrimer_nombre(), a.getSegundo_nombre(), a.getPrimer_apellido(), a.getSegundo_apellido(), a.getId_aula());
    }

    public void mostrarLista(List<Alumnos> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay administradores registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE ALUMNOS =====");
        for (Alumnos a : lista) {
            mostrarAlumno(a);
        }
    }
    public void mostrarLista2(List<Alumnos> lista){
    
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
