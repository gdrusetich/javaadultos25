package com.ProyectoJava.objetos;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    int idPedido;
    ArrayList<LineaPedido> pedido = new ArrayList<>();
    public static int contadorPedidos = 0;
    public void Pedido(){

    }

    Scanner scanner = new Scanner(System.in);

    public void agregarProducto(String nombreProducto, int cantidadPedida){
        RepositorioProducto repositorioProducto = RepositorioProducto.getInstancia();
        Producto productoPedido = repositorioProducto.buscarProducto(nombreProducto);
        if(repositorioProducto.hayStock(nombreProducto, cantidadPedida)){
            LineaPedido unaLineaPedido = new LineaPedido(productoPedido, cantidadPedida);
            pedido.add(unaLineaPedido);
            System.out.println("Se agregaron " + cantidadPedida + " " + nombreProducto);
        } else {
            System.out.println("Sólo quedan " + productoPedido.getStock() + " " + nombreProducto);
        }
    }

    public int calcularCosto(){
        int costoTotal = 0;
        for(LineaPedido lp : pedido){
            costoTotal += lp.getPrecio();
        }
        return costoTotal;
    }

    public void confirmarPedido(){
        for(LineaPedido lp : pedido){
            lp.getProducto().descontarStock(lp.getCantidad());
        }
        contadorPedidos++;
        this.idPedido += contadorPedidos;
        RepositorioPedido.getInstancia().agregarPedido(this);
    }

    public void mostrarPedido(){
        for(LineaPedido lp : pedido){
            System.out.println("Producto: " + lp.getProducto().getNombre());
            System.out.println("Producto: " + lp.getCantidad());
        }
        System.out.println("Costo total: " + calcularCosto());
    }
}
