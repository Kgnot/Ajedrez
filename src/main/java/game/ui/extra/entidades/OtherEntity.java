package game.ui.extra.entidades;

import game.ui.extra.FichaEntity;

import java.awt.*;

public class OtherEntity extends FichaEntity {
    public OtherEntity(int x, int y, int tam, String path) {
        super(x, y, tam, path);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(super.getImageIcon().getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
