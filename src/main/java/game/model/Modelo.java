package game.model;

import game.core.logic.builder.BuildTableroAjedrez;
import game.core.logic.builder.BuilderTablero;
import game.core.logic.builder.DirectorTablero;
import game.core.logic.tablero.Tablero;
import game.network.Cliente;
import game.ui.view.juego.*;
import game.ui.render.RenderTablero;
import lombok.Getter;

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

    public Cliente getCliente(){
        if(cliente == null){
            cliente = new Cliente();
        }
        return cliente;
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
        DirectorTablero director = new DirectorTablero(builder);
        tablero = director.construirTablero();
        // Conexion:
        getCliente();
        // render
        getRenderTablero().start();
    }


}
