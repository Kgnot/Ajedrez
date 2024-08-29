package game.presentacion.vistas.juego.tab;

import game.presentacion.Modelo;

import java.awt.*;
import javax.swing.*;

public class TableroV extends JPanel {

    private Casilla[][] cuadros;
    private final int tam;
    private Modelo modelo;
    private Point pInicial;

    public TableroV(int tam, Modelo modelo) {
        this.modelo = modelo;
        this.tam = tam;
        cuadros = new Casilla[8][8];
        setLayout(null); // necesario ponerlo en null
        this.setSize(new Dimension(tam * 8, tam * 8));
        // iniciamos
        initTablero(); // aquí agregamos el controlador de una vez
    }

    private void initTablero() {
        Color color1 = new Color(52, 73, 94);
        Color color2 = null;
        int x = 0, y = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cuadros[i][j] = new Casilla(this); // le creamos
                cuadros[i][j].setSize(tam, tam);
                cuadros[i][j].setBounds(x, y, tam, tam);
                cuadros[i][j].setBackground(((j + i) % 2) == 0 ? color1 : color2);
                cuadros[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cuadros[i][j].putClientProperty("fila", i);
                cuadros[i][j].putClientProperty("columna", j);
                add(cuadros[i][j]);
                x += tam;
            }
            x = 0;
            y += tam;
        }
    }

    // Métodos del get:

    public Casilla[][] getCuadros() {
        return cuadros;
    }

    public Modelo getModelo(){
        return modelo;
    }

    public Point getPInicial(){
        return pInicial;
    }

    public void setPInicial(Point pInicial) {
        this.pInicial = pInicial;
    }
}
