package game.core.logic.movimientos;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MovimientoResultado {
    private Set<Point> movimientosValidos;
    private Set<Point> enemigos;

    public MovimientoResultado(){
        movimientosValidos = new HashSet<>();
        enemigos = new HashSet<>();
    }

    public void reiniciar(){
        movimientosValidos.clear();
        enemigos.clear();
    }
}
