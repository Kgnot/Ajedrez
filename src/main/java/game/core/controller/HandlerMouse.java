package game.core.controller;

import game.ui.extra.Entity;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HandlerMouse implements MouseListener, MouseMotionListener {

    private Entity entidad;
    private Point initialClick;

    public HandlerMouse(Entity entidad){
        this.entidad = entidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
        System.out.println("fila: "+entidad.getCasillaInicial().x);
        System.out.println("columna: "+entidad.getCasillaInicial().y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        initialClick = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Donde esta el mouse? donde cayó?
        int tam = entidad.getWidth(), columnaFinal = entidad.getLocation().x+(tam/2), filaFinal = entidad.getLocation().y+(tam/2);
        Point puntoFinal = new Point(filaFinal,columnaFinal);
        Point casillaInicial = entidad.getCasillaInicial();
        // Donde cayó ?
        int casillaFila = (filaFinal/tam), casillaColumna = (columnaFinal/tam);
        Point casillaFinal = new Point(casillaFila,casillaColumna);
        entidad.setCasillaFinal(new Point(casillaFila,casillaColumna)); // mandamos el punto final de mientras
        if(entidad.getO().update()){
            entidad.setCasillaInicial(casillaFinal); //el Inicial se vuelve el final
            entidad.setLocation(new Point(casillaFinal.y*tam,casillaFinal.x*tam)); // y lo ubica ahi
            entidad.getParent().setComponentZOrder(entidad,0);
        }
        else{
            entidad.setCasillaFinal(new Point(0,0)); // mandamos el punto final al inicio
            entidad.setLocation(new Point(casillaInicial.y*tam,casillaInicial.x*tam)); // y lo ubica ahi
            //entidad.getParent().setComponentZOrder(entidad,0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(initialClick == null) return;

        // Calcula la diferencia de posición
        int dx = e.getX() - initialClick.x;
        int dy = e.getY() - initialClick.y;

        // Calcula la nueva posición
        int newX = entidad.getX() + dx;
        int newY = entidad.getY() + dy;

        // Establece la nueva ubicación del componente
        entidad.setLocation(newX, newY);

    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
