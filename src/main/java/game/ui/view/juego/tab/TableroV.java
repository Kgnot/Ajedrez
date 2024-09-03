package game.ui.view.juego.tab;

import game.model.Modelo;
import game.ui.extra.Entity;
import lombok.Getter;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TableroV extends JLayeredPane {

    @Getter
    private final Casilla[][] cuadros;
    @Getter
    private ArrayList<Entity> entidades;
    @Getter
    private final int tam;
    @Getter
    private final Modelo modelo;
    private Point pInicial;

    public TableroV(int tam, Modelo modelo) {
        entidades = new ArrayList<>();
        this.modelo = modelo;
        this.tam = tam;
        cuadros = new Casilla[8][8];
        setLayout(null); // necesario ponerlo en null
        setSize(new Dimension(tam * 8, tam * 8));
        // iniciamos
        initTableroLogico(); // aquí agregamos el controlador de una vez
    }

    private void initTableroLogico() {
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
                cuadros[i][j].putClientProperty("fila", i);   // Aqui agego las propiedades, pero, donde esta el coso ubicado originalmente?, lo pondremos:
                cuadros[i][j].putClientProperty("columna", j);
                // Pondremos la propiedad de su origen:
                cuadros[i][j].setPuntoInicial(cuadros[i][j].getLocation()); //En forma de punto
                add(cuadros[i][j]); //,JLayeredPane.DEFAULT_LAYER); // Porque esto? --> Investigar | Pero no es necesario, lo necesario sería él de los peones, etc
                x += tam;
            }
            x = 0;
            y += tam;
        }
    }

    // Métodos Get:
    public Point getPInicial() {
        return pInicial;
    }

    public void setPInicial(Point pInicial) {
        this.pInicial = pInicial;
    }
    public void setEntidad(Entity entidad){
        entidades.add(entidad);
        this.add(entidad,0);
    }

    public Modelo getModelo(){
        return modelo;
    }

}