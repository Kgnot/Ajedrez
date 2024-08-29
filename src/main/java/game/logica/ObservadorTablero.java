package game.logica;


public class ObservadorTablero {

    private final Tablero tablero;

    public ObservadorTablero(Tablero tablero){
        this.tablero = tablero;
    }


    public synchronized void esperarCambio() throws InterruptedException {
        while(!tablero.getEstado()) {
            wait(); // Espera hasta que haya un cambio en el tablero
        }
        tablero.setEstado(false); // Restablece el estado
    }

}
