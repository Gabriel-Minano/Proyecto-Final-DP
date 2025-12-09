package controller;

import dao.AlumnosDAO;
import dao.Aula_profesorDAO;
import dao.AulasDAO;
import dao.IBaseDAO;
import dao.ProfesoresDAO;
import java.util.HashMap;
import java.util.Map;
import model.Alumnos;
import model.Aula_profesor;
import model.Aulas;
import model.Profesores;
import patterns.Facade.AlumnosFacade;
import patterns.Facade.Aula_profesorFacade;
import patterns.Facade.AulasFacade;
import patterns.Facade.IFacade;
import patterns.Facade.ProfesoresFacade;
import patterns.Proxy.SecureDAOProxy;
import patterns.Strategy.IModuloStrategy;
import patterns.Strategy.ModuloAdministradorStrategy;
import patterns.Strategy.ModuloAlumnosStrategy;
import patterns.Strategy.ModuloAulasStrategy;
import patterns.Strategy.ModuloProfesoresStrategy;
import patterns.Strategy.ModuloAula_profesorStrategy;
import view.formMenu;

public class MainController {

    private final formMenu mainView;
    private final Map<Integer, IModuloStrategy> estrategias = new HashMap<>();
    private final AlumnosController alumnosController;
    private final ProfesoresController profesoresController;
    private final AulasController aulasController;
    private final Aula_profesorController asignacionesController;
    // private final AulasController aulasController;
    //private final Aula_profesorController aulaProfesorController;

    //Este MainController es instanciado por el formMenu
    public MainController(formMenu mainView) {
        System.out.println("Iniciando modulo MainController");
        this.mainView = mainView;
        // DAOs y facades
        IBaseDAO<Alumnos> daoAlumnos = new SecureDAOProxy<>(new AlumnosDAO());
        IFacade<Alumnos> facadeAlumnos = new AlumnosFacade(daoAlumnos);
        IBaseDAO<Profesores> daoProfesores = new SecureDAOProxy<>(new ProfesoresDAO());
        IFacade<Profesores> facadeProfesores = new ProfesoresFacade(daoProfesores);
        IBaseDAO<Aulas> daoAulas = new SecureDAOProxy<>(new AulasDAO());
        IFacade<Aulas> facadeAulas = new AulasFacade(daoAulas);
        IBaseDAO<Aula_profesor> daoAsignaciones = new SecureDAOProxy<>(new Aula_profesorDAO());
        IFacade<Aula_profesor> facadeAsignaciones = new Aula_profesorFacade(daoAsignaciones);
        // Controllers (se crean UNA sola vez)
        this.alumnosController = new AlumnosController(mainView, facadeAlumnos);
        this.profesoresController = new ProfesoresController(mainView, facadeProfesores);
        this.aulasController = new AulasController(mainView, facadeAulas);
        this.asignacionesController = new Aula_profesorController(mainView, facadeAsignaciones);
        //Estrategias
        estrategias.put(1, new ModuloAdministradorStrategy());
        estrategias.put(2, new ModuloProfesoresStrategy(profesoresController));
        estrategias.put(3, new ModuloAlumnosStrategy(alumnosController));
        estrategias.put(4, new ModuloAulasStrategy(aulasController));
        estrategias.put(5, new ModuloAula_profesorStrategy(asignacionesController));
    }

    public void iniciar(int opcion) {

        IModuloStrategy estrategia = estrategias.get(opcion);

        if (estrategia != null) {
            estrategia.iniciar();
        }
    }
}
