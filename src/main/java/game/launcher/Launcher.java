package game.launcher;

import game.model.Modelo;

public class Launcher {

    private Launcher(){
        Modelo modelo = new Modelo();
        modelo.start();
    }

    public static void main(String[] args) {

    new Launcher();



    }
}