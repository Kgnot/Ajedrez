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
        switch (ficha.getTipo())
        {
            case PEON -> movimientoResultado.movimientoPeon(coordenadaInicial,ficha,tablero);
            case CABALLO -> movimientoResultado.movimientoCaballo(coordenadaInicial,ficha,tablero);
            default -> movimientoResultado.movimientoGeneral(coordenadaInicial,ficha,tablero);
        }
    }

    public synchronized void esperarCambio() throws InterruptedException {
        while (!tablero.getEstado()) {
            wait(); // Espera hasta que haya un cambio en el tablero
        }
        tablero.setEstado(false); // Restablece el estado
    }

}
