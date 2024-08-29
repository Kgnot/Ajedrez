package game.presentacion.vistas.render;

import game.logica.GestorMovimientos;
import game.logica.ObservadorTablero;
import game.logica.Tablero;
import game.presentacion.Modelo;
import game.presentacion.vistas.juego.tab.TableroV;

public class RenderTablero extends Thread {

    // private Modelo modelo;
    private final Tablero tablero; // Apartado de lógica
    private final TableroV vistaTablero; // apartado Visual
    private final ObservadorTablero obT;
    private final GestorMovimientos gm;
    // Ahora los JPaneles que necesitamos:


    public RenderTablero(Modelo modelo) {
        //this.modelo = modelo;
        tablero = modelo.getTablero();
        vistaTablero = modelo.getJuegoVista().getVistaTablero(); // aquí inicializamos todo, pasando por "referencia"
        obT = modelo.getObT();
        gm = modelo.getGestor();
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
