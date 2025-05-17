package com.ProyectoJava.objetos;

public class Bebida extends Producto{
    private int volumenML;
    public Bebida(String nombre, double precio, int stock, int volumenML){
        super(nombre, precio, stock);
        this.volumenML = volumenML;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        this.nuevoMetodo();
        System.out.println("Volumen: " + this.volumenML);
    }

    private void nuevoMetodo(){
        System.out.println("Nuevo método");
    }

}

