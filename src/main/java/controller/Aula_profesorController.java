package controller;

import model.Aula_profesor;
import model.Aulas;
import model.Profesores;
import patterns.Facade.AulasFacade;
import patterns.Facade.IFacade;
import view.formMenu;

public class Aula_profesorController {

    private final formMenu view;
    private final IFacade<Aula_profesor> facade;

    public Aula_profesorController(formMenu view, IFacade<Aula_profesor> facade) {
        this.view = view;
        this.facade = facade;
        this.view.onRegistrarAsignacion(() -> crear());
        this.view.onBuscarAsignacion(() -> buscar());
        this.view.onListarAsignaciones(() -> listar());
        this.view.onActualizarAsignacion(() -> actualizar());
        this.view.onEliminarAsignacion(() -> eliminar());
        //this.view.onListar
    }

    public void iniciar() {
        listar();
    }

    private void crear() {
        Aula_profesor ap = view.pedirDatosAsignacion();
        if (ap == null) {
            view.mostrarMensaje("No puedes dejar campos en blanco, intente nuevamente ingresando datos");
            return;
        }

        //Antes de insertar el objeto entrará en un try-catch para analizar si no lanza excepción de que 
        //existan los datos para crear el correspondiente registro
        try {
            boolean ok = facade.crearEntidad(ap);
            view.mostrarMensaje(ok ? "Asignación creada" : "Error al crear, revise de que existan las ID");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al momento de insertar un registro, debido a que no existen las ID. Además,se canceló la inserción");
        }
    }

    private void buscar() {
        int id = view.pedirID();
        if (id == 0) {
            return;
        }
        Aula_profesor ap = facade.verEntidad(id);
        if (ap == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        view.mostrarAsignacion(ap);
    }

    private void listar() {
        view.mostrarListaAsignaciones(facade.listarEntidades());
    }

    private void actualizar() {
        int id = view.pedirID();
        if (id == 0) {
            return;
        }
        Aula_profesor actual = facade.verEntidad(id);
        if (actual == null) {
            return;
        }

        Aula_profesor nuevosDatos = view.pedirDatosAsignacion();
        if (nuevosDatos == null) {
            view.mostrarMensaje("No puedes dejar campos en blanco, intente nuevamente ingresando datos");
            return;
        }
        nuevosDatos.setId_asignacion(id);
        try {
            boolean ok = facade.actualizarEntidad(nuevosDatos);
            view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar.");
        } catch (Exception e) {
        }
    }

    private void eliminar() {
        int id = view.pedirID();
        if (id == 0) {
            return;
        }
        Aula_profesor actual = facade.verEntidad(id);
        if (actual == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        boolean confirmar = view.confirmacion();
        if (confirmar) {
            boolean ok = facade.eliminarEntidad(id);
            view.mostrarMensaje(ok ? "Registro eliminado" : "Error al eliminar");
        } else {
            view.mostrarMensaje("Eliminación cancelada");
        }
        listar();
    }
}
