package controller;

import model.Aulas;
import patterns.Facade.AulasFacade;
import view.AulasView;

public class AulasController {

    private final AulasView view;
    private final AulasFacade facade;

    public AulasController(AulasView view, AulasFacade facade) {
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
        Aulas a = view.pedirDatosAulas();
        boolean ok = facade.crearAula(a);

        view.mostrarMensaje(ok ? "Aula creada." : "Error al crear.");
    }

    private void buscar() {
        int id = view.pedirId();
        Aulas a = facade.verAulas(id);

        view.mostrarAula(a);
    }

    private void listar() {
        view.mostrarLista(facade.verListaAulas());
    }

    private void actualizar() {
        int id = view.pedirId();

        Aulas actual = facade.verAulas(id);

        if (actual == null || actual.getId_aula() == 0) {
            view.mostrarMensaje("No existe el aula.");
            return;
        }

        Aulas nuevosDatos = view.pedirDatosParaActualizar();
        nuevosDatos.setId_aula(id);

        boolean ok = facade.actualizarAulas(nuevosDatos);

        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
    }

    private void eliminar() {
        int id = view.pedirId();

        boolean ok = facade.eliminarAulas(id);

        view.mostrarMensaje(ok ? "Eliminado correctamente." : "Error al eliminar.");
    }
}
