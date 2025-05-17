package com.ProyectoJava.objetos;

public class LineaPedido {
    Producto producto;
    int cantidad;
    public LineaPedido(Producto unProducto, int unaCantidad){
        this.producto = unProducto;
        this.cantidad = unaCantidad;
    }

    public Producto getProducto(){return this.producto;}
    public int getCantidad(){return this.cantidad;}
    public double getPrecio(){return this.producto.getPrecio() * this.cantidad;}
}
