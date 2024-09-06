package game.util.fontCode;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontClass {


    private float tamFuente;
    private File fontStyle;
    @Getter
    private Font font;
    private static FontClass pixelFont;
    private static FontClass dogicaPixel;
    private static FontClass ppxl;

    public static FontClass getPixelFont() {
        if (pixelFont == null) {
            pixelFont = new FontClass(Fuente.PIXEL);
        }
        return pixelFont;
    }

    public static FontClass getDogicalFont() {
        if (dogicaPixel == null) {
            dogicaPixel = new FontClass(Fuente.DOGICA);
        }
        return dogicaPixel;
    }

    public static FontClass getPpxlFont() {
        if (ppxl == null) {
            ppxl = new FontClass(Fuente.PPXL);
        }
        return ppxl;
    }


    private FontClass(Fuente F) {
        try {
            fontStyle = new File("src/main/resources" + F.getSource());
            font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(54f);
        } catch (IOException | FontFormatException e) {
            System.out.println("Error fuentes: " + e.getMessage());
        } finally {
            System.out.println("font: " + font);
        }
    }

    public void setTamFuente(float i) {
        tamFuente = i;
        actualizar();
    }

    private void actualizar(){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(tamFuente);
        } catch (IOException | FontFormatException e) {
        }
    }

}
