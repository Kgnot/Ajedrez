package game.logica.fichas;

import game.logica.propiedades.Color;
import game.logica.Fichas;
import game.logica.propiedades.Tipo;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Alfil extends Fichas {
    public Alfil(Color color) {
        super(color, Tipo.ALFIL);
    }

    @Override
    public Set<Point> movimiento() {
        var puntos = new HashSet<Point>();
        // pondremos el conjunto de puntos que pertenecen a:
       /* for (int i = 1; i < 8; i++) {
            puntos.add(new Point(i, -i));
            puntos.add(new Point(i, i));
            puntos.add(new Point(-i, i));
            puntos.add(new Point(-i, -i));
        }*/

        puntos.add(new Point(1, -1));
        puntos.add(new Point(1, 1));
        puntos.add(new Point(-1, 1));
        puntos.add(new Point(-1, -1));


        return puntos;
    }
}
