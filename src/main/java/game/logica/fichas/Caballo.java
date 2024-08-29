package game.logica.fichas;

import game.logica.propiedades.Color;
import game.logica.Fichas;
import game.logica.propiedades.Tipo;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Caballo extends Fichas {
    public Caballo(Color color) {
        super(color, Tipo.CABALLO);
    }

    @Override
    public Set<Point> movimiento() {
        return new HashSet<>(Arrays.asList(
                new Point(2, 1), // | fila | columna |
                new Point(2, -1),
                new Point(1, 2),
                new Point(1, -2),
                new Point(-1, 2),
                new Point(-1, -2),
                new Point(-2, -1),
                new Point(-2, 1)

        ));
    }
}
