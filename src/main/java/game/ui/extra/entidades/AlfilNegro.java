package game.ui.extra.entidades;

import game.core.logic.fichas.Alfil;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class AlfilNegro extends FichaEntity {
    public AlfilNegro(int x, int y, int tam, String path) {
        super(x, y, tam, path);
        super.setFicha(new Alfil(Color.NEGRO));

    }
}
