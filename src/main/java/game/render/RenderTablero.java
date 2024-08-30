package game.render;

import game.core.logic.movimientos.GestorMovimientos;
import game.core.logic.tablero.Tablero;
import game.model.Modelo;
import game.ui.view.juego.tab.TableroV;

public class RenderTablero extends Thread {

    // private Modelo modelo;
    private final Tablero tablero; // Apartado de lógica
    private final TableroV vistaTablero; // apartado Visual
    private final GestorMovimientos gm;
    // Ahora los JPaneles que necesitamos:


    public RenderTablero(Modelo modelo) {
        //this.modelo = modelo;
        tablero = modelo.getTablero();
        vistaTablero = modelo.getJuegoVista().getVistaTablero(); // aquí inicializamos , pasando por "referencia"
        //obT = modelo.getTablero().getObservadorTablero();
        gm = modelo.getTablero().getGestorMovimientosAjedrez(); // Ponemos al gestor de movimientos
    }

    //private Tablero que se usa:


    private void dibujar() {
        RenderFichas rf = new RenderFichas();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.getTablero()[i][j] != null) {
                    var Tipo = tablero.getTablero()[i][j].getTipo();
                    var Color = tablero.getTablero()[i][j].getColor();
                    vistaTablero.getCuadros()[i][j].setImagen(rf.renderImage(Tipo, Color));
                } else {
                    vistaTablero.getCuadros()[i][j].setImagen("");
                }
            }
        }
    }


    @Override
    public void run() {
        // este debe ser un ciclo perpetuo mirando el tablero constante mente, entonces
        //
        dibujar();
        while (true) {
            try {
                gm.esperarCambio();
                dibujar();   // no supe xd, quisiera que alguien lo hiciera y me corrigiera xd
            } catch (InterruptedException ignore) {
            }
        }
    }
}
