package game.ui.extra;

import game.core.logic.Fichas;
import game.model.Modelo;
import game.ui.extra.estado.Estado;
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
    protected Estado estado;
    protected Modelo modelo;
    protected Fichas ficha;

    public Entity(int x, int y, int tam) {
        estado = Estado.VIVO; // Todos están vivos xd
        casillaInicial = new Point();
        this.casillaInicial.x = (int) y / tam;
        this.casillaInicial.y = (int) x / tam;
        this.tam = tam;
        this.setLocation(x, y);
        this.setSize(tam, tam);
    }

}
