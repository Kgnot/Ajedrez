package game.launcher;

import game.model.Modelo;

public class Launcher {

    private Launcher() throws InterruptedException {
        Modelo modelo = new Modelo();
        modelo.start();
    }

    public static void main(String[] args) throws InterruptedException {

    new Launcher(); // JUEGO MIDE 1200 X 890



    }
}