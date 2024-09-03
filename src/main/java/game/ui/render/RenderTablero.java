package game.ui.render;

import game.model.Modelo;

public class RenderTablero extends Thread {
    private final Modelo modelo;

    public RenderTablero(Modelo modelo) {
        this.modelo = modelo;
    }

    public void dibujarTableroInicial() {
        var tablero = modelo.getTablero();
        var vistaTablero = modelo.getJuegoVista().getVistaTablero();
        int widthTablero = vistaTablero.getWidth();
        int tam = widthTablero / 8;
        RenderFichas rf = new RenderFichas(tam);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.getTablero()[i][j] != null) {
                    var ficha = tablero.getTablero()[i][j];
                    var tipo = ficha.getTipo();
                    var color = ficha.getColor();
                    int posX = tam * j ;
                    int posY = tam * i;
                    // Calcular posición central en la celda
                    var renderFicha = rf.renderImage(tipo,color,posX,posY);
                    vistaTablero.setEntidad(renderFicha); // lo añadimos
                }
            }
        }
    }


    @Override
    public void run() {
        //var gm = modelo.getTablero().getGestorMovimientosAjedrez();
        dibujarTableroInicial();
        // este debe ser un ciclo perpetuo mirando el tablero constante mente, entonces
        //
        //dibujar();
       /* while (true) {
            try {
                gm.esperarCambio(); // tengo que ver que hago con esto
            } catch (InterruptedException ignore) {
            }
        }*/
    }
}
