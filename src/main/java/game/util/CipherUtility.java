package game.util;

import java.awt.*;

public class CipherUtility {

    private static CipherUtility cipherUtility;
    private CipherUtility(){}

    public static CipherUtility getInstance(){
        if(cipherUtility == null){
            cipherUtility = new CipherUtility();
        }
        return cipherUtility;
    }

    public String encryptMensajeFicha(Point inicial, Point f){
        return inicial.x +"|"+inicial.y+";"+f.x+"|"+f.y;
    }

    public Object[] decryptMensajeFicha(String mensaje){
        String[] datos = mensaje.split(";");
        if(datos.length < 2) return null;
        String pInicialSTR = datos[1];
        String pFinalSTR = datos[2];

        int ix = Integer.parseInt(pInicialSTR.split("\\|")[0]);
        int iy =Integer.parseInt( pInicialSTR.split("\\|")[1]);
        int fx =Integer.parseInt( pFinalSTR.split("\\|")[0]);
        int fy =Integer.parseInt( pFinalSTR.split("\\|")[1]);

        int[] p1 =cambioPerspectiva(ix,iy);
        int[] p2 = cambioPerspectiva(fx,fy);
        return new Object[]{new Point(p1[0],p1[1]), new Point(p2[0],p2[1])};
    }


    private int[] cambioPerspectiva(int fila, int columna){
        int max = 7;
        return new int[]{max-fila,max-columna};
    }

}
