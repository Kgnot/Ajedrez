package game.network;

import lombok.Setter;

@Setter
public class Usuario {

    @Setter
    private String usuarioID;
    @Setter
    private String password;
    @Setter
    private String lastName;
    @Setter
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
