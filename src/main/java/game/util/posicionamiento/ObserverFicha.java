package game.util.posicionamiento;

import game.core.logic.Fichas;
import game.core.logic.tablero.Tablero;
import game.ui.extra.Entity;
import game.util.Observer;

public class ObserverFicha implements Observer {
    private final Tablero tablero;
    private final Entity entidad;

    public ObserverFicha(Tablero tablero, Entity entity) {
        this.tablero = tablero;
        this.entidad = entity;
    }

    @Override
    public boolean update() {
        Fichas.setFichaManejable(entidad.getFicha());
       tablero.getGestorMovimientosAjedrez().movimientos_y_enemigosPosibles(
                entidad.getCasillaInicial(),
                entidad.getFicha()
        );
        return tablero.getGestorMovimientosAjedrez().setFicha(
                entidad.getCasillaInicial(),
                entidad.getCasillaFinal(),
                entidad.getFicha()
        );
    }
}
