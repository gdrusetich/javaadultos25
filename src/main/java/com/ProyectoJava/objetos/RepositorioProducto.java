package com.ProyectoJava.objetos;
import excepciones.ProductoNoExistenteException;
import excepciones.ProductoYaExistenteException;

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

    public void agregarProducto(Producto unProducto) throws ProductoYaExistenteException {
        for(Producto productoExistente : todosLosProductos){
            if(productoExistente.getNombre().equalsIgnoreCase(unProducto.getNombre())){
                throw new ProductoYaExistenteException("Ya existe un producto con ese nombre.");
            }
        }
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

    public Producto buscarProducto(String nombre) throws ProductoNoExistenteException{
        for(Producto p : todosLosProductos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    public Producto buscarProductoPorId(int id) throws ProductoNoExistenteException{
        for(Producto p : todosLosProductos){
            if(p.getId() == id) {
                return p;
            }
        }
        {
        throw new ProductoNoExistenteException("No existe el producto con Id: " + id);
        }
    }

    public boolean existeProducto(String nombre){
        for(Producto p : todosLosProductos){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }

    public boolean hayStock(int idProductoSolicitado, int stockSolicitado) throws ProductoNoExistenteException{
        Producto productoEncontrado = this.buscarProductoPorId(idProductoSolicitado);
        if(productoEncontrado.getStock() >= stockSolicitado){
            return true;
        } else {
            return false;
        }
    }

    public void eliminarProductoPorId(int id) throws ProductoNoExistenteException {
        Producto productoAEliminar = RepositorioProducto.getInstancia().buscarProductoPorId(id);
        if(productoAEliminar == null){
            throw new ProductoNoExistenteException("No existe ese producto");
        }
        productoAEliminar.mostrarInfo();
        System.out.println("Desea eliminar el producto?");
        System.out.println("Ingrese 'si' para CONFIRMAR, y otra cosa para CANCELAR.");
        Scanner scanner = new Scanner(System.in);
        String confirmacion = scanner.nextLine();
        if(confirmacion.equalsIgnoreCase("si")){
            todosLosProductos.remove(productoAEliminar);
            System.out.println("Se eliminó el producto: " + productoAEliminar.getNombre());
        }
    }

}
