package game.core.logic;

import game.core.logic.propiedades.Tipo;
import game.core.logic.propiedades.Color;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Set;

@Getter
public abstract class Fichas {

    protected Color color;
    protected Tipo tipo;
    public Fichas(Color color, Tipo tipo) {
        this.color = color;
        this.tipo = tipo;
    }
    public abstract Set<Point> movimiento(); // Aquí obtenemos muchos puntos que son los posibles movimientos, es decir, es la validación

    public Color getEnemigo(){
        return color.equals(Color.BLANCO)? Color.NEGRO:Color.BLANCO;
    }
}
