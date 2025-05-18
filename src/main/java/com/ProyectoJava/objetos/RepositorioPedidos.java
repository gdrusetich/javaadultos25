package com.ProyectoJava.objetos;
import excepciones.NoHayStockException;
import excepciones.ProductoNoExistenteException;

import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioPedidos {
    private static RepositorioPedidos repositorioPedidos;
    ArrayList<Pedido> todosLosPedidos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private RepositorioPedidos() {
    }

    public static RepositorioPedidos getInstancia() {
        if (repositorioPedidos == null) {
            repositorioPedidos = new RepositorioPedidos();
        }
        return repositorioPedidos;
    }

    public void agregarPedido(Pedido pedidoConfirmado){
        this.todosLosPedidos.add(pedidoConfirmado);
    }

    public Pedido nuevoPedido() throws NoHayStockException, ProductoNoExistenteException {
        boolean finPedido = false;
        Pedido nuevoPedido = new Pedido();
        while(finPedido!=true){
            System.out.println("Ingrese el ID del producto que desea agregar.");
            int idProducto = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese la cantidad.");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            try {
                nuevoPedido.agregarProducto(idProducto, cantidad);
            }
            catch(ProductoNoExistenteException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Desea otro producto? [si/no]");
            String agregarMasProductos = scanner.nextLine();
            //scanner.nextLine();

            if(agregarMasProductos.equalsIgnoreCase("no")){
                finPedido = true;
            }
        }
        System.out.println("¿Desea confirmar el siguiente pedido? [si/no]");
        nuevoPedido.mostrarPedido();
        String confirmarPedido = scanner.nextLine();
        scanner.nextLine();
        if(confirmarPedido.equalsIgnoreCase("no")){
            return null;
        }
        confirmarPedido(nuevoPedido);
        return nuevoPedido;
    }

    public void confirmarPedido(Pedido pedidoAConfirmar) throws NoHayStockException{
        for(LineaPedido lp : pedidoAConfirmar.getPedido()){
            try{
                lp.getProducto().descontarStock(lp.getCantidad());
                pedidoAConfirmar.asignarIdPedido();
            }
            catch(NoHayStockException e){
                e.getMessage();
            }
        }
        pedidoAConfirmar.asignarId();
        RepositorioPedidos.getInstancia().agregarPedido(pedidoAConfirmar);
    }

    public void mostrarTodosLosPedidos(){
        for(Pedido pedido: todosLosPedidos){
            pedido.mostrarPedido();
        }
    }
}