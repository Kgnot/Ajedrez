package game.logica.fichas;

import game.logica.propiedades.Color;
import game.logica.Fichas;
import game.logica.propiedades.Tipo;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Peon extends Fichas {
    public Peon(Color color) {
        super(color, Tipo.PEON);
    }

    @Override
    public Set<Point> movimiento() {
        return new HashSet<>(List.of(
                new Point(-1, 0) // Fila | Columna -> 1|0 -> Pero es un movimiento de solo si es Negra ; como siempre movemos la de abajo, solo pondremos esa perspectiva, la negra no.
                // new Point()
        ));
    }
}
