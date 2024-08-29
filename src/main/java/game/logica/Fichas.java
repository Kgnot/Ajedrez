package game.logica;

import game.logica.propiedades.Tipo;
import game.logica.propiedades.Color;
import java.awt.*;
import java.util.Set;

public abstract class Fichas {

    protected Color color;
    protected Tipo tipo;


    public Fichas(Color color, Tipo tipo) {
        this.color = color;
        this.tipo = tipo;
    }

    public Color getColor() {
        return color;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public abstract Set<Point> movimiento(); // Aquí obtenemos muchos puntos que son los posibles movimientos, es decir, es la validación

}
