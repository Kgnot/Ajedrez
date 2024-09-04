package game.core.logic.movimientos;

import game.core.logic.Fichas;
import game.core.logic.tablero.Tablero;
import lombok.Getter;

import java.awt.*;

public class GestorMovimientos {
    private final Tablero tablero;
    @Getter
    private final MovimientoResultado movimientoResultado; // Aquí me dice los movimientos válidos y los enemigos

    public GestorMovimientos(Tablero tablero) {
        this.tablero = tablero;
        movimientoResultado = new MovimientoResultado(); // como solo se inicializa una vez podemos llamarlo ene l constructor sin necesidad de un singleton
    }

    public synchronized boolean setFicha(Point casillaInicial, Point casillaFinal) {
        // Primero miramos los puntos válidos y de enemigos:
        //Iniciales
        int filaInicial = casillaInicial.x; // Los X son las filas
        int columnaInicial = casillaInicial.y; // Las Y son las columnas
        Fichas ficha = tablero.getTablero()[filaInicial][columnaInicial];
        movimientos_y_enemigosPosibles(casillaInicial,ficha);

        // Finales
        int filaFinal = casillaFinal.x, columnaFinal = casillaFinal.y;
        var casilla = tablero.getTablero()[filaFinal][columnaFinal];
        // Verificación
        if (!verificarPosicionFinal(casillaFinal)) {
            System.out.println("es falso por coordenada final");
            return false; // mirar esto
        }
        if (casilla != null) {
            if (ficha.getEnemigo() == casilla.getColor()) { // Para matar al enemigo
                tablero.getTablero()[filaInicial][columnaInicial] = null;
                tablero.getTablero()[filaFinal][columnaFinal] = ficha;

                tablero.setEstado(true); // me identifica si ha cambiado o no
                notifyAll(); // notifica al hilo que espera
                movimientoResultado.reiniciar();
                return true;
            }
            movimientoResultado.reiniciar();
            return false;
        }

        tablero.getTablero()[filaInicial][columnaInicial] = null;
        tablero.getTablero()[filaFinal][columnaFinal] = ficha;
        // apartado de hilos
        tablero.setEstado(true); // me identifica si ha cambiado o no
        notifyAll(); // notifica al hilo que espera
        movimientoResultado.reiniciar();
    return true;
    }

    public synchronized void setFichaSimple(Point casillaInicial, Point casillaFinal){
        int filaInicial = casillaInicial.x; // Los X son las filas
        int columnaInicial = casillaInicial.y; // Las Y son las columnas
        int filaFinal = casillaFinal.x, columnaFinal = casillaFinal.y;
        Fichas ficha = tablero.getTablero()[filaFinal][columnaFinal];
        tablero.getTablero()[filaInicial][columnaInicial] = null;
        tablero.getTablero()[filaFinal][columnaFinal] = ficha;
        tablero.setEstado(true); // me identifica si ha cambiado o no
        notifyAll(); // notifica al hilo que espera
        movimientoResultado.reiniciar();
    }
    public synchronized void esperarCambio() throws InterruptedException {
        while (!tablero.getEstado()) {
            wait(); // Espera hasta que haya un cambio en el tablero
        }
        tablero.setEstado(false); // Restablece el estado
    }


    private boolean verificarPosicionFinal(Point coordenadaFinal) {
        var validMov = movimientoResultado.getMovimientosValidos();
        var enemigo = movimientoResultado.getEnemigos();
        return validMov.contains(coordenadaFinal) || enemigo.contains(coordenadaFinal);

    }

    private void movimientos_y_enemigosPosibles(Point coordenadaInicial, Fichas ficha) {
        switch (ficha.getTipo())
        {
            case PEON -> movimientoResultado.movimientoPeon(coordenadaInicial,ficha,tablero);
            case CABALLO, REY -> movimientoResultado.movimientoCaballoRey(coordenadaInicial,ficha,tablero);
            default -> movimientoResultado.movimientoGeneral(coordenadaInicial,ficha,tablero);
        }
    }

}
