package controller;

import java.util.HashMap;
import java.util.Map;
import patterns.Strategy.IModuloStrategy;
import patterns.Strategy.ModuloAdministradorStrategy;
import patterns.Strategy.ModuloAlumnosStrategy;
import patterns.Strategy.ModuloAulasStrategy;
import patterns.Strategy.ModuloProfesoresStrategy;
import patterns.Strategy.ModuloAula_profesorStrategy;
import view.MainView;
import view.formMenu;

public class MainController {

    private final formMenu mainView;
    private final Map<Integer, IModuloStrategy> estrategias = new HashMap<>();

    public MainController(formMenu mainView) {
        this.mainView = mainView;

        //Estrategias
        estrategias.put(1, new ModuloAdministradorStrategy());
        estrategias.put(2, new ModuloProfesoresStrategy());
        estrategias.put(3, new ModuloAlumnosStrategy());
        estrategias.put(4, new ModuloAulasStrategy());
        estrategias.put(5, new ModuloAula_profesorStrategy());
        System.out.println("Iniciando módulo MainController");
    }

    public void iniciar(int opcion) {

        IModuloStrategy estrategia = estrategias.get(opcion);

        if (estrategia != null) {
            estrategia.iniciar();
        }
    }
}
