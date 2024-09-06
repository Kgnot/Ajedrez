package game.network;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Usuario {

    private String usuarioID;
    private String password;
    private String lastName;
    private String firstName;
    private static Usuario user;

    public static Usuario getUser(){
        if(user == null){
            user = new Usuario();
        }
        return user;
    }

    private Usuario(){

    }


}
