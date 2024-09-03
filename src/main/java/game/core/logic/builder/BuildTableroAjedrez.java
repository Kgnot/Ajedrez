package game.core.logic.builder;

import game.core.logic.fichas.*;
import game.core.logic.propiedades.Color;
import game.core.logic.tablero.Tablero;


public class BuildTableroAjedrez extends BuilderTablero{

    public BuildTableroAjedrez(){
        super.tablero = new Tablero();
    }

    @Override
    public void buildFichas() {
        buildPeones();
        buildTorres();
        buildCaballos();
        buildAlfiles();
        buildReinaYRey();
    }

    @Override
    public Tablero getTablero() {
        return tablero;
    }


    private void buildPeones() {
        // Colocar peones en la fila 2 y 7
        for (int x = 0; x < 8; x++) {
            tablero.setFicha(1, x, new Peon(Color.NEGRO)); // Peones Negros
            tablero.setFicha(6, x, new Peon(Color.BLANCO)); // Peones Blancos
        }
    }

    private void buildTorres() {
        // Colocar torres
        tablero.setFicha(0, 0, new Torre(Color.NEGRO)); // Torre Negra 1
        tablero.setFicha(0, 7, new Torre(Color.NEGRO)); // Torre Negra 2
        tablero.setFicha(7, 0, new Torre(Color.BLANCO)); // Torre Blanca 1
        tablero.setFicha(7, 7, new Torre(Color.BLANCO)); // Torre Blanca 2
    }

    private void buildCaballos() {
        // Colocar caballos
        tablero.setFicha(0, 1, new Caballo(Color.NEGRO));
        tablero.setFicha(0, 6, new Caballo(Color.NEGRO));
        tablero.setFicha(7, 1, new Caballo(Color.BLANCO));
        tablero.setFicha(7, 6, new Caballo(Color.BLANCO));
    }

    private void buildAlfiles() {
        // Colocar alfiles
        tablero.setFicha(0, 2, new Alfil(Color.NEGRO));
        tablero.setFicha(0, 5, new Alfil(Color.NEGRO));
        tablero.setFicha(7, 2, new Alfil(Color.BLANCO));
        tablero.setFicha(7, 5, new Alfil(Color.BLANCO));
    }

    private void buildReinaYRey() {
        // Colocar reina y rey
        tablero.setFicha(0, 3, new Reina(Color.NEGRO));
        tablero.setFicha(0, 4, new Rey(Color.NEGRO));
        tablero.setFicha(7, 3, new Reina(Color.BLANCO));
        tablero.setFicha(7, 4, new Rey(Color.BLANCO));
    }



}
