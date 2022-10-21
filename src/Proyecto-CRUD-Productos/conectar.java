package Bodega;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectar {

    Connection conect;
    String url = "jdbc:mysql://localhost:3306/inventario";
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
        conectar cn = new conectar();
        System.out.println(cn.Conectar());
    }

}
