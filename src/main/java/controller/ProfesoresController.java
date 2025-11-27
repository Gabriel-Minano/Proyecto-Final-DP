package controller;

import model.Profesores;
import patterns.Facade.IFacade;
import view.ProfesoresView;

public class ProfesoresController {

    private final ProfesoresView view;
    private final IFacade<Profesores> facade;

    public ProfesoresController(ProfesoresView view, IFacade<Profesores> facade) {
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
        boolean ok = facade.crearEntidad(p);

        view.mostrarMensaje(ok ? "Profesor creado." : "Error al crear.");
    }

    private void buscar() {
        int id = view.pedirId();
        Profesores p = facade.verEntidad(id);

        view.mostrarProfesor(p);
    }

    private void listar() {
        view.mostrarLista(facade.listarEntidades());
    }

    private void actualizar() {
        int id = view.pedirId();
        Profesores actual = facade.verEntidad(id);

        if (actual == null || actual.getId_profesor() == 0) {
            view.mostrarMensaje("No existe el profesor");
            return;
        }
        Profesores nuevosDatos = view.pedirDatosParaActualizar(id);

        boolean ok = facade.actualizarEntidad(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void eliminar() {
        int id = view.pedirId();
        boolean ok = facade.eliminarEntidad(id);

        view.mostrarMensaje(ok ? "Eliminado correctamente." : "Error al eliminar.");
    }
}
