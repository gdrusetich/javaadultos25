package com.ProyectoJava.objetos;

import excepciones.NoHayStockException;
import excepciones.ProductoNoExistenteException;
import excepciones.ProductoYaExistenteException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ProductoNoExistenteException, NoHayStockException {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    boolean salir = false;
    //menu.mostrarMenu();

    while(!salir){
        menu.mostrarMenu();
        int opcionElegida = Integer.parseInt(scanner.nextLine());

        switch(opcionElegida){
            case 1 :
                System.out.println("Ingrese el nombre del Producto.");
                String nombreDelProducto = scanner.nextLine();

                System.out.println("Ingrese el precio del Producto.");
                double precioDelProducto = scanner.nextDouble();
                scanner.nextLine(); // Limpia el buffer

                System.out.println("Ingrese el stock del Producto.");
                int stockDelProducto = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer

                Producto nuevoProducto = new Producto(nombreDelProducto, precioDelProducto, stockDelProducto);
                try{
                RepositorioProducto.getInstancia().agregarProducto(nuevoProducto);
                } catch (ProductoYaExistenteException e) {
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            case 2:
                RepositorioProducto.getInstancia().mostrarTodosLosProductos();
                break;
            case 3:
                System.out.println("Ingrese el nombre del producto a actualizar.");
                String nombreProducto = scanner.nextLine();
                //scanner.nextLine();
                try{
                Producto producto = RepositorioProducto.getInstancia().buscarProducto(nombreProducto);
                    if(producto != null) {
                        System.out.println("Ingrese su nuevo nombre.");
                        String nuevoNombre = scanner.nextLine();
                        //scanner.nextLine();

                        System.out.println("Ingrese su nuevo precio.");
                        double nuevoPrecio = scanner.nextDouble();
                        //scanner.nextLine();

                        System.out.println("Ingrese su nuevo stock.");
                        int nuevoStock = scanner.nextInt();
                        scanner.nextLine();

                        producto.setNombre(nuevoNombre);
                        producto.setPrecio(nuevoPrecio);
                        producto.setStock(nuevoStock);
                        break;
                        }
                    } catch (ProductoNoExistenteException e){
                        e.getMessage();
                    }
                    break;

            case 4:
                System.out.println("Ingrese el Id del producto a eliminar.");
                int idProducto = scanner.nextInt();
                scanner.nextLine();
                try {
                    RepositorioProducto.getInstancia().eliminarProductoPorId(idProducto);
                    } catch(ProductoNoExistenteException e) {
                System.out.println("Error: "+e.getMessage());
            }
                break;
            case 5:
                try {
                    RepositorioPedidos.getInstancia().nuevoPedido();
                } catch (ProductoNoExistenteException productoNoexistente) {
                    System.out.println(productoNoexistente.getMessage());

                } catch (NoHayStockException noHayStock){
                    System.out.println(noHayStock.getMessage());
                }
                break;
            case 6:
                RepositorioPedidos.getInstancia().mostrarTodosLosPedidos();
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
