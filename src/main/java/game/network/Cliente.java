package game.network;

import java.io.*;
import java.net.Socket;

public class Cliente {

    private int PUERTO = 1234;
    private String HOST =  "192.168.1.5";
    private Socket sc;
    private OutputStreamWriter out;
    private BufferedReader in;
    private static Cliente instanceCliente;

    public  Cliente() {
        try{
            sc =  new Socket(HOST,PUERTO);
            out =  new OutputStreamWriter(sc.getOutputStream());
            in =  new BufferedReader(new InputStreamReader(sc.getInputStream()));  // esto es extraño pero no tanto

            out.write("Henry2\n");
            out.flush(); // Para enviar
            // Hilo para leer:
            new Thread(() -> {
                try {
                    String msj;
                    while ((msj = in.readLine()) != null) {

                        System.out.println("Mensaje recibido: " + msj);
                    }
                } catch (IOException e) {
                    System.out.println("Error al recibir mensajes: " + e.getMessage());
                }
            }).start();

        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    public void enviar(String msj){
        try {
            String mensaje = "Henry1:" + msj;
            out.write(mensaje + "\n");  // Envía el mensaje terminado en nueva línea
            out.flush();
        }catch (Exception e){
            System.out.println("problema del mensaje: "+e);
        }
    }
}
