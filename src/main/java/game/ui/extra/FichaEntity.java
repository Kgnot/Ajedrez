package game.ui.extra;


import game.core.controller.HandlerMouse;
import game.ui.extra.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Setter
@Getter
public class FichaEntity extends Entity {

    private ImageIcon imageIcon;
    private HandlerMouse HM;
    public FichaEntity(int x, int y, int tam, String path) {
        super(x, y,tam);
        try{
            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
        }
        catch (Exception ignore){
            System.out.println("No se encontró la imagen deseada");
        }
        addMouseMotionListener(getHandler());
        addMouseListener(getHandler());
    }
    public HandlerMouse getHandler(){
        if(HM == null){
            HM = new HandlerMouse(this);
        }
        return HM;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(),0,0,getWidth(),getHeight(),this);
    }
}
