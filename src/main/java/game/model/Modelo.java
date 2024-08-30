package game.model;

import game.core.logic.Fichas;
import game.core.logic.tablero.Tablero;
import game.ui.view.juego.*;
import game.render.RenderTablero;

public class Modelo {

    // creamos las vistas
    private Ventana ventana;
    private JuegoVista juegoVista;
    //Apartado de logica
    private Tablero tablero;
    private Fichas fichaManejable; // la ficha que manejaré.
    // RENDER
    private RenderTablero renderTablero;

    // Getters - Lógica
    public Tablero getTablero() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }
    public Fichas getFicha(){
        return fichaManejable;
    }

    public void setFicha(Fichas fichaSeleccionada){
        fichaManejable  = fichaSeleccionada;
    }
    // Visual
    public Ventana getVentana() {
        if (ventana == null) {
            ventana = new Ventana();
        }
        return ventana;
    }

    public JuegoVista getJuegoVista(){
        if(juegoVista == null){
            juegoVista = new JuegoVista(this);
        }
        return juegoVista;
    }
    //  Render

    public RenderTablero getRenderTablero(){
        if(renderTablero == null){
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
