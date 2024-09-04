package game.network;

import game.core.logic.Fichas;
import game.core.logic.fichas.Alfil;
import game.core.logic.propiedades.Color;
import game.core.logic.propiedades.Tipo;
import game.model.Modelo;
import game.util.CipherUtility;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Cliente {

    private int PUERTO = 1234;
    private String HOST =  "192.168.1.5";
    private Socket sc;
    private OutputStreamWriter out;
    private BufferedReader in;
    private static Cliente instanceCliente;
    // Va a tener un modelo momentaniamente :
    private Modelo modelo;

    public  Cliente(Modelo modelo) {
        this.modelo = modelo;
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
                        //
                        Object [] datos = CipherUtility.getInstance().decryptMensajeFicha(msj);
                        System.out.println(datos);
                        if(datos !=null){
                            Point ini = (Point) datos[1];
                            Point fin =(Point) datos[2];
                            modelo.getTablero().getGestorMovimientosAjedrez().setFichaSimple(ini,fin);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al recibir mensajes: " + e.getMessage());
                }
            }).start();

        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    // Momentanio toca quitarlo:


    public void enviar(String msj){
        try {
            String mensaje = "Henry1:" + msj; // destinatario
            out.write(mensaje + "\n");  // Envía el mensaje terminado en nueva línea
            out.flush();
        }catch (Exception e){
            System.out.println("problema del mensaje: "+e);
        }
    }
}
