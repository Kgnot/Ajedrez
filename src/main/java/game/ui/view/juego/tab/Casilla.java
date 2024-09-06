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
    private ImageIcon imageIcon;
    private final String imageSelect = "/iconos/pixelArt/CasillaSeleccion.png";
    private final String imageStandard = "/iconos/pixelArt/Casilla.png";
    private final String imageStandardBlanca = "/iconos/pixelArt/Casillav2.png";
    private final String imageDeath = "/iconos/pixelArt/CasillaMuerte.png";
    private ImageIcon inicial;
    public Casilla(TableroV tablero) {
        this.tablero = tablero;
        seleccionado = false; // lo inicializamos falso
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageStandard)));
        setOpaque(false);
    }

    public void setTipo(int num){
        if(num%2 ==0){
            standardBlanca();
            inicial = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageStandardBlanca)));
            setBackground(Color.decode("#67a5b2"));
        }
        else{
            standard();
            inicial = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageStandard)));
            setBackground(Color.decode("#252b43"));

        }
    }

    public void volverInicial(){
        imageIcon = inicial;
    }

    public void select(){
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageSelect)));
        repaint();
        revalidate();
    }
    public void muerte(){
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageDeath)));
        repaint();
        revalidate();
    }
    private void standard(){
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageStandard)));
        repaint();
        revalidate();
    }
    private void standardBlanca(){
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imageStandardBlanca)));
        repaint();
        revalidate();
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
    }


}
