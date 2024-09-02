package game.ui.extra.entidades;

import game.core.logic.fichas.Peon;
import game.core.logic.propiedades.Color;
import game.ui.extra.FichaEntity;

public class PeonNegro extends FichaEntity {

    public PeonNegro(int x, int y, int tam, String path) {
        super(x, y, tam,path);
        super.setFicha(new Peon(Color.NEGRO));
    }
}
