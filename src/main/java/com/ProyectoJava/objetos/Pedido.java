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

    int getIdPedido(){
        return idPedido;
    }
    ArrayList<LineaPedido> getPedido(){
        return pedido;
    }

    public void asignarId(){
        contadorPedidos++;
        this.idPedido = contadorPedidos;
    }

    public void agregarProducto(int idProducto, int cantidadPedida){
        RepositorioProducto repositorioProducto = RepositorioProducto.getInstancia();
        Producto productoPedido = repositorioProducto.buscarProductoPorId(idProducto);
        if(productoPedido == null){
            System.out.println("No se encontro el producto agregado");
            return;
        }
        String nombreProducto = productoPedido.getNombre();
        if(repositorioProducto.hayStock(idProducto, cantidadPedida)){
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
        RepositorioPedidos.getInstancia().agregarPedido(this);
    }

    public void mostrarPedido(){
        for(LineaPedido lp : pedido){
            System.out.println("Producto: " + lp.getProducto().getNombre() + "Cantidad: " + lp.getCantidad());
        }
        System.out.println("Costo total: " + calcularCosto());
    }
}
