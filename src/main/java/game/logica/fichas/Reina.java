package game.logica.fichas;

import game.logica.propiedades.Color;
import game.logica.Fichas;
import game.logica.propiedades.Tipo;

import java.awt.*;
import java.util.Set;

public class Reina extends Fichas {

    public Reina(Color color) {
        super(color, Tipo.REINA);
    }

    @Override
    public Set<Point> movimiento() {
        return null;
    }
}
