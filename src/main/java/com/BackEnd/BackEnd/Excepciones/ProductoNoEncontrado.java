package com.BackEnd.BackEnd.Excepciones;

public class ProductoNoEncontrado extends RuntimeException{
    public ProductoNoEncontrado(Long id){
        super("No se pudo encontrar el Producto con el id: "+ id);
    }

}
