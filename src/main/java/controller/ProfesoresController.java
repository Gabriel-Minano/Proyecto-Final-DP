package controller;

import model.Profesores;
import patterns.Facade.ProfesoresFacade;
import view.ProfesoresView;

public class ProfesoresController {

    private final ProfesoresView view;
    private final ProfesoresFacade facade;

    public ProfesoresController(ProfesoresView view, ProfesoresFacade facade) {
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
                    System.out.println("Opción inválida");
            }
        }
    }

    private void crear() {
        Profesores p = view.pedirDatosProfesor();
        boolean ok = facade.crearProfesor(p);

        view.mostrarMensaje(ok ? "Profesor creado." : "Error al crear.");
    }

    private void buscar() {
        int id = view.pedirId();
        Profesores p = facade.verProfesores(id);

        view.mostrarProfesor(p);
    }

    private void listar() {
        view.mostrarLista(facade.verListaProfesores());
    }

    private void actualizar() {
        int id = view.pedirId();
        Profesores actual = facade.verProfesores(id);

        if (actual == null || actual.getId_profesor() == 0) {
            view.mostrarMensaje("No existe el profesor");
            return;
        }
        Profesores nuevosDatos = view.pedirDatosParaActualizar(id);

        boolean ok = facade.actualizarProfesores(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void eliminar() {
        int id = view.pedirId();
        boolean ok = facade.eliminarProfesor(id);

        view.mostrarMensaje(ok ? "Eliminado correctamente." : "Error al eliminar.");
    }
}
