package game.ui.extra.entidades;

import game.ui.extra.FichaEntity;
import java.awt.*;

public class PeonEntity extends FichaEntity {
    public PeonEntity(int x, int y, int tam, String path) {
        super(x, y, tam, path);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(super.getImageIcon().getImage(), 0, 13, getWidth(), getHeight()-10, this);
    }
}
