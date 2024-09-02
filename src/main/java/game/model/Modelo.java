package game.model;

import game.core.logic.tablero.Tablero;
import game.ui.view.juego.*;
import game.ui.render.RenderTablero;
import game.util.Observable;
import game.util.posicionamiento.ObservableMovimientos;

public class Modelo {

    //Cremoas un singleton de un observer
    private static Observable o_Movimiento;
    // creamos las vistas
    private Ventana ventana;
    private JuegoVista juegoVista;
    //Apartado de logica
    private Tablero tablero;
    // RENDER
    private RenderTablero renderTablero;

    // Observer:
    public static Observable getO_Movimiento() {
        if (o_Movimiento == null) {
            o_Movimiento = new ObservableMovimientos();
        }
        return o_Movimiento;
    }


    // Getters - Lógica
    public Tablero getTablero() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }

    // Visual
    public Ventana getVentana() {
        if (ventana == null) {
            ventana = new Ventana();
        }
        return ventana;
    }

    public JuegoVista getJuegoVista() {
        if (juegoVista == null) {
            juegoVista = new JuegoVista(this);
        }
        return juegoVista;
    }
    //  Render

    public RenderTablero getRenderTablero() {
        if (renderTablero == null) {
            renderTablero = new RenderTablero(this);
        }
        return renderTablero;
    }

    //Lo que es los métodos.
    public void start() {
        //Iniciamos la parte visual
        getVentana().add(getJuegoVista()); // Metemos a la ventana
        getVentana().pack();
        getVentana().setLocationRelativeTo(null); // para centrarlo
        // Luego la lógica
        getTablero(); // Llamamos al tablero de una vez e inicializamos
        getRenderTablero().start();
    }


}
