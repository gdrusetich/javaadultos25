package com.ProyectoJava.objetos;

public class Comida extends Producto{
    int pesoGramos;

    public Comida(String nombre, double precio, int stock, int pesoGramos){
        super(nombre, precio, stock);
        this.pesoGramos = pesoGramos;
    }


}