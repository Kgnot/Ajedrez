package game.render;

import game.core.logic.propiedades.Color;
import game.core.logic.propiedades.Tipo;

public class RenderFichas {
    public RenderFichas() {}
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
