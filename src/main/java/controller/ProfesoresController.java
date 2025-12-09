package controller;

import model.Profesores;
import patterns.Facade.IFacade;
import view.formMenu;

public class ProfesoresController {

    private final formMenu view;
    private final IFacade<Profesores> facade;

    public ProfesoresController(formMenu view, IFacade<Profesores> facade) {
        this.view = view;
        this.facade = facade;
        this.view.onRegistrarProfesor(() -> crear());
        this.view.onBuscarProfesor(() -> buscar());
        this.view.onListarProfesores(() -> listar());
        this.view.onActualizarProfesor(() -> actualizar());
        this.view.onEliminarProfesor(() -> eliminar());
        System.out.println("Iniciando profesoresController");
    }

    public void iniciar() {
        /*Al presionar el botón de Profesores listará automáticamente*/
        listar();
    }

    public void crear() {
        Profesores p = view.pedirDatosProfesor();
        if (p.getDni().isEmpty() || p.getPrimer_apellido().isEmpty() || p.getSegundo_apellido().isEmpty() || p.getPrimer_nombre().isEmpty() || p.getEspecialidad().isEmpty()) {
            view.mostrarMensaje("Solo se puede dejar en blanco el segundo nombre y segunda especialidad, porfavor ingrese los demás datos");
            return;
        }
        boolean ok = facade.crearEntidad(p);
        view.mostrarMensaje(ok ? "Profesor ingresado." : "Error al ingresar, revise los datos.");
        listar();
    }

    public void buscar() {
        int id = view.pedirID();
        Profesores actual = facade.verEntidad(id);
        if (id == 0) {
            return;
        }
        if (actual == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        view.mostrarProfesor(actual);
    }

    public void listar() {
        view.mostrarListaProfesor(facade.listarEntidades());
    }

    public void actualizar() {
        //Recordar que automáticamente se setea 0
        int id = view.pedirID();
        Profesores actual = facade.verEntidad(id);
        //Si el seteo es 0, el pedirID lanzará un mensaje y en controlador terminará
        //La ejecución rollback
        if (id == 0) {
            return;
        }
        if (actual == null) {
            view.mostrarMensaje("No existe el profesor");
            return;
        }
        Profesores nuevosDatos = view.pedirDatosProfesor();
        if (nuevosDatos == null) {
            view.mostrarMensaje("Solo se puede dejar en blanco el segundo nombre y segunda especialidad, porfavor ingrese los demás datos");
            return;
        }
        nuevosDatos.setId_profesor(id);
        boolean ok = facade.actualizarEntidad(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar puede que falten datos importantes.");
        view.mostrarProfesor(nuevosDatos);
    }

    public void eliminar() {
        int id = view.pedirID();
        Profesores actual = facade.verEntidad(id);
        if (id == 0) {
            return;
        }
        if (actual == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        boolean confirmar = view.confirmacion();
        if (confirmar) {
            boolean ok = facade.eliminarEntidad(id);
            view.mostrarMensaje(ok ? "Registro eliminado." : "Error al eliminar");
        } else {
            view.mostrarMensaje("Eliminación cancelada");
        }
        listar();
    }
}
