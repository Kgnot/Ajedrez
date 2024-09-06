package game.network.conectDB;

import game.network.Usuario;

import java.sql.*;

public class ConnectDB {

    private static Connection dataBase = null;
    private Statement st = null;

    private final String url, user, password;

    private static ConnectDB instanceDataBase; // creamos una instancia

    private static Usuario USUARIO;

    public static ConnectDB getInstanceDataBase() {
        USUARIO = Usuario.getUser();
        if (instanceDataBase == null) {
            instanceDataBase = new ConnectDB();
        }
        return instanceDataBase;
    }

    private ConnectDB() {
        url = "jdbc:postgresql://ep-small-water-a5aw25g6.us-east-2.aws.neon.tech/ChessGame?user=ChessGame_owner&password=XsyjWox8dNq4&sslmode=require";
        user = "ChessGame_owner";
        password = "XsyjWox8dNq4";
        try {
            dataBase = DriverManager.getConnection(url);
        } catch (SQLException sql) {
            System.out.println("exception: (ConnectDB) - " + sql);
        }
    }

    public boolean validarUsuario(String user, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM USUARIOS WHERE UsuarioID = ? AND password  = ? ";
        try {
            ps = dataBase.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            //Result set:
            rs = ps.executeQuery();
            while (rs.next()) {
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                USUARIO.setUsuarioID(user);
                USUARIO.setPassword(password);
                USUARIO.setFirstName(firstName);
                USUARIO.setLastName(lastName);

                System.out.println("Dentro BD: " + USUARIO.getUsuarioID());
                return true;
            }

            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return false;
    }

}
