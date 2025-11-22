package controller;

import model.Alumnos;
import patterns.Facade.AlumnosFacade;
import view.AlumnosView;

public class AlumnosController {

    private final AlumnosView view;
    private final AlumnosFacade facade;

    public AlumnosController(AlumnosView view, AlumnosFacade facade) {
        this.view = view;
        this.facade = facade;
    }

    public void iniciar() {
        boolean bucle = false;

        while (!bucle) {
            int opcion = view.mostrarMenu();

            switch (opcion) {
                case 1 ->
                    crear();
                case 2 ->
                    buscar();
                case 3 ->
                    listar();
                case 4 ->
                    actualizar();
                case 5 ->
                    eliminar();
                case 0 ->
                    bucle = true;
                default ->
                    view.mostrarMensaje("Opción inválida");
            }
        }
    }

    private void crear() {
        Alumnos a = view.pedirDatosAlumnos();
        boolean ok = facade.crearAlumno(a);

        view.mostrarMensaje(ok ? "Alumno creado." : "Error al crear.");
    }

    private void buscar() {
        int id = view.pedirId();
        Alumnos a = facade.verAlumno(id);

        view.mostrarAlumno(a);
    }

    private void listar() {
        view.mostrarLista(facade.verListaAlumnos());
    }

    private void actualizar() {
        int id = view.pedirId();
        Alumnos actual = facade.verAlumno(id);

        if (actual == null || actual.getId_alumno() == 0) {
            view.mostrarMensaje("No existe el administrador");
            return;
        }
        Alumnos nuevosDatos = view.pedirDatosParaActualizar(id);

        boolean ok = facade.actualizarAlumno(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void eliminar() {
        int id = view.pedirId();
        boolean ok = facade.eliminarAlumno(id);

        view.mostrarMensaje(ok ? "Eliminado correctamente." : "Error al eliminar.");
    }

}
