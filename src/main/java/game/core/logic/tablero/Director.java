package game.core.logic.tablero;

public class Director {

    private BuilderTablero build;

    public Director(){

    }
    public Director(BuilderTablero build){
        this.build = build;
    }

    public Tablero construirTablero(){
        build.buildFichas();
        return build.getTablero();
    }

}
