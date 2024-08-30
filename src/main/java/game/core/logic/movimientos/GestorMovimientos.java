package game.core.logic.movimientos;

import game.core.logic.Fichas;
import game.core.logic.tablero.Tablero;
import lombok.Getter;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GestorMovimientos {
    private final Tablero tablero;
    @Getter
    private final MovimientoResultado movimientoResultado; // Aquí me dice los movimientos válidos y los enemigos

    public GestorMovimientos(Tablero tablero) {
        this.tablero = tablero;
        movimientoResultado = new MovimientoResultado(); // como solo se inicializa una vez podemos llamarlo ene l constructor sin necesidad de un singleton
    }

    public synchronized void setFicha(Point coordenadaInicial, Point coordenadaFinal, Fichas ficha) {
        //Iniciales
        int filaInicial = coordenadaInicial.x; // Los X son las filas
        int columnaInicial = coordenadaInicial.y; // Las Y son las columnas
        // Finales
        int filaFinal = coordenadaFinal.x, columnaFinal = coordenadaFinal.y;
        var casilla = tablero.getTablero()[filaFinal][columnaFinal];
        /*Condición para verificar si se puede mover a donde es, primero es sacar
         * la coordenada, luego, tenemos los posibles movimientos, solo los alargamos
         * menos al caballo, además, falta la de matar, asi que haremos privates para hacer el cambio
         * y la validación si hay alguna ficha por ahí.
         */
        if (!verificarPosicionFinal(coordenadaFinal)) {
            return; // mirar esto
        }
        if (casilla != null) {
            if (Fichas.getFichaManejable().getEnemigo() == casilla.getColor()) {
                tablero.getTablero()[filaInicial][columnaInicial] = null;
                tablero.getTablero()[filaFinal][columnaFinal] = ficha;
                tablero.setEstado(true); // me identifica si ha cambiado o no
                notifyAll(); // notifica al hilo que espera
                movimientoResultado.reiniciar();
                return;
            }
            movimientoResultado.reiniciar();
            return;
        }

        tablero.getTablero()[filaInicial][columnaInicial] = null;
        tablero.getTablero()[filaFinal][columnaFinal] = ficha;
        // apartado de hilos
        tablero.setEstado(true); // me identifica si ha cambiado o no
        notifyAll(); // notifica al hilo que espera
        movimientoResultado.reiniciar();

    }

    private boolean verificarPosicionFinal(Point coordenadaFinal) {
        var validMov = movimientoResultado.getMovimientosValidos();
        var enemigo = movimientoResultado.getEnemigos();
        return validMov.contains(coordenadaFinal) || enemigo.contains(coordenadaFinal);

    }

    public void movimientos_y_enemigosPosibles(Point coordenadaInicial, Fichas ficha) {
        Set<Point> puntosValidos = new HashSet<>(), puntosEnemigos = new HashSet<>();
        int filaInicial = coordenadaInicial.x, columnaInicial = coordenadaInicial.y;
        // Ahora nos pasan son las direcciones el ficha.movimiento
        for (Point dir : ficha.movimiento()) {
            // Ahora a cada una de las direcciones vamos a reproducirlas 7 veces por maximos:  - Aunque debería de ser 6
            for (int i = 1; i < 8; i++) {
                int filaUnitaria = dir.x, columnaUnitaria = dir.y;
                int fila = filaInicial + (filaUnitaria * i);
                int columna = columnaInicial + (columnaUnitaria * i);
                // verificamos la suma:
                if (fila < 0 || fila > 7 || columna < 0 || columna > 7) {
                    //significa que está fuera de los límites, asi que solo cambiara de punto:
                    break;
                }
                //si sigue entonces miramos si hay una ficha
                if (tablero.getTablero()[fila][columna] != null) {
                    puntosEnemigos.add(new Point(fila, columna)); // añadimos el punto enemigo
                    break; // Como hay ficha entonces rompemos, aunque aquí podríamos aprovechar para mandar a ENEMIGO
                }
                // como paso todas las restricciones entonces: lo añadiremos y miraremos de nuevo
                puntosValidos.add(new Point(fila, columna));
            }
        }
        // Al final los pondremos en MovimientoResultados
        movimientoResultado.setMovimientosValidos(puntosValidos);
        movimientoResultado.setEnemigos(puntosEnemigos);
    }

    public synchronized void esperarCambio() throws InterruptedException {
        while (!tablero.getEstado()) {
            wait(); // Espera hasta que haya un cambio en el tablero
        }
        tablero.setEstado(false); // Restablece el estado
    }

}
