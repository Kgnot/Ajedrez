package game.logica.util;

import java.awt.*;

public class Normalizar {
    public static Point normalizar(Point punto) {
        int x = punto.x == 0 ? 0 : punto.x / Math.abs(punto.x);
        int y = punto.y == 0 ? 0 : punto.y / Math.abs(punto.y);
        return new Point(x, y);
    }

}
