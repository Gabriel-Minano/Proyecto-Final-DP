package patterns.Strategy;

import controller.AlumnosController;

public class ModuloAlumnosStrategy implements IModuloStrategy {

    private final AlumnosController controller;

    public ModuloAlumnosStrategy(AlumnosController controller) {
        this.controller = controller;
        System.out.println("Iniciando ModuloAlumnosStrategy");
    }

    @Override
    public void iniciar() {
        controller.iniciar();
    }

}
