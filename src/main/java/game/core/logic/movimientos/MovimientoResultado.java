package game.core.logic.movimientos;

import game.core.logic.Fichas;
import game.core.logic.tablero.Tablero;
import lombok.Getter;
import lombok.Setter;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;


// ChatGPT me ayudo a reducir el comportamiento lógico, xd, bien ahí
@Getter
@Setter
public class MovimientoResultado {
    private Set<Point> movimientosValidos, enemigos;

    public MovimientoResultado() {
        movimientosValidos = new HashSet<>();
        enemigos = new HashSet<>();
    }

    public void reiniciar() {
        movimientosValidos.clear();
        enemigos.clear();
    }

    public void movimientoPeon(Point coordenadaInicial, Tablero tablero) {
        int x = coordenadaInicial.x, y = coordenadaInicial.y;
        Fichas ficha = tablero.getTablero()[x][y];

        if (x>0){
            agregarMovimiento(new Point(x-1,y),tablero);
            if(x==6) agregarMovimiento(new Point(x-2,y),tablero);
        }
        verificarCaptura(new Point(x - 1, y - 1), ficha, tablero);
        verificarCaptura(new Point(x - 1, y + 1), ficha, tablero);
    }

    public void movimientoCaballoRey(Point coordenadaInicial,Tablero tablero) {
        int filaInicial = coordenadaInicial.x, columnaInicial = coordenadaInicial.y;
        Fichas ficha = tablero.getTablero()[filaInicial][columnaInicial];

        for (Point dir : ficha.movimiento()) {
            Point destino = new Point(coordenadaInicial.x + dir.x, coordenadaInicial.y + dir.y);
            if (!verificarCaptura(destino, ficha, tablero)) {
                agregarMovimiento(destino, tablero);
            }
        }
    }

    public void movimientoGeneral(Point coordenadaInicial, Tablero tablero) {
        int filaInicial = coordenadaInicial.x, columnaInicial = coordenadaInicial.y;
        Fichas ficha = tablero.getTablero()[filaInicial][columnaInicial];
        // Ahora nos pasan son las direcciones él ficha.movimiento
        for (Point dir : ficha.movimiento()) {            // Ahora a cada una de las direcciones vamos a reproducirlas 7 veces por maximos:  - Aunque debería de ser 6
            for (int i = 1; i < 8; i++) {
                Point destino = new Point(filaInicial + (dir.x * i), columnaInicial + (dir.y * i));
                if (!esPosValida(destino.x, destino.y)) break;
                if (esAmigo(destino,tablero,ficha.getColor())) break;
                if (verificarCaptura(destino, ficha, tablero)) break;
                agregarMovimiento(destino, tablero);
            }
        }
    }

    private boolean esAmigo(Point casilla, Tablero tablero, game.core.logic.propiedades.Color color) {
        Fichas ficha = tablero.getTablero()[casilla.x][casilla.y]; // esto es lo que necesito verificar
        if(ficha!= null){
            return ficha.getColor().equals(color);
        }
        return false;
    }

    // Métodos privados
    private boolean esPosValida(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private boolean esEnemigo(Fichas selection, Point posibleEnemigo, Tablero tablero) {
        if (!esPosValida(posibleEnemigo.x, posibleEnemigo.y))
            return false;
        var xyEnemy = tablero.getTablero()[posibleEnemigo.x][posibleEnemigo.y];
        if (xyEnemy != null) {
            return xyEnemy.getColor().equals(selection.getEnemigo());
        }
        return false;
    }
    private void agregarMovimiento(Point pos, Tablero tablero) {
        if (esPosValida(pos.x, pos.y) && tablero.getTablero()[pos.x][pos.y] == null) {
            movimientosValidos.add(pos);
        }
    }

    private boolean verificarCaptura(Point posEnemy, Fichas ficha, Tablero tablero) {
        if (esEnemigo(ficha, posEnemy, tablero)) {
            enemigos.add(posEnemy);
            return true;
        }
        return false;
    }


}
