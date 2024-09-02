package game.ui.extra.entidades;

import game.core.logic.fichas.Reina;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class ReinaBlanco extends FichaEntity {
    public ReinaBlanco(int x, int y, int tam, String path) {
        super(x, y, tam, path);
        super.setFicha(new Reina(Color.BLANCO));

    }
}
