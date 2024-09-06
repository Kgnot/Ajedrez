package game.network;

import game.model.Modelo;
import game.util.CipherUtility;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Cliente {

    private static final int PUERTO = 1234;
    private final String HOST = "192.168.1.5";
    private Socket sc;
    private OutputStreamWriter out;
    private BufferedReader in;
    private static Cliente instanceCliente;
    // Va a tener un modelo momentáneamente:
    private final Modelo modelo;

    public Cliente(Modelo modelo) {
        this.modelo = modelo;
        try {
            sc = new Socket(HOST, PUERTO);
            out = new OutputStreamWriter(sc.getOutputStream());
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));  // esto es extraño pero no tanto
            out.write(Usuario.getUser().getUsuarioID()+"\n"); // Escribe y pasa el "id"
            out.flush(); // Para enviar
            // Hilo para escuchar:
            escuchar();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Momenta toca quitarlo:
    private void escuchar() {
        new Thread(() -> {
            try {
                String msj;
                while ((msj = in.readLine()) != null) {
                    System.out.println("RECIBI EL MENSAJE: "+msj);
                    Object[] datos = CipherUtility.getInstance().decryptMensajeFicha(msj);
                    if (datos != null) {
                        Point ini = (Point) datos[0];
                        Point fin = (Point) datos[1];
                        System.out.println(ini.toString()+fin.toString());
                        modelo.getTablero().getGestorMovimientosAjedrez().setFichaSimple(ini, fin);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al recibir mensajes: " + e.getMessage());
            }
        }).start();
    }

    public void enviar(String msj) {
        try {
            String mensaje = Usuario.getUser().getUsuarioID()+":"+ msj; // destinatario del mensaje que de hecho me lo deberia pasar el sistema, ¿Contra quíen juego??
            out.write(mensaje + "\n");  // Envía el mensaje terminado en nueva línea
            out.flush();
        } catch (Exception e) {
            System.out.println("problema del mensaje: " + e);
        }
    }
}
