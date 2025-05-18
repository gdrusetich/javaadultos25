package com.ProyectoJava.objetos;

import excepciones.NoHayStockException;

public class Producto {
    public Producto(String unNombre, double unPrecio, int unStock){
        contadorProductos++;
        this.idProducto = contadorProductos;
        this.nombre = unNombre;
        this.precio = unPrecio;
        this.stock = unStock;
    }

    private static int contadorProductos = 0;

    private int idProducto;
    private String nombre;
    private double  precio;
    private int stock;

    public void descontarStock(int cantidad) throws NoHayStockException {
        if(this.getStock()<cantidad){
            throw new NoHayStockException("No hay stock de: "+ this.getNombre());
        }
        this.stock -=cantidad;
    }

    public int getId(){return this.idProducto;}
    public String getNombre(){return this.nombre;}
    public double getPrecio( ){return this.precio;}
    public int getStock( ){return this.stock;}

    public void setNombre(String nuevoNombre){this.nombre = nuevoNombre;}
    public void setPrecio(double nuevoPrecio){this.precio = nuevoPrecio;}
    public void setStock(int nuevoStock){this.stock = nuevoStock;}




    public void mostrarInfo(){
        System.out.println("Identificador: "+this.idProducto);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Stock: " + this.stock);
        System.out.println("__________________");
    }

    double precioConDescuento(){
        return precio - precio * 0.2;
    }

    String capitalize(){
        String textoMinuscula = nombre.toLowerCase();
        String textoSinEspacios = textoMinuscula.trim();
        String[] palabras = textoSinEspacios.split(" ");
        String resultado = "";
        for(int i = 0; i<palabras.length; i++){
            String palabra = palabras[i];
            resultado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1) + " ";
        }
        return resultado;
    }

}
