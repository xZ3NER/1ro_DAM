package JDBC.loginCodigoSucio;

import java.sql.*;

public class loginTest {

    public static void main(String[] args) {
        new frame();

    }

    public String dataBaseConnect(String username) {
        String password="null";

        try {
            //Cargamos el driver de la base de datos (obligatorio)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection //Establecemos la conexion
                    ("jdbc:mysql://u5bsdwo4zmgawi7a:gZkHKbhadadMUsp5hfVV@bk6wxk7lwpjpx0tama9l-mysql.services.clever-cloud.com:3306/bk6wxk7lwpjpx0tama9l",
                            "u5bsdwo4zmgawi7a", "u5bsdwo4zmgawi7a");
            //asignamos la url, en nuestro caso la bbdd esta en localhost con puerto 3306 (por defecto)/ el nombre de la bbdd, y añadimos al final
            //?characterEncoding=utf8&serverTimezone=UTC para evitar errores de SQLException, el nombre del usuario (root), y su contraseña

            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("SELECT pwd FROM usuarios WHERE username LIKE '"+username+"'");

            if (resul.next()) {
                password = resul.getString(1);
            } else {
                password = "noAccount";
            }

            //Cerramos todas las sentencias (muy importante)
            resul.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException ec) {
            ec.printStackTrace();
        } catch (SQLException es) {
            es.printStackTrace();
        }

        return password;
    }
}
