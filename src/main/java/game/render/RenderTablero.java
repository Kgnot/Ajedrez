package game.render;

import game.core.logic.movimientos.GestorMovimientos;
import game.core.logic.tablero.Tablero;
import game.model.Modelo;
import game.ui.view.juego.tab.TableroV;

public class RenderTablero extends Thread {
    private final Modelo modelo;

    public RenderTablero(Modelo modelo) {
        this.modelo = modelo;
    }

    private void dibujar() {
        var tablero = modelo.getTablero();
        var vistaTablero = modelo.getJuegoVista().getVistaTablero();

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
        var gm = modelo.getTablero().getGestorMovimientosAjedrez();
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
