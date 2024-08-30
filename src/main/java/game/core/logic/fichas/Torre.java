package game.core.logic.fichas;

import game.core.logic.propiedades.Color;
import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Torre extends Fichas {


    public Torre(Color color) {
        super(color, Tipo.TORRE);
    }

    @Override
    public Set<Point> movimiento() {


        return new HashSet<>(Arrays.asList(
                new Point(1, 0),
                new Point(-1, 0),
                new Point(0, 1),
                new Point(0, -1)
                ));
    }
}
