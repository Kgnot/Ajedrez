package game.logica;

import game.logica.fichas.Caballo;
import game.logica.util.Normalizar;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GestorMovimientos {


    private final Tablero tablero;

    public GestorMovimientos(Tablero tablero) {
        this.tablero = tablero;
    }

    public synchronized void setFicha(Point coordenadaInicial, Point coordenadaFinal, Fichas ficha) {
        //Iniciales
        int filaInicial = coordenadaInicial.x; // Los X son las filas
        int columnaInicial = coordenadaInicial.y; // Las Y son las columnas
        // Finales
        int filaFinal = coordenadaFinal.x;
        int columnaFinal = coordenadaFinal.y;

        /*Condición para verificar si se puede mover a donde es, primero es sacar
         * la coordenada, luego, tenemos los posibles movimientos, solo los alargamos
         * menos al caballo, además, falta la de matar, asi que haremos privates para hacer el cambio
         * y la validación si hay alguna ficha por ahí.
         */
        if (!validarMovimiento(coordenadaInicial, coordenadaFinal, ficha) || tablero.getTablero()[filaFinal][columnaFinal] != null) {
            return;
        }
        tablero.getTablero()[filaInicial][columnaInicial] = null;
        tablero.getTablero()[filaFinal][columnaFinal] = ficha;
        // apartado de hilos
        tablero.setEstado(true); // me identifica si ha cambiado o no
        notifyAll(); // notifica al hilo que espera
    }

    private boolean validarMovimiento(Point coordenadaInicial, Point coordenadaFinal, Fichas ficha) {
        // Tenemos los movimientos posibles :
        var puntos = puntosMovibles(coordenadaInicial, ficha);
        return puntos.contains(coordenadaFinal);

    }

    public Set<Point> puntosMovibles(Point coordenadaInicial, Fichas ficha) {
        Set<Point> puntosValidos = new HashSet<>();

        for (Point mov : ficha.movimiento()) {
            int moveFila = mov.x;
            int moveColumna = mov.y;
            var punto = new Point(coordenadaInicial.x + moveFila, coordenadaInicial.y + moveColumna);

            if ((punto.x < 0 || punto.x > 7) || (punto.y < 0 || punto.y > 7)) {
                continue;
            }

            if (tablero.getTablero()[punto.x][punto.y] != null) { // Si es una ficha -> entonces:
                // Normalizar y añadir todos los puntos a ignorar en esa dirección
                var normalizado = Normalizar.normalizar(mov);
                for (int i = 1; i < 8; i++) {
                    Point puntoIgnorar = new Point(punto.x + i * normalizado.x, punto.y + i * normalizado.y);
                    if (puntoIgnorar.x >= 0 && puntoIgnorar.x <= 7 && puntoIgnorar.y >= 0 && puntoIgnorar.y <= 7) {
                        puntosValidos.remove(puntoIgnorar);
                    }
                }
            } else {
                puntosValidos.add(punto);
            }
        }

        return puntosValidos;
    }


    public synchronized void esperarCambio() throws InterruptedException {
        while (!tablero.getEstado()) {
            wait(); // Espera hasta que haya un cambio en el tablero
        }
        tablero.setEstado(false); // Restablece el estado
    }

}
