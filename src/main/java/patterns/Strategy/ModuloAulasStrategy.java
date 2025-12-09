package patterns.Strategy;

import controller.AulasController;

public class ModuloAulasStrategy implements IModuloStrategy {

    private final AulasController controller;

    public ModuloAulasStrategy(AulasController controller) {
        this.controller = controller;
        System.out.println("Iniciando ModuloAulasStrategy");
    }

    @Override
    public void iniciar() {

        controller.iniciar();
    }

}
