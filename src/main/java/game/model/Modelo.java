package game.model;

import game.core.logic.tablero.BuildTableroAjedrez;
import game.core.logic.tablero.BuilderTablero;
import game.core.logic.tablero.Director;
import game.core.logic.tablero.Tablero;
import game.ui.view.juego.*;
import game.ui.render.RenderTablero;
import lombok.Getter;

public class Modelo {

    //Cremoas un singleton de un observer
    // creamos las vistas
    private Ventana ventana;
    private JuegoVista juegoVista;
    //Apartado de logica
    @Getter
    private Tablero tablero;
    // RENDER
    private RenderTablero renderTablero;

    // Getters - Lógica
//    public Tablero getTablero() {
//        if (tablero == null) {
//            tablero = new Tablero();
//        }
//        return tablero;
//    }

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
        BuilderTablero builder = new BuildTableroAjedrez(); // Iniciamos el tablero de ajedrez
        Director director = new Director(builder);
        tablero = director.construirTablero();

        // render
        getRenderTablero().start();
    }


}
