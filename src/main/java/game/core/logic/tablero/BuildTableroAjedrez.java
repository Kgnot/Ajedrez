package game.core.logic.tablero;

import game.core.logic.fichas.*;
import game.core.logic.propiedades.Color;


public class BuildTableroAjedrez extends BuilderTablero{

    public BuildTableroAjedrez(){
        super.tablero = new Tablero();
    }

    @Override
    public void buildFichas() {
        // Colocar peones en la fila 2 y 7
        for (int x = 0; x < 8; x++) {
            tablero.setFicha(1, x, new Peon(Color.NEGRO)); // Peones Negros
            tablero.setFicha(6, x, new Peon(Color.BLANCO)); // Peones Blancos
        }

        // Colocar torres
        tablero.setFicha(0, 0, new Torre(Color.NEGRO)); // Torre Negra 1
        tablero.setFicha(0, 7, new Torre(Color.NEGRO)); // Torre Negra 2
        tablero.setFicha(7, 0, new Torre(Color.BLANCO)); // Torre Blanca 1
        tablero.setFicha(7, 7, new Torre(Color.BLANCO)); // Torre Blanca 2

        // Colocar caballos
        tablero.setFicha(0, 1, new Caballo(Color.NEGRO));
        tablero.setFicha(0, 6, new Caballo(Color.NEGRO));
        tablero.setFicha(7, 1, new Caballo(Color.BLANCO));
        tablero.setFicha(7, 6, new Caballo(Color.BLANCO));

        // Colocar alfiles
        tablero.setFicha(0, 2, new Alfil(Color.NEGRO));
        tablero.setFicha(0, 5, new Alfil(Color.NEGRO));
        tablero.setFicha(7, 2, new Alfil(Color.BLANCO));
        tablero.setFicha(7, 5, new Alfil(Color.BLANCO));

        // Colocar reina y rey
        tablero.setFicha(0, 3, new Reina(Color.NEGRO));
        tablero.setFicha(0, 4, new Rey(Color.NEGRO));
        tablero.setFicha(7, 3, new Reina(Color.BLANCO));
        tablero.setFicha(7, 4, new Rey(Color.BLANCO));
    }

    @Override
    public Tablero getTablero() {
        return tablero;
    }
}
