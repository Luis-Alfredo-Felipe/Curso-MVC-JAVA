/*
 * Crear Un programa utilizando CRUD, el programa debera enlazar con una tabla en MySQL, y realizar las siguentes operaciones
 * Consultas, Insertar, Eliminar, Modificar.......
 */
package conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis Alfredo Felipe Sic
 */
public class productoDAo {

    private conectar conecta;
    private ArrayList<conectar> codigo;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    conectar access = new conectar();

    public void lista() {
        String sql = "select * from producto";

        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("---------------------------------");
                System.out.println("Codigo: " + rs.getInt(1) + "\n"
                        + "Producto: " + rs.getString(2) + "\n"
                        + "Cantidad: " + rs.getInt(3) + "\n"
                        + "Manufactura: " + rs.getString(4) + "\n"
                        + "FechaIngreso: " + rs.getString(5));
            }

        } catch (SQLException e) {
            System.out.println("La Consulta ha Fallado......!");

        }

    }

    public void eliminar(int codigo) {
        String sql = "delete from producto where Codigo=?";
        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public void insert(int codigo, String producto, int cantidad, String manufactura, String fechaingreso) {
        String sql = "insert into producto(Codigo, Producto, Cantidad, Manufactura, FechaIngreso)values(?,?,?,?,?);";
        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, producto);
            ps.setInt(3, cantidad);
            ps.setString(4, manufactura);
            ps.setString(5, fechaingreso);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error de codigo");
        }
    }

    public void modificar(int codigo, String producto, int cantidad, String manufactura, String fechaingreso) {
        String sql = "update producto set Producto=?, Cantidad=?, Manufactura=?, FechaIngreso=? where Codigo =?;";
        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            ps.setString(1, producto);
            ps.setInt(2, cantidad);
            ps.setString(3, manufactura);
            ps.setString(4, fechaingreso);
            ps.setInt(5, codigo);
            ps.executeUpdate();

        } catch (SQLException e) {

        }
    }

}
