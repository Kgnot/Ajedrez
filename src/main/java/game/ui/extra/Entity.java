package game.ui.extra;

import game.core.logic.Fichas;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public abstract class Entity extends JComponent {

    protected Point casillaInicial;
    protected int tam;  // Tamaño de la entidad
    protected Point casillaFinal; // a donde se va a mover la entidad

    public Entity(int x, int y, int tam) {
        casillaInicial = new Point();
        this.casillaInicial.x = (y / tam);
        this.casillaInicial.y = (x / tam);
        this.tam = tam;
        this.setLocation(x, y);
        this.setSize(tam, tam);
    }

    public abstract void estadoSelect();

    public abstract void estadoOriginal();

}
