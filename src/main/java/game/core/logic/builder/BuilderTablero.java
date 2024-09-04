package game.core.logic.builder;

import game.core.logic.tablero.Tablero;

public abstract class BuilderTablero {
    protected Tablero tablero;

    // Por ahora solo crearemos las Fichas en el tablero
    public abstract void buildFichas();
    public abstract Tablero getTablero();
}
