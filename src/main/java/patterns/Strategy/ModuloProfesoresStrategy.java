package patterns.Strategy;

import controller.ProfesoresController;

public class ModuloProfesoresStrategy implements IModuloStrategy {
    private final ProfesoresController controller;
    public ModuloProfesoresStrategy(ProfesoresController controller) {
        this.controller = controller;
        System.out.println("Iniciando ModuloProfesoresStrategy");
    }

    @Override
    public void iniciar() {

        controller.iniciar();
    }

}
