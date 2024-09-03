package game.core.logic.fichas;

import game.core.logic.propiedades.Color;
import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Alfil extends Fichas {

    public Alfil(Color color){
        super(color,Tipo.ALFIL);
    }
    public Alfil(Alfil alfil) {
        super(alfil);
    }

    @Override
    public Set<Point> movimiento() {
        var puntos = new HashSet<Point>();
        // pondremos el conjunto de puntos que pertenecen a:
        puntos.add(new Point(1, -1));
        puntos.add(new Point(1, 1));
        puntos.add(new Point(-1, 1));
        puntos.add(new Point(-1, -1));
        return puntos;
    }

    @Override
    public Alfil clone() {
        return new Alfil(this);
    }
}
