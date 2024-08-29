package game.presentacion.vistas.render;

import game.logica.propiedades.Color;
import game.logica.propiedades.Tipo;

public class RenderFichas {

    private Tipo tipo;
    private Color color;

    public RenderFichas() {

    }

    public String renderImage(Tipo tipo, Color color) {
        if (color.equals(Color.BLANCO)) {
            switch (tipo) {
                case REY -> {
                    return "♔";
                }
                case REINA -> {
                    return "♕";
                }
                case ALFIL -> {
                    return "♗";
                }
                case TORRE -> {
                    return "♖";
                }
                case CABALLO -> {
                    return "♘";
                }
                case PEON -> {
                    return "♙";
                }
            }
        } else {
            switch (tipo) {
                case REY -> {
                    return "♚";
                }
                case REINA -> {
                    return "♛";
                }
                case ALFIL -> {
                    return "♝";
                }
                case TORRE -> {
                    return "♜";
                }
                case CABALLO -> {
                    return "♞";
                }
                case PEON -> {
                    return "♟";
                }
            }
        }
        return null;
    }


}
