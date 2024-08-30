package game.core.logic.movimientos;

import game.core.logic.Fichas;
import game.core.logic.tablero.Tablero;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GestorMovimientos {
    private final Tablero tablero;

    public GestorMovimientos(Tablero tablero) {
        this.tablero = tablero;
    }

    public synchronized void setFicha(Point coordenadaInicial, Point coordenadaFinal, Fichas ficha) {
        //Iniciales
        int filaInicial = coordenadaInicial.x; // Los X son las filas
        int columnaInicial = coordenadaInicial.y; // Las Y son las columnas
        // Finales
        int filaFinal = coordenadaFinal.x;
        int columnaFinal = coordenadaFinal.y;

        /*Condición para verificar si se puede mover a donde es, primero es sacar
         * la coordenada, luego, tenemos los posibles movimientos, solo los alargamos
         * menos al caballo, además, falta la de matar, asi que haremos privates para hacer el cambio
         * y la validación si hay alguna ficha por ahí.
         */
        if (!validarMovimiento(coordenadaInicial, coordenadaFinal, ficha) || tablero.getTablero()[filaFinal][columnaFinal] != null) {
            return;
        }
        tablero.getTablero()[filaInicial][columnaInicial] = null;
        tablero.getTablero()[filaFinal][columnaFinal] = ficha;
        // apartado de hilos
        tablero.setEstado(true); // me identifica si ha cambiado o no
        notifyAll(); // notifica al hilo que espera
    }

    private boolean validarMovimiento(Point coordenadaInicial, Point coordenadaFinal, Fichas ficha) {
        // Tenemos los movimientos posibles :
        var puntos = puntosMovibles(coordenadaInicial, ficha);
        return puntos.contains(coordenadaFinal);

    }

    public Set<Point> puntosMovibles(Point coordenadaInicial, Fichas ficha) {
        Set<Point> puntosValidos = new HashSet<>();
        int filaInicial = coordenadaInicial.x;
        int columnaInicial = coordenadaInicial.y;

        // Ahora nos pasan son las direcciones el ficha.movimiento
      for(Point dir : ficha.movimiento()){
          // Ahora a cada una de las direcciones vamos a reproducirlas 7 veces por maximos:  - Aunque debería de ser 6
          for(int i = 1; i<8 ; i++){
              int fila = dir.x;
              int columna = dir.y;
              // verificamos la suma:
              if(filaInicial+(fila*i) < 0 || filaInicial+(fila*i)>7  || columnaInicial+(columna*i) < 0 || columnaInicial+(columna*i)>7 ){
                  //significa que esta fuera de los limites, asi que solo cambiara de punto:
                  break;
              }
            //si sigue entonces miramos si hay una ficha
              if(tablero.getTablero()[filaInicial+(fila*i)][columnaInicial+(columna*i)] != null ){
                  System.out.println("Hay un enemigo es: "+(filaInicial+(fila*i))+","+(columnaInicial+(columna*i)));
                  break; // Como hay ficha entonces rompemos, aunque aqui podriamos aprovechar para mandar a ENEMIGO
              }
              // como paso todas las restricciones entonces: lo añadiremos y miraremos de nuevo
            puntosValidos.add(new Point(filaInicial+(fila*i),columnaInicial+(columna*i)));
          }
      }
        return puntosValidos;
    }


    public synchronized void esperarCambio() throws InterruptedException {
        while (!tablero.getEstado()) {
            wait(); // Espera hasta que haya un cambio en el tablero
        }
        tablero.setEstado(false); // Restablece el estado
    }

}
