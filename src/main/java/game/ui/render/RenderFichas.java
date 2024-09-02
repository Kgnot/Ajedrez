package game.ui.render;

import game.core.logic.propiedades.Color;
import game.core.logic.propiedades.Tipo;
import game.ui.extra.Entity;
import game.ui.extra.entidades.*;

public class RenderFichas {

    private int tam;

    public RenderFichas(int tam) {
        this.tam = tam;
    }

    public Entity renderImage(Tipo tipo, Color color, int posX, int posY) {
        if (color.equals(Color.BLANCO)) {
            switch (tipo) {
                case REY -> {
                    return new ReyBlanco(posX, posY, tam,"/iconos/pixelArt/blancos/Peon.gif");
                }
                case REINA -> {
                    return new ReinaBlanco(posX, posY, tam,"/iconos/pixelArt/blancos/Peon.gif");
                }
                case ALFIL -> {
                    return new AlfilBlanco(posX, posY,tam, "/iconos/pixelArt/blancos/Peon.gif");
                }
                case TORRE -> {
                    return new TorreBlanca(posX, posY, tam,"/iconos/pixelArt/blancos/Peon.gif");
                }
                case CABALLO -> {
                    return new CaballoBlanco(posX, posY, tam,"/iconos/pixelArt/blancos/Peon.gif");
                }
                case PEON -> {
                    return new PeonBlanco(posX, posY,tam, "/iconos/pixelArt/blancos/Peon.gif");
                }
            }
        } else {
            switch (tipo) {
                case REY -> {
                    return new ReyNegro(posX, posY,tam, "/iconos/pixelArt/blancos/Peon.gif");
                }
                case REINA -> {
                    return new ReinaNegro(posX, posY,tam, "/iconos/pixelArt/blancos/Peon.gif");
                }
                case ALFIL -> {
                    return new AlfilNegro(posX, posY,tam, "/iconos/pixelArt/blancos/Peon.gif");
                }
                case TORRE -> {
                    return new TorreNegra(posX, posY,tam, "/iconos/pixelArt/blancos/Peon.gif");
                }
                case CABALLO -> {
                    return new CaballoNegro(posX, posY,tam, "/iconos/pixelArt/negros/Caballo.png");
                }
                case PEON -> {
                    return new PeonNegro(posX, posY,tam,"/iconos/pixelArt/negros/Peon.png");
                }
            }
        }
        return null;
    }

}
