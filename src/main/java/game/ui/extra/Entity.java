package game.ui.extra;

import game.core.controller.HandlerMouse;
import game.core.logic.Fichas;
import game.util.Observer;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Entity extends JComponent {

    protected Point casillaInicial;
    protected int tam;  // Tamaño de la entidad
    protected Point casillaFinal; // a donde se va a mover la entidad
    protected Fichas ficha; // Ficha a la que hace referencia la entidad
    protected Observer o; // Este observer será quien nos diga el cambio de ficha es correcto

    public Entity(int x, int y, int tam) {
        casillaInicial = new Point();
        this.casillaInicial.x = (int) y / tam;
        this.casillaInicial.y = (int) x / tam;
        this.tam = tam;
        this.setLocation(x, y);
        this.setSize(tam, tam);
    }

}
