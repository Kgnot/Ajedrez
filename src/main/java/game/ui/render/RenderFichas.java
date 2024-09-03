package game.ui.render;

import game.core.logic.fichas.*;
import game.core.logic.propiedades.*;
import game.ui.extra.Entity;
import game.ui.extra.FichaEntity;

public class RenderFichas {
    private final int tam;

    public RenderFichas(int tam) {
        this.tam = tam;
    }

    public Entity renderImage(Tipo tipo, Color color, int posX, int posY) {
        String imagePath = getImagePath(tipo, color);
        var ficha = new FichaEntity(posX, posY, tam, imagePath);
        switch (tipo) {
            case REY -> ficha.setFicha(new Rey(color));
            case REINA -> ficha.setFicha(new Reina(color));
            case ALFIL -> ficha.setFicha(new Alfil(color));
            case TORRE -> ficha.setFicha(new Torre(color));
            case CABALLO -> ficha.setFicha(new Caballo(color));
            case PEON -> ficha.setFicha(new Peon(color));
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
            case CABALLO -> fileName = "Peon.png";
            case PEON -> fileName = "Peon.png";
            default -> throw new IllegalArgumentException("Tipo de ficha desconocido: " + tipo);
        }

        return basePath + colorPath + fileName;
    }
}
