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
        casilla.setLocation(casilla.getPuntoInicial()); // Devuelve
        switch (e.getButton()) {
            case 1:
                casilla.setSeleccionado(true);
                setPInicial(seleccionar());
                break;
            case 3:
                posicionar(getPInicial());
                break;
            default:
                break;
        }
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

    private GestorMovimientos getGestor() {
        return getTablero().getGestorMovimientosAjedrez();
    }

    private Tablero getTablero() {
        return casilla.getTablero().getModelo().getTablero();
    }

    private Fichas getFicha() {
        return Fichas.getFichaManejable();
    }

    private void setFicha(Fichas item) {
        Fichas.setFichaManejable(item);
    }

    private Point getPInicial() {
        return casilla.getTablero().getPInicial();
    }

    private void setPInicial(Point pInicial) {
        casilla.getTablero().setPInicial(pInicial);
    }

    // Importantes:


    private Point seleccionar() {
        int fila = (Integer) casilla.getClientProperty("fila");
        int columna = (Integer) casilla.getClientProperty("columna");
        Fichas fichaSeleccionada = getTablero().getTablero()[fila][columna];
        setFicha(fichaSeleccionada);
        if (fichaSeleccionada == null) {
            return null;
        }
        getGestor().movimientos_y_enemigosPosibles(new Point(fila, columna), fichaSeleccionada);
        return new Point(fila, columna);
    }

    private void posicionar(Point coordenadaInicial) {
        if (coordenadaInicial == null) {
            return;
        }
        int fila = (Integer) casilla.getClientProperty("fila");
        int columna = (Integer) casilla.getClientProperty("columna");
        Point coordenadaFinal = new Point(fila, columna);
        getGestor().setFicha(coordenadaInicial, coordenadaFinal, getFicha()); ////////////////////////////////////////- se usa aca si algo
    }
}
