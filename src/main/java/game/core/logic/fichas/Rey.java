package game.core.logic.fichas;

import game.core.logic.propiedades.Color;
import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;

import java.awt.*;
import java.util.Set;

public class Rey extends Fichas {

    public Rey(Color color) {
        super(color, Tipo.REY);
    }
    public Rey(Rey rey){super(rey);}
    @Override
    public Set<Point> movimiento() {
        return null;
    }

    @Override
    public Fichas clone() {
        return new Rey(this);
    }
}
