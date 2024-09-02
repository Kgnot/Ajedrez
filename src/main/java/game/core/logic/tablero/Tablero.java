package game.core.logic.tablero;

import game.core.logic.Fichas;
import game.core.logic.fichas.*;
import game.core.logic.movimientos.GestorMovimientos;
import game.core.logic.propiedades.Color;
import lombok.Getter;

public class Tablero {

    @Getter
    private final Fichas[][] tablero;
    private volatile boolean haCambiado = false;
    @Getter
    private final GestorMovimientos gestorMovimientosAjedrez;

    public Tablero() {
        tablero = new Fichas[8][8];
        gestorMovimientosAjedrez = new GestorMovimientos(this);
        initFichasTablero();
    }
    private void initFichasTablero() {
        for (int x = 0; x < 8; x++) {
            tablero[1][x] = new Peon(Color.NEGRO); // color Negro
            tablero[6][x] = new Peon(Color.BLANCO); // iinicializamos las blancas
        }
        // ahora las individuales
        // Torre
        tablero[0][0] = new Torre(Color.NEGRO); // Torre Negra 1
        tablero[0][7] = new Torre(Color.NEGRO); //  Torre Negra 2
        tablero[7][0] = new Torre(Color.BLANCO); // Torre Negra 1
        tablero[7][7] = new Torre(Color.BLANCO); //  Torre Negra 2
        //Caballo
        tablero[0][1] = new Caballo(Color.NEGRO);
        tablero[0][6] = new Caballo(Color.NEGRO);
        tablero[7][1] = new Caballo(Color.BLANCO);
        tablero[7][6] = new Caballo(Color.BLANCO);
        //Alfil:
        tablero[0][2] = new Alfil(Color.NEGRO);
        tablero[0][5] = new Alfil(Color.NEGRO);
        tablero[7][2] = new Alfil(Color.BLANCO);
        tablero[7][5] = new Alfil(Color.BLANCO);
        //prueba
        tablero[3][3] = new Alfil(Color.BLANCO);
        // Reina y rey:
        tablero[0][3] = new Reina(Color.NEGRO);
        tablero[0][4] = new Rey(Color.NEGRO);
        tablero[7][3] = new Reina(Color.BLANCO);
        tablero[7][4] = new Rey(Color.BLANCO);
    }

    public void setEstado(boolean b) {
        this.haCambiado = b;
    }

    public boolean getEstado() {
        return haCambiado;
    }

}
