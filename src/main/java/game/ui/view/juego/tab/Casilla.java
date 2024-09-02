package game.ui.view.juego.tab;

import game.core.controller.ControladorCasilla;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Casilla extends JPanel {

    @Getter
    private final TableroV tablero; // las casillas necesitan meterse a algún modelo
    @Getter
    @Setter
    private boolean seleccionado;
    @Getter
    @Setter
    private Point puntoInicial;

    public Casilla(TableroV tablero) {
        ControladorCasilla controlador = new ControladorCasilla(this);
        this.tablero = tablero;
        seleccionado = false; // lo inicializamos falso
        addMouseListener(controlador);
    }


}
