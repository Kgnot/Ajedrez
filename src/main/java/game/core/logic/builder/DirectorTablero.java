package game.core.logic.builder;

import game.core.logic.tablero.Tablero;

public class DirectorTablero {

    private BuilderTablero build;

    public DirectorTablero(){

    }
    public DirectorTablero(BuilderTablero build){
        this.build = build;
    }

    public Tablero construirTablero(){
        build.buildFichas();
        return build.getTablero();
    }

}
