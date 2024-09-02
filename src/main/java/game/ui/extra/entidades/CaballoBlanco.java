package game.ui.extra.entidades;

import game.core.logic.fichas.Caballo;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class CaballoBlanco extends FichaEntity {
    public CaballoBlanco(int x, int y, int tam, String path) {
        super(x, y, tam, path);
        super.setFicha(new Caballo(Color.BLANCO));

    }
}
