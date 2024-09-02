package game.ui.extra.entidades;

import game.core.logic.fichas.Torre;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class TorreNegra extends FichaEntity {
    public TorreNegra(int x, int y, int tam, String path) {
        super(x, y, tam, path);
        super.setFicha(new Torre(Color.NEGRO));

    }
}
