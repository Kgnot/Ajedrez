package game.ui.extra.entidades;

import game.core.logic.fichas.Rey;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class ReyBlanco extends FichaEntity {
    public ReyBlanco(int x, int y, int tam, String path) {
        super(x, y, tam, path);
        super.setFicha(new Rey(Color.BLANCO));

    }
}
