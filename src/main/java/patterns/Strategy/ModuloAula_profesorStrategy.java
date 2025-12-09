package patterns.Strategy;

import controller.Aula_profesorController;

public class ModuloAula_profesorStrategy implements IModuloStrategy {

    private final Aula_profesorController controller;

    public ModuloAula_profesorStrategy(Aula_profesorController controller) {
        this.controller = controller;
        System.out.println("Iniciando ModuloAula_ProfesorStrategy");
    }

    @Override
    public void iniciar() {
        controller.iniciar();
    }

}
