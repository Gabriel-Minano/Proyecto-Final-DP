package controller;

import model.Aulas;
import patterns.Facade.IFacade;
import view.formMenu;

public class AulasController {
    
    private final formMenu view;
    private final IFacade<Aulas> facade;
    
    public AulasController(formMenu view, IFacade<Aulas> facade) {
        this.view = view;
        this.facade = facade;
        this.view.onRegistrarAula(() -> crear());
        this.view.onBuscarAula(() -> buscar());
        this.view.onListarAulas(() -> listar());
        this.view.onActualizarAula(() -> actualizar());
        this.view.onEliminarAula(() -> eliminar());
        System.out.println("Iniciando AulasController");
    }
    
    public void iniciar() {
        listar();
    }
    
    private void crear() {
        Aulas a = view.pedirDatosAula();
        if (a == null) {
            view.mostrarMensaje("No puedes dejar campos en blanco, intente nuevamente ingresando datos");
            return;
        }
        boolean ok = facade.crearEntidad(a);
        view.mostrarMensaje(ok ? "Aula ingresada" : "Error al ingresar, revise los datos");
    }
    
    private void buscar() {
        int id = view.pedirID();
        Aulas actual = facade.verEntidad(id);
        if (id == 0) {
            return;
        }
        if (actual == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        view.mostrarAula(actual);
    }
    
    public void listar() {
        view.mostrarListaAulas(facade.listarEntidades());
    }
    
    private void actualizar() {
        int id = view.pedirID();
        if (id == 0) {
            return;
        }
        Aulas actual = facade.verEntidad(id);
        if (actual == null) {
            view.mostrarMensaje("No existe el aula.");
            return;
        }
        
        Aulas nuevosDatos = view.pedirDatosAula();
        if (nuevosDatos == null) {
            view.mostrarMensaje("No puedes dejar campos en blanco, intente nuevamente ingresando datos");
            return;
        }
        nuevosDatos.setId_aula(id);
        
        boolean ok = facade.actualizarEntidad(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar. Puede que falten datos");
        view.mostrarAula(nuevosDatos);
    }
    
    private void eliminar() {
        int id = view.pedirID();
        if (id == 0) {
            return;
        }
        Aulas actual = facade.verEntidad(id);
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
