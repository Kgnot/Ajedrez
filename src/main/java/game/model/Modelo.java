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

public class Modelo {
    public int inicioLado;

    //Creamos la Conexión
    private Cliente cliente;
    // creamos las vistas
    private Ventana ventana;
    private JuegoVista juegoVista;
    private EleccionLado vistaElect;
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

    public EleccionLado getVistaElect() {
        if (vistaElect == null) {
            vistaElect = new EleccionLado(this);
        }
        return vistaElect;
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
    public synchronized void start() throws InterruptedException {
        inicioLado = 0;
        //Iniciamos la parte visual
        getVentana().add(getVistaElect());
        getVentana().pack();
        getVentana().setLocationRelativeTo(null); // para centrarlo
        while(inicioLado == 0) {
            wait();
        }
        inicioJuego();
    }

private void inicioJuego(){
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
    tablero = director.construirTablero();
    getVentana().add(getJuegoVista()); // Metemos a la ventana del videojuego
    // Conexion:
    getCliente();
    // render
    getRenderTablero().start();
}
}
