package com.ProyectoJava.objetos;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    boolean salir = false;
    //menu.mostrarMenu();

    while(!salir){
        menu.mostrarMenu();
        int opcionElegida = Integer.parseInt(scanner.nextLine());

        switch(opcionElegida){
            case 1 :
                System.out.println("Ingrese el nombre del Producto");
                String nombreDelProducto = scanner.nextLine();

                System.out.println("Ingrese el precio del Producto");
                double precioDelProducto = scanner.nextDouble();
                scanner.nextLine(); // Limpia el buffer

                System.out.println("Ingrese el stock del Producto");
                int stockDelProducto = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer

                Producto nuevoProducto = new Producto(nombreDelProducto, precioDelProducto, stockDelProducto);
                RepositorioProducto.getInstancia().agregarProducto(nuevoProducto);
                break;
            case 2:
                RepositorioProducto.getInstancia().mostrarTodosLosProductos();
                break;
            case 3:
                System.out.println("Ingrese el nombre del producto a actualizar");
                String nombreProducto = scanner.nextLine();
                //scanner.nextLine();
                Producto producto = RepositorioProducto.getInstancia().buscarProducto(nombreProducto);
                if(producto != null){
                    System.out.println("Ingrese su nuevo nombre");
                    String nuevoNombre = scanner.nextLine();
                    //scanner.nextLine();

                    System.out.println("Ingrese su nuevo precio");
                    double nuevoPrecio = scanner.nextDouble();
                    //scanner.nextLine();

                    System.out.println("Ingrese su nuevo stock");
                    int nuevoStock = scanner.nextInt();
                    scanner.nextLine();

                    producto.setNombre(nuevoNombre);
                    producto.setPrecio(nuevoPrecio);
                    producto.setStock(nuevoStock);
                    break;
                } else {
                    System.out.println("No se encontró el producto");
                    break;
                }
            case 4:
                System.out.println("Ingrese el Id del producto a eliminar");
                int idProducto = scanner.nextInt();
                scanner.nextLine();
                    RepositorioProducto.getInstancia().eliminarProductoPorId(idProducto);
                break;
            case 5:
                RepositorioPedidos.getInstancia().nuevoPedido();
                break;
            case 7:
                salir = true;
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
