package game.logica.fichas;

import game.logica.propiedades.Color;
import game.logica.Fichas;
import game.logica.propiedades.Tipo;

import java.awt.*;
import java.util.Set;

public class Torre extends Fichas {


    public Torre(Color color) {
        super(color, Tipo.TORRE);
    }

    @Override
    public Set<Point> movimiento() {
        return null;
    }
}
