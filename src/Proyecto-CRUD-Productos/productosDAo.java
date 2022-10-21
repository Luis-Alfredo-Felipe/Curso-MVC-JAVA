package Bodega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class productosDAo {

    private conectar conecta;
    private ArrayList<conectar> codigo;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    conectar access = new conectar();

    public ArrayList lista() {
        String sql = "select * from productos";

        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<producto> datos = new ArrayList<producto>();

            while (rs.next()) {
                producto prod = new producto();
                prod.setCodigo(rs.getInt(1));
                prod.setProducto(rs.getString(2));
                prod.setCantidad(rs.getInt(3));
                prod.setManufactura(rs.getString(4));
                prod.setFechaingreso(rs.getString(5));
                datos.add(prod);
            }
            return datos;
//            
//            for(producto dato: datos){
//                System.out.println(dato.getCodigo());
//                System.out.println(dato.getProducto());
//            }

        } catch (SQLException e) {
            System.out.println("La Consulta ha Fallado......!");

        }

        return null;
    }

    public void crear(int codigo, String producto, int cantidad, String manufactura, String fechaingreso) {
        String sql = "insert into productos(Codigo,Producto,Cantidad,Manufactura,FechaIngreso) values (?,?,?,?,?);";
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
            System.out.println("La Funcion crear ha fallado!");
        }

    }

    public void modificar(int codigo, String producto, int cantidad, String manufactura, String fechaingreso) {
        String sql = "update productos set Producto=?, Cantidad=?, Manufactura=?, FechaIngreso=? where Codigo =?;";
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

    public void buscar(int codigo) {
        String sql = "select * from productos where codigo = " + codigo;
        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                modificar mod = new modificar();
                mod.mostrar(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                mod.setVisible(true);
            } else {
                System.out.println("Codigo Invalido");
            }

        } catch (SQLException e) {

        }

    }

    public void eliminar(int codigo) {
        String sql = "delete from productos where codigo=?";
        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void buscar_eliminar(int codigo) {
        String sql = "select * from productos where codigo = " + codigo;
        try {
            connect = access.Conectar();
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                eliminar del = new eliminar();
                del.t_codigo.setText(rs.getInt(1) + "");
                del.t_producto.setText(rs.getString(2));
                del.t_cantidad.setText(rs.getInt(3) + "");
                del.t_manufactura.setText(rs.getString(4));
                del.t_fechaingreso.setText(rs.getString(5));
                del.setVisible(true);

            } else {
                System.out.println("Codigo Invalido");
            }

        } catch (SQLException e) {

        }

    }

    public static void main(String[] args) {
//        productosDAo con = new productosDAo();        
//        con.lista();
    }

}
