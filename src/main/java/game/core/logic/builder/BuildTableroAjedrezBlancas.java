package game.core.logic.builder;

import game.core.logic.fichas.*;
import game.core.logic.propiedades.Color;
import game.core.logic.tablero.Tablero;


public class BuildTableroAjedrezBlancas extends BuilderTablero{

    public BuildTableroAjedrezBlancas(){
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
        Peon peonNegro = new Peon(Color.NEGRO);
        Peon peonBlanc = new Peon(Color.BLANCO);
        for (int x = 0; x < 8; x++) {
            tablero.setFicha(1, x, peonNegro.clone()); // Peones Negros
            tablero.setFicha(6, x, peonBlanc.clone()); // Peones Blancos
        }
    }

    private void buildTorres() {
        Torre torreNegra = new Torre(Color.NEGRO);
        Torre torreBlanca = new Torre(Color.BLANCO);
        // Colocar torres
        tablero.setFicha(0, 0, torreNegra.clone()); // Torre Negra 1
        tablero.setFicha(0, 7, torreNegra.clone()); // Torre Negra 2
        tablero.setFicha(7, 0, torreBlanca.clone()); // Torre Blanca 1
        tablero.setFicha(7, 7, torreBlanca.clone()); // Torre Blanca 2
    }

    private void buildCaballos() {
        Caballo caballoNegro = new Caballo(Color.NEGRO);
        Caballo caballoBlanco = new Caballo(Color.BLANCO);
        // Colocar caballos
        tablero.setFicha(0, 1, caballoNegro.clone());
        tablero.setFicha(0, 6, caballoNegro.clone());
        tablero.setFicha(7, 1, caballoBlanco.clone());
        tablero.setFicha(7, 6, caballoBlanco.clone());
    }

    private void buildAlfiles() {
        Alfil alfilNegro = new Alfil(Color.NEGRO);
        Alfil alfilBlanco = new Alfil(Color.BLANCO);
        // Colocar alfiles
        tablero.setFicha(0, 2, alfilNegro.clone());
        tablero.setFicha(0, 5, alfilNegro.clone());
        tablero.setFicha(7, 2, alfilBlanco.clone());
        tablero.setFicha(7, 5, alfilBlanco.clone());
    }

    private void buildReinaYRey() {
        // Colocar reina y rey
        tablero.setFicha(0, 3, new Reina(Color.NEGRO));
        tablero.setFicha(0, 4, new Rey(Color.NEGRO));
        tablero.setFicha(7, 3, new Reina(Color.BLANCO));
        tablero.setFicha(7, 4, new Rey(Color.BLANCO));
    }

}
