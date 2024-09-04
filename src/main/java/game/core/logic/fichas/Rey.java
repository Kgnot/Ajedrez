package game.core.logic.fichas;

import game.core.logic.propiedades.Color;
import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rey extends Fichas {

    public Rey(Color color) {
        super(color, Tipo.REY);
    }
    public Rey(Rey rey){super(rey);}
    @Override
    public Set<Point> movimiento() {
        return new HashSet<>(Arrays.asList(
                new Point(1,0),
                new Point(-1,0),
                new Point(0,1),
                new Point(0,-1)
        ));
    }

    @Override
    public Fichas clone() {
        return new Rey(this);
    }
}
