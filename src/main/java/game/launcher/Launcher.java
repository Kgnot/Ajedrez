package game.launcher;

import com.formdev.flatlaf.FlatLightLaf;
import game.model.Modelo;

import javax.swing.*;

public class Launcher {

    private Launcher() throws InterruptedException {
        Modelo modelo = new Modelo();
        modelo.start();
    }

    public static void main(String[] args) throws InterruptedException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());

        new Launcher(); // JUEGO MIDE 1200 X 890


    }
}