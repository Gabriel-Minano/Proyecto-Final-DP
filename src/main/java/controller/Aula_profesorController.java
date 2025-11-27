package controller;

import model.Aula_profesor;
import patterns.Facade.IFacade;
import view.Aula_profesorView;

public class Aula_profesorController {

    private final Aula_profesorView view;
    private final IFacade<Aula_profesor> facade;

    public Aula_profesorController(Aula_profesorView view, IFacade<Aula_profesor> facade) {
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
        Aula_profesor ap = view.pedirDatosAulaProfesor();
        boolean ok = facade.crearEntidad(ap);

        view.mostrarMensaje(ok ? "Asignación creada." : "Error al crear.");
    }

    private void buscar() {
        int id = view.pedirId();
        Aula_profesor ap = facade.verEntidad(id);

        view.mostrarAsignacion(ap);
    }

    private void listar() {
        view.mostrarLista(facade.listarEntidades());
    }

    private void actualizar() {
        int id = view.pedirId();

        Aula_profesor actual = facade.verEntidad(id);

        if (actual == null || actual.getId_asignacion() == 0) {
            view.mostrarMensaje("No existe la asignación.");
            return;
        }

        Aula_profesor nuevosDatos = view.pedirDatosParaActualizar();
        nuevosDatos.setId_asignacion(id);

        boolean ok = facade.actualizarEntidad(nuevosDatos);

        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void eliminar() {
        int id = view.pedirId();

        boolean ok = facade.eliminarEntidad(id);

        view.mostrarMensaje(ok ? "Eliminado correctamente." : "Error al eliminar.");
    }
}
