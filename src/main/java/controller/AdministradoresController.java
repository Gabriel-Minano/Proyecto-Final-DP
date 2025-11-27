package controller;

import model.Administradores;
import patterns.Facade.IFacade;
import view.AdministradoresView;

public class AdministradoresController {

    private final AdministradoresView view;
    private final IFacade<Administradores> facade;

    public AdministradoresController(AdministradoresView view, IFacade<Administradores> facade) {
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
        Administradores a = view.pedirDatosAdministradores();
        boolean ok = facade.crearEntidad(a);

        view.mostrarMensaje(ok ? "Administrador creado." : "Error al crear.");
    }

    private void buscar() {
        int id = view.pedirId();
        Administradores a = facade.verEntidad(id);

        view.mostrarAdministrador(a);
    }

    private void listar() {
        view.mostrarLista(facade.listarEntidades());
    }

    private void actualizar() {
        int id = view.pedirId();

        Administradores actual = facade.verEntidad(id);

        if (actual == null || actual.getId_admin() == 0) {
            view.mostrarMensaje("No existe el administrador.");
            return;
        }

        Administradores nuevosDatos = view.pedirDatosParaActualizar();
        nuevosDatos.setId_admin(id);

        boolean ok = facade.actualizarEntidad(nuevosDatos);

        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void eliminar() {
        int id = view.pedirId();

        boolean ok = facade.eliminarEntidad(id);

        view.mostrarMensaje(ok ? "Eliminado correctamente." : "Error al eliminar.");
    }
}
