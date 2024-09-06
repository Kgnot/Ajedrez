package game.core.controller;


import game.network.Usuario;
import game.network.conectDB.ConnectDB;
import game.ui.view.juego.JuegoVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerJuegoVista implements ActionListener {

    private JuegoVista game;

    public ControllerJuegoVista(JuegoVista game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var login = game.getInicioLogin1();

        if (e.getSource().equals(login.getIngresar())) {
            ConnectDB dB = ConnectDB.getInstanceDataBase();

            String user = login.getTF_User().getText();
            String pass = String.copyValueOf(login.getTF_Password().getPassword());
            System.out.println("pass: " + pass);
            if (dB.validarUsuario(user, pass)) {
                game.CambiarPanelEleccion();
                game.getJUGADOR().setText(Usuario.getUser().getUsuarioID());

            } else {
                System.out.println("No valido");
            }
        }

        if (e.getSource().equals(game.getNegras())) {
            game.cambiarPanelJuego();
            game.getModelo().inicioJuego(2);
            game.getModelo().getCliente(); // Iniciamos la conexion, pero debemos poner propiedades del juego y leerlas o mandarlas como: -> Que ficha escogera?
        }
        if (e.getSource().equals(game.getBlancas())) {
            game.cambiarPanelJuego();
            game.getModelo().inicioJuego(1);
            game.getModelo().getCliente(); // Iniciamos la conexion, pero debemos poner propiedades del juego y leerlas o mandarlas como: -> Que ficha escogera?

        }



    }
}
