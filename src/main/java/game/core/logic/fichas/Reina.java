package game.core.logic.fichas;

import game.core.logic.propiedades.Color;
import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Reina extends Fichas {

    public Reina(Color color) {
        super(color, Tipo.REINA);
    }
    public Reina(Reina reina){super(reina);}
    @Override
    public Set<Point> movimiento() {
        return new HashSet<>(Arrays.asList(
                new Point(1, 0),
                new Point(-1, 0),
                new Point(0, 1),
                new Point(0, -1),
                new Point(1, -1),
                new Point(1, 1),
                new Point(-1, 1),
                new Point(-1, -1)
        ));
    }

    @Override
    public Reina clone() {
        return new Reina(this);
    }
}
