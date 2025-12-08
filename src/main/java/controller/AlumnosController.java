package controller;

import model.Alumnos;
import patterns.Facade.IFacade;
import view.AlumnosView;
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

        /* switch (opcion) {
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
            default ->
                System.out.println("");
            //view.mostrarMensaje("Opción inválida");
        }*/
        System.out.println("");
    }
    
    public void crear() {
        Alumnos a = view.pedirDatosAlumno();
        if (a.getDni().isEmpty() || a.getPrimer_apellido().isEmpty() || a.getSegundo_apellido().isEmpty() || a.getPrimer_nombre().isEmpty() || a.getId_aula() == 0) {
            view.mostrarMensaje("No se admiten demasiados campos vacíos");
            return;
        }
        boolean ok = facade.crearEntidad(a);
        view.mostrarMensaje(ok ? "Se ingresaron correctamente los datos" : "Error al ingresar datos, puede que haya datos duplicados o que pusieras una ID con decimales");
        
    }
    
    public void buscar() {
        try {
            int id = view.pedirID();
            Alumnos a = facade.verEntidad(id);
            
            view.mostrarAlumno(a);
        } catch (Exception e) {
            System.out.println("No existe esa ID: " + e.getMessage());
        }
        
    }
    
    public void listar() {
        view.mostrarLista(facade.listarEntidades());
    }
    
    public void actualizar() {
        int id = view.pedirID();
        Alumnos actual = facade.verEntidad(id);
        if (actual == null || actual.getId_alumno() == 0) {
            
            return;
        }
        Alumnos nuevosDatos = view.pedirDatosAlumno();
        nuevosDatos.setId_alumno(id);
        
        boolean ok = facade.actualizarEntidad(nuevosDatos);
        view.mostrarMensaje(ok ? "Actualizado correctamente." : "No se pudo actualizar. Puede que falten datos");
        view.mostrarAlumno(nuevosDatos);
    }
    
    public void eliminar() {
        int id = view.pedirID();
        if (id==0) {
            return;
        }
        boolean confirmar = view.confirmacion();
        if (confirmar) {
            boolean ok = facade.eliminarEntidad(id);
            view.mostrarMensaje("Registro eliminado");
        } else {
            view.mostrarMensaje("Eliminación cancelada");
        }       
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