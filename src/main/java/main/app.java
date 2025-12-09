package main;

import javax.swing.UnsupportedLookAndFeelException;
import view.formLogin;

/**
 *
 * @author USER
 */
public class app {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instanciar la vista
                formLogin view = new formLogin();

                // Instanciar el controlador y pasarle la vista
                //Controlador miControlador = new Controlador(view);
                // Hacer visible la ventana
                view.setVisible(true);
            }
        });
    }
}
