package controller;

import model.Alumnos;
import patterns.Facade.IFacade;
import view.formMenu;

public class AlumnosController {

    private final formMenu view;
    private final IFacade<Alumnos> facade;

    public AlumnosController(formMenu view, IFacade<Alumnos> facade) {
        this.view = view;
        this.facade = facade;
        this.view.onListarAlumnos(() -> listar());
        this.view.onBuscarAlumno(() -> buscar());
        this.view.onRegistrarAlumno(() -> crear());
        this.view.onActualizarAlumnos(() -> actualizar());
        this.view.onEliminarAlumno(() -> eliminar());
        System.out.println("Iniciando AlumnosController");
    }

    public void iniciar() {
        listar();
        /*
        A futuro se puede añadir a este método para que inicie una vista específica
         */
    }

    public void crear() {
        Alumnos a = view.pedirDatosAlumno();
        if (a == null) {
            view.mostrarMensaje("Solo se puede dejar en blanco el segundo nombre, por favor ingrese los demás datos");
            return;
        }
        boolean ok = facade.crearEntidad(a);
        view.mostrarMensaje(ok ? "Alumno ingresado." : "Error al ingresar, revise los datos.");
        listar();
    }

    public void buscar() {
        int id = view.pedirID();
        Alumnos actual = facade.verEntidad(id);
        if (id == 0) {
            return;
        }
        if (actual == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        view.mostrarAlumno(actual);
    }

    public void listar() {
        view.mostrarListaAlumno(facade.listarEntidades());
    }

    public void actualizar() {
        //Recordar que automáticamente se setea 0
        int id = view.pedirID();
        Alumnos actual = facade.verEntidad(id);
        //Si el seteo es 0, el pedirID lanzará un mensaje y en controlador terminará
        //La ejecución rollback
        if (id == 0) {
            return;
        }
        if (actual == null) {
            view.mostrarMensaje("Esa ID no existe");
            return;
        }
        Alumnos nuevosDatos = view.pedirDatosAlumno();
        if (nuevosDatos == null) {
            view.mostrarMensaje("Solo se puede dejar en blanco el segundo nombre, por favor ingrese los demás datos");
            return;
        }
        nuevosDatos.setId_alumno(id);

        boolean ok = facade.actualizarEntidad(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar. Puede que falten datos");
        view.mostrarAlumno(nuevosDatos);
    }

    public void eliminar() {
        int id = view.pedirID();
        Alumnos actual = facade.verEntidad(id);
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
            view.mostrarMensaje(ok ? "Registro eliminado" : "Error al eliminar");
        } else {
            view.mostrarMensaje("Eliminación cancelada");
        }
        listar();
    }
}
/*
Notas adicionales
Al usar this en lugar de null para los parents hace que el mensaje se centre con respecto
a la ventana y no a la pantalla.

Explorar la posibilidad de modificar el método buscar para que acepte un parámetro ID para aplicar recursividad.

Revisar porque se crean dos instancias de ConexionMySQL
Revisar porque se crean instancias de AlumnosController

 */
