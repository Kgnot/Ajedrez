package game.ui.extra;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Entity extends JComponent {

    protected int x;
    protected int y;
    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }
}
