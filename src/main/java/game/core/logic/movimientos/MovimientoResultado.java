package game.core.logic.movimientos;

import game.core.logic.Fichas;
import game.core.logic.propiedades.Tipo;
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

    public void movimientoPeon(Point coordenadaInicial, Fichas ficha, Tablero tablero) {
        if (ficha.getTipo() != Tipo.PEON) return; // si es diferente a PEON pues que se valla a la basura
        int x = coordenadaInicial.x, y = coordenadaInicial.y;
        if (x>0){
            agregarMovimiento(new Point(x-1,y),tablero);
            if(x==6) agregarMovimiento(new Point(x-2,y),tablero);
        }
        verificarCaptura(new Point(x - 1, y - 1), ficha, tablero);
        verificarCaptura(new Point(x - 1, y + 1), ficha, tablero);
    }

    public void movimientoCaballoRey(Point coordenadaInicial, Fichas ficha, Tablero tablero) {
        int filaInicial = coordenadaInicial.x, columnaInicial = coordenadaInicial.y;
        for (Point dir : ficha.movimiento()) {
            Point destino = new Point(coordenadaInicial.x + dir.x, coordenadaInicial.y + dir.y);
            if (!verificarCaptura(destino, ficha, tablero)) {
                agregarMovimiento(destino, tablero);
            }
        }
    }

    public void movimientoGeneral(Point coordenadaInicial, Fichas ficha, Tablero tablero) {
        int filaInicial = coordenadaInicial.x, columnaInicial = coordenadaInicial.y;
        // Ahora nos pasan son las direcciones él ficha.movimiento
        for (Point dir : ficha.movimiento()) {            // Ahora a cada una de las direcciones vamos a reproducirlas 7 veces por maximos:  - Aunque debería de ser 6
            for (int i = 1; i < 8; i++) {
                Point destino = new Point(filaInicial + (dir.x * i), columnaInicial + (dir.y * i));
                if (!esPosicionValida(destino.x, destino.y)) break;
                if (verificarCaptura(destino, ficha, tablero)) break;
                agregarMovimiento(destino, tablero);
            }
        }
    }

    // Métodos privados
    private boolean esPosicionValida(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private boolean esEnemigo(Fichas seleccion, Point posibleEnemigo, Tablero tablero) {
        if (!esPosicionValida(posibleEnemigo.x, posibleEnemigo.y))
            return false;
        var xyEnem = tablero.getTablero()[posibleEnemigo.x][posibleEnemigo.y];
        if (xyEnem != null) {
            return xyEnem.getColor().equals(seleccion.getEnemigo());
        }
        return false;
    }

    private void agregarMovimiento(Point pos, Tablero tablero) {
        if (esPosicionValida(pos.x, pos.y) && tablero.getTablero()[pos.x][pos.y] == null) {
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
