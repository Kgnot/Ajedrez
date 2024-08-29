package game.logica.fichas;

import game.logica.propiedades.Color;
import game.logica.Fichas;
import game.logica.propiedades.Tipo;

import java.awt.*;
import java.util.Set;

public class Rey extends Fichas {

    public Rey(Color color) {
        super(color, Tipo.REY);
    }

    @Override
    public Set<Point> movimiento() {
        return null;
    }
}
