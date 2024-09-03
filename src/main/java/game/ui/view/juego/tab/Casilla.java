package game.ui.view.juego.tab;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Getter
public class Casilla extends JPanel {

    private final TableroV tablero; // las casillas necesitan meterse a algún modelo
    @Setter
    private boolean seleccionado;
    @Setter
    private Point puntoInicial;
    private final ImageIcon imageIcon;

    public Casilla(TableroV tablero) {
        this.tablero = tablero;
        seleccionado = false; // lo inicializamos falso
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/iconos/pixelArt/Casilla.png")));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
    }


}
