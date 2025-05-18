package com.ProyectoJava.objetos;
import java.util.ArrayList;
import java.util.Scanner;


public class RepositorioProducto {
    private static RepositorioProducto repositorioProducto;
    ArrayList<Producto> todosLosProductos = new ArrayList<>();

    private RepositorioProducto() {}

    public static RepositorioProducto getInstancia() {
        if (repositorioProducto == null) {
            repositorioProducto = new RepositorioProducto();
        }
        return repositorioProducto;
    }

    public void agregarProducto(Producto unProducto){
        this.todosLosProductos.add(unProducto);
    }

    public void mostrarTodosLosProductos(){
        for(Producto producto : todosLosProductos){
            producto.mostrarInfo();
        }
    }

    public Producto mostrarProducto(String nombre){
        for(Producto p : todosLosProductos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                p.mostrarInfo();
                return p;
            }
        }
        System.out.println("No se encontró el producto " + nombre);
        return null;
    }

    public Producto buscarProducto(String nombre){
        for(Producto p : todosLosProductos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        System.out.println("No se encontro el producto " + nombre);
        return null;
    }

    public Producto buscarProductoPorId(int id){
        for(Producto p : todosLosProductos){
            if(p.getId() == id) {
                return p;
            }
        }
        System.out.println("No se encontro el producto con el ID" + id);
        return null;
    }

    public boolean existeProducto(String nombre){
        for(Producto p : todosLosProductos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }

    public boolean hayStock(int idProductoSolicitado, int stockSolicitado){
        Producto productoEncontrado = this.buscarProductoPorId(idProductoSolicitado);
        if(productoEncontrado.getStock() >= stockSolicitado){
            return true;
        } else {
            return false;
        }
    }

    public void eliminarProductoPorId(int id){
        for(Producto p : todosLosProductos){
            if(p.getId() == id){
                p.mostrarInfo();
                System.out.println("Desea eliminar el producto?");
                System.out.println("Ingrese S para CONFIRMAR, y otra cosa para CANCELAR.");
                Scanner scanner = new Scanner(System.in);
                String confirmacion = scanner.nextLine();
                if(confirmacion.equalsIgnoreCase("S")){
                    todosLosProductos.remove(p);
                    System.out.println("Se eliminó el producto" + p.getNombre());
                    break;
                }
            }
        }
    }

}
