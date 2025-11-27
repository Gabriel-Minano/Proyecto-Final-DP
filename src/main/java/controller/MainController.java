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

public class MainController {

    private final MainView mainView;
    private final Map<Integer, IModuloStrategy> estrategias = new HashMap<>();

    public MainController(MainView mainView) {
        this.mainView = mainView;

        //Estrategias
        estrategias.put(1, new ModuloAdministradorStrategy());
        estrategias.put(2, new ModuloProfesoresStrategy());
        estrategias.put(3, new ModuloAlumnosStrategy());
        estrategias.put(4, new ModuloAulasStrategy());
        estrategias.put(5, new ModuloAula_profesorStrategy());
    }

    public void iniciar() {

        while (true) {
            int opcion = mainView.mostrarMenuPrincipal();
            if (opcion == 0) {
                System.out.println("Saliendo...");
                return;
            }

            IModuloStrategy estrategia = estrategias.get(opcion);

            if (estrategia != null) {
                estrategia.iniciar();
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

}
