/*
 * Crear Un programa utilizando CRUD, el programa debera enlazar con una tabla en MySQL, y realizar las siguentes operaciones
 * Consultas, Insertar, Eliminar, Modificar.......
 */
package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Alfredo Felipe Sic
 */
public class conectar {

    Connection conect;
    String url = "jdbc:mysql://localhost:3306/product";
    String user = "root";
    String pass = "";

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }
        return conect;
    }

    public static void main(String[] args) {
        conectar sp = new conectar();
        System.out.println(sp.Conectar());
    }

}
