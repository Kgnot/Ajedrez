package game.ui.render;

import game.core.logic.propiedades.*;
import game.ui.extra.Entity;
import game.ui.extra.entidades.OtherEntity;
import game.ui.extra.entidades.PeonEntity;

public class RenderFichas {
    private final int tam;

    public RenderFichas(int tam) {
        this.tam = tam;
    }

    public Entity renderImage(Tipo tipo, Color color, int posX, int posY) {
        String imagePath = getImagePath(tipo, color);
        var ficha = new OtherEntity(posX, posY, tam, imagePath);
        var fichaPeon = new PeonEntity(posX,posY,tam,imagePath);

        switch (tipo) {
            case REY -> {
                ficha.setImagenSelect(color.equals(Color.BLANCO)?"/iconos/pixelArt/blancos/select/PeonSelect.png": "/iconos/pixelArt/negros/select/peon.png");
                return ficha;
            }
            case REINA -> {
                ficha.setImagenSelect(color.equals(Color.BLANCO)?"/iconos/pixelArt/blancos/select/PeonSelect.png": "/iconos/pixelArt/negros/select/peon.png");
                return ficha;
            }
            case ALFIL -> {
                ficha.setImagenSelect(color.equals(Color.BLANCO)?"/iconos/pixelArt/blancos/select/PeonSelect.png": "/iconos/pixelArt/negros/select/peon.png");
                return ficha;
            }
            case TORRE -> {
                ficha.setImagenSelect(color.equals(Color.BLANCO)?"/iconos/pixelArt/blancos/select/PeonSelect.png": "/iconos/pixelArt/negros/select/peon.png");
                return ficha;
            }
            case CABALLO -> {
                ficha.setImagenSelect(color.equals(Color.BLANCO)?"/iconos/pixelArt/blancos/select/PeonSelect.png": "/iconos/pixelArt/negros/select/peon.png");
                return ficha;
            }
            case PEON -> {
                fichaPeon.setImagenSelect(color.equals(Color.BLANCO)?"/iconos/pixelArt/blancos/select/PeonSelect.png": "/iconos/pixelArt/negros/select/peon.png");
                return fichaPeon;
            }
        }
        return ficha;
    }

    private String getImagePath(Tipo tipo, Color color) {
        String basePath = "/iconos/pixelArt/";
        String colorPath = color.equals(Color.BLANCO) ? "blancos/" : "negros/";
        String fileName;

        switch (tipo) {
            case REY -> fileName = "Peon.png";
            case REINA -> fileName = "Peon.png";
            case ALFIL -> fileName = "Peon.png";
            case TORRE -> fileName = "Peon.png";
            case CABALLO -> fileName = "Caballo.png";
            case PEON -> fileName = "Peon.png";
            default -> throw new IllegalArgumentException("Tipo de ficha desconocido: " + tipo);
        }

        return basePath + colorPath + fileName;
    }
}
