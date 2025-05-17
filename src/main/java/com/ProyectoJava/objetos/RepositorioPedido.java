package com.ProyectoJava.objetos;
import java.util.ArrayList;

public class RepositorioPedido {
    private static RepositorioPedido repositorioPedido;
    ArrayList<Pedido> todosLosPedidos = new ArrayList<>();

    private RepositorioPedido() {
    }

    public static RepositorioPedido getInstancia() {
        if (repositorioPedido == null) {
            repositorioPedido = new RepositorioPedido();
        }
        return repositorioPedido;
    }

    public void agregarPedido(Pedido pedido){

        todosLosPedidos.add(pedido);
    }
}
