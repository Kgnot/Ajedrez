package game.ui.extra;

import game.core.controller.HandlerMouse;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Setter
@Getter
public class FichaEntity extends Entity {

    private ImageIcon imageIcon;
    private String pathSelect; // sería porque uso
    private String pathOriginal;
    private HandlerMouse HM;

    public FichaEntity(int x, int y, int tam, String path) {
        super(x, y, tam);
        pathSelect = path; // lo inicializaremos así, para que no haya error
        pathOriginal = path;
        try {
            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
        } catch (Exception ignore) {
            System.out.println("No se encontró la imagen deseada");
        }
        addMouseMotionListener(getHandler());
        addMouseListener(getHandler());
    }

    @Override
    public void estadoSelect() {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(pathSelect)));
        revalidate();
        repaint();
    }

    @Override
    public void estadoOriginal() {
        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(pathOriginal)));
        revalidate();
        repaint();
    }

    public void setImagenSelect(String pathSelect) {
        this.pathSelect = pathSelect;
    }


    private HandlerMouse getHandler() {
        if (HM == null) {
            HM = new HandlerMouse(this);
        }
        return HM;
    }

  /* @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }*/
}
