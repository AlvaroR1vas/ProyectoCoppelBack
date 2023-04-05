package com.BackEnd.BackEnd.Controlador;

import com.BackEnd.BackEnd.Excepciones.EmpleadoNoEncontrado;
import com.BackEnd.BackEnd.Model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BackEnd.BackEnd.Repositorio.EmpleadoRepositorio;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoRepositorio EmpleadoRepositorio;
    @PostMapping("/RegistroEmpleado")
    Empleado newUser(@RequestBody Empleado newUser){
        return EmpleadoRepositorio.save(newUser);
    }

    @GetMapping("/Empleados")
    List<Empleado> getAllUsers(){
        return EmpleadoRepositorio.findAll();
    }


    @GetMapping("/Empleado/{id}")
    Empleado getUserById(@PathVariable Long id){
        return EmpleadoRepositorio.findById(id)
                .orElseThrow(()-> new EmpleadoNoEncontrado(id));
    }

    @PutMapping("/Empleado/{id}")
    Empleado updateUser(@RequestBody Empleado newUser,@PathVariable Long id){
        return EmpleadoRepositorio.findById(id)
                .map(Empleado ->{
                    Empleado.setNombre(newUser.getNombre());
                    Empleado.setApellido(newUser.getApellido());
                    Empleado.setPuesto(newUser.getPuesto());
                    return EmpleadoRepositorio.save(Empleado);
                }).orElseThrow(()-> new EmpleadoNoEncontrado(id));
    }

    @DeleteMapping("/Empleado/{id}")
    void deleteUser(@PathVariable Long id) {
        if (!EmpleadoRepositorio.existsById(id)) {
            throw new EmpleadoNoEncontrado(id);
        }
        EmpleadoRepositorio.deleteById(id);
    }


}
