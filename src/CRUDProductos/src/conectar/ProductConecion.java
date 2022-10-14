/*
 * Crear Un programa utilizando CRUD, el programa debera enlazar con una tabla en MySQL, y realizar las siguentes operaciones
 * Consultar, Insertar, Eliminar, Modificar.......
 */
package conectar;

import java.util.Scanner;

/**
 *
 * @author Luis Alfredo Felipe Sic
 */
public class ProductConecion {

    Scanner entrada = new Scanner(System.in);
    productoDAo cp = new productoDAo();

    public void menu() {
        System.out.println("****************************");
        System.out.println(" Consultas Productos MySQL ");
        System.out.println("****************************");
        System.out.println(" 1- Consultar Producto" + "\n"
                + " 2- Insertar Productos" + "\n"
                + " 3- Modificar Producto" + "\n"
                + " 4- Eliminar Producto" + "\n"
                + " 5- Salir ");

        System.out.print("Ingrese una Opcion: ");
        int n1 = entrada.nextInt();
        switch (n1) {
            case 1:
                System.out.println("Lista de Productos");
                cp.lista();
                break;

            case 2:
                Boolean salir = true;
                do {
                    Scanner entrada2 = new Scanner(System.in);
                    System.out.print("Ingrese Codigo de Producto Nuevo : ");
                    int codigo = entrada2.nextInt();
                    entrada2.nextLine();
                    System.out.print("Nombre de producto: ");
                    String producto = entrada2.nextLine();
                    System.out.print("Cantidad de Producto: ");
                    int cantidad = entrada2.nextInt();
                    entrada2.nextLine();
                    System.out.print("Lugar de Manufactura: ");
                    String manufactura = entrada2.nextLine();
                    System.out.print("Fecha de Ingreso: ");
                    String fechaingreso = entrada2.nextLine();

                    cp.insert(codigo, producto, cantidad, manufactura, fechaingreso);

                    System.out.println("Desea Ingresar otro producto ?");
                    System.out.print("Ingresa 1 para continuar 0 para salir: ");
                    if (entrada2.nextInt() != 1) {
                        salir = false;
                    }

                } while (salir);
                break;

            case 3:
                System.out.println("Listado de Productos: ");
                cp.lista();
                System.out.println("------------------------------------------");
                System.out.print("Ingrese el codigo del producto a modificar: ");
                int seleccion = entrada.nextInt();
                entrada.nextLine();

                System.out.print("Nombre de producto: ");
                String producto = entrada.nextLine();
                System.out.print("Cantidad de Producto: ");
                int cantidad = entrada.nextInt();
                entrada.nextLine();
                System.out.print("Lugar de Manufactura: ");
                String manufact = entrada.nextLine();
                System.out.print("Fecha de Ingreso: ");
                String ingreso = entrada.nextLine();

                cp.modificar(seleccion, producto, cantidad, manufact, ingreso);
                break;

            case 4:
                System.out.println("Listado de Productos");
                cp.lista();

                System.out.print("Ingrese Codigo de producto a eliminar: ");
                cp.eliminar(entrada.nextInt());
                break;

            case 5:
                System.exit(0);
                break;

            default:
                throw new AssertionError();
        }

    }

    public static void main(String[] args) {
        ProductConecion Connectar = new ProductConecion();

        while (true) {
            Connectar.menu();
        }

    }

}
