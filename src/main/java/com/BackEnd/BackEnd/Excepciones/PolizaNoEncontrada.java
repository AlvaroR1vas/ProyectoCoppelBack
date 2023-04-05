package com.BackEnd.BackEnd.Excepciones;

public class PolizaNoEncontrada extends RuntimeException{
    public PolizaNoEncontrada(Long id){
        super("No se pudo encontrar la poliza con el id: "+ id);
    }
}
