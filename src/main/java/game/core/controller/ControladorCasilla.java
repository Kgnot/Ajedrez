package game.core.controller;

import game.core.logic.Fichas;
import game.core.logic.movimientos.GestorMovimientos;
import game.core.logic.tablero.Tablero;
import  game.ui.view.juego.tab.Casilla;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        switch (e.getButton()) {
            case 1:
                setPInicial(seleccionar());
                System.out.println(getPInicial()
                        + " \n" + casilla.getTablero().getModelo().getFicha()
                );
                break;
            case 3:
                System.out.println(getPInicial()
                        + " \n" + casilla.getTablero().getModelo().getFicha()
                );
                posicionar(getPInicial());
                System.out.println("------------------TABLERO---------------");
                getTablero().tableroToString();
                 System.out.println("-------------------------------------");
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

    private Point seleccionar() {
        int fila = (Integer) casilla.getClientProperty("fila");
        int columna = (Integer) casilla.getClientProperty("columna");
        Fichas fichaSeleccionada = getTablero().getTablero()[fila][columna];
        setFicha(fichaSeleccionada);
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



    private GestorMovimientos getGestor(){
        return getTablero().getGestorMovimientosAjedrez();
    }
    private Tablero getTablero(){
        return casilla.getTablero().getModelo().getTablero();
    }

    private Fichas getFicha() {
        return casilla.getTablero().getModelo().getFicha();
    }

    private void setFicha(Fichas item) {
        casilla.getTablero().getModelo().setFicha(item);
    }

    private Point getPInicial() {
        return casilla.getTablero().getPInicial();
    }

    private void setPInicial(Point pInicial) {
        casilla.getTablero().setPInicial(pInicial);
    }


}
