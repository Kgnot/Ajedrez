package game.ui.extra;


import game.ui.view.juego.tab.TableroV;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeonEntity extends Entity{

    public TableroV tablero;

    public PeonEntity(int x, int y) {
        super(x, y);
    }




}
