package game.ui.extra.entidades;

import game.core.logic.fichas.Caballo;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class CaballoNegro extends FichaEntity {
    public CaballoNegro(int x, int y, int tam, String path) {
        super(x, y, tam, path);
        super.setFicha(new Caballo(Color.NEGRO));

    }
}
