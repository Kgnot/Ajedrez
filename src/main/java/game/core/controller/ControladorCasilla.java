package game.core.controller;

import game.core.logic.Fichas;
import game.core.logic.movimientos.GestorMovimientos;
import game.core.logic.tablero.Tablero;
import game.ui.view.juego.tab.Casilla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControladorCasilla implements MouseListener {

    private final Casilla casilla;

    public ControladorCasilla(Casilla casilla) {
        this.casilla = casilla;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        var color = casilla.getBackground();
        casilla.setBackground(color.darker()); // para el fondo lo hacemos más oscuro
        casilla.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // para el borde
    }

    @Override
    public void mouseExited(MouseEvent e) {
        var color = casilla.getBackground();
        casilla.setBackground(color.brighter());
        casilla.setBorder(null);
    }

}
