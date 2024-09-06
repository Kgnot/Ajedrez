package game.core.controller;

import game.core.logic.movimientos.GestorMovimientos;
import game.core.logic.tablero.Tablero;
import game.network.Cliente;
import game.ui.extra.Entity;
import game.ui.view.juego.tab.*;
import game.util.CipherUtility;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;

public class HandlerMouse implements MouseListener, MouseMotionListener {

    private final Entity entidad;
    private Point initialClick;
    private ArrayList<Casilla> afectadas;

    public HandlerMouse(Entity entidad) {
        this.entidad = entidad;
        afectadas = new ArrayList<>();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Pero");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        initialClick = e.getPoint();
        // En mouse pressed vamos a cambiarle la imagen
        entidad.estadoSelect();
        TableroV tablero = (TableroV) entidad.getParent();
        getGestorMovimientos().movimientos_y_enemigosPosibles(entidad.getCasillaInicial());
        var mov = getGestorMovimientos().getMovimientoResultado();
        var validos = mov.getMovimientosValidos();
        var enemigos = mov.getEnemigos();

        for(Point p : validos){
            tablero.getCasillas()[p.x][p.y].select();
            afectadas.add(tablero.getCasillas()[p.x][p.y]);
        }
        for(Point p : enemigos){
            tablero.getCasillas()[p.x][p.y].muerte();
            afectadas.add(tablero.getCasillas()[p.x][p.y]);

        }
        mov.reiniciar();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(Casilla c : afectadas){
            c.volverInicial();
        }
        afectadas.clear();
        // Luego de limpiar las afectadas
        entidad.estadoOriginal(); // lo devolvemos al estado original
        int tam = entidad.getWidth(), xFinal = entidad.getLocation().x + (tam / 2), yFinal = entidad.getLocation().y + (tam / 2);
        Point casillaInicial = entidad.getCasillaInicial();
        // ¿Dónde cayó?
        int casillaFila = (yFinal / tam), casillaColumna = (xFinal / tam);
        Point casillaFinal = new Point(casillaFila, casillaColumna);
        if(Objects.equals(casillaInicial, casillaFinal)){
            entidad.setCasillaFinal(new Point(0, 0)); // mandamos el punto final al inicio
            entidad.setLocation(new Point(casillaInicial.y * tam, casillaInicial.x * tam));
            return;
        }
        entidad.setCasillaFinal(new Point(casillaFila, casillaColumna)); // mandamos el punto final de mientras
        // Aquí hace la verificación:
        var gestor = getTablero().getGestorMovimientosAjedrez(); // Obtenemos el gestor de movimientos
        if (gestor.setFicha(casillaInicial, casillaFinal)) {
            entidad.setCasillaInicial(casillaFinal); //el Inicial se vuelve el final
            entidad.setLocation(new Point(casillaFinal.y * tam, casillaFinal.x * tam)); // y lo ubica ahi
            entidad.getParent().setComponentZOrder(entidad, 0);
            getCliente().enviar(CipherUtility.getInstance().encryptMensajeFicha
                    (casillaInicial, casillaFinal));
            return;
        }
        entidad.setCasillaFinal(new Point(0, 0)); // mandamos el punto final al inicio
        entidad.setLocation(new Point(casillaInicial.y * tam, casillaInicial.x * tam));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (initialClick == null) return;

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

    private Tablero getTablero() {
        var modelo = (TableroV) entidad.getParent();
        return modelo.getModelo().getTablero();
    }

    private Cliente getCliente() {
        var modelo = (TableroV) entidad.getParent();

        return modelo.getModelo().getCliente();
    }

    private GestorMovimientos getGestorMovimientos(){
        return  getTablero().getGestorMovimientosAjedrez();
    }

}
