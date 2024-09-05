package game.model;

import game.core.logic.builder.BuildTableroAjedrezBlancas;
import game.core.logic.builder.BuildTableroAjedrezNegras;
import game.core.logic.builder.BuilderTablero;
import game.core.logic.builder.DirectorTablero;
import game.core.logic.tablero.Tablero;
import game.network.Cliente;
import game.ui.view.juego.*;
import game.ui.render.RenderTablero;
import lombok.Getter;

import java.awt.*;

public class Modelo {
    //Creamos la Conexión
    private Cliente cliente;
    // creamos las vistas
    private Ventana ventana;
    private JuegoVista juegoVista;
    //Apartado de logica
    @Getter
    private Tablero tablero;
    // RENDER
    private RenderTablero renderTablero;

    // Visual
    public Ventana getVentana() {
        if (ventana == null) {
            ventana = new Ventana();
        }
        return ventana;
    }


    // Parte de conexión
    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente(this);
        }
        return cliente;
    }

    // Parte del juego y sus vistas
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
    public  void start() {
        getVentana().add(getJuegoVista()); // Metemos a la ventana del videojuego
        getVentana().pack();
        getVentana().setLocationRelativeTo(null);
    }
    public  void inicioJuego(int inicioLado) {
        // Luego la lógica
        BuilderTablero builder;
        switch (inicioLado) {
            case 1 -> {
                builder = new BuildTableroAjedrezBlancas(); // Iniciamos el tablero de ajedrez -> para negras o para blancas, depende e la perspectiva de la persona
            }
            default -> {
                builder = new BuildTableroAjedrezNegras(); // Iniciamos el tablero de ajedrez -> para negras o para blancas, depende e la perspectiva de la persona
            }
        }
        DirectorTablero director = new DirectorTablero(builder);
        tablero = director.construirTablero(); // Creamos el tablero
        // render
        getRenderTablero().start();
    }
}
