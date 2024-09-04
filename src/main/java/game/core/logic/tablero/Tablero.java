package game.core.logic.tablero;

import game.core.logic.Fichas;
import game.core.logic.movimientos.GestorMovimientos;
import lombok.Getter;
import lombok.Setter;

public class Tablero {

    @Getter
    private final Fichas[][] tablero;
    @Setter
    private volatile boolean estado = false;
    @Getter
    private final GestorMovimientos gestorMovimientosAjedrez;

    public Tablero() {
        tablero = new Fichas[8][8];
        gestorMovimientosAjedrez = new GestorMovimientos(this);
    }

    public void setFicha(int fila, int columna, Fichas ficha){
        tablero[fila][columna] = ficha;
    }

    public boolean getEstado() {
        return estado;
    }
}
