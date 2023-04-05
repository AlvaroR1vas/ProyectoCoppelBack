package com.BackEnd.BackEnd.Excepciones;

public class EmpleadoNoEncontrado extends RuntimeException{
    public EmpleadoNoEncontrado(Long id){
        super("No se pudo encontrar el empleado con el id: "+ id);
    }

}
