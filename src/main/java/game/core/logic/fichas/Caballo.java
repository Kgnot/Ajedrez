package game.core.logic.fichas;

import game.core.logic.propiedades.Color;
import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;

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
