package com.BackEnd.BackEnd.Controlador;

import com.BackEnd.BackEnd.Excepciones.PolizaNoEncontrada;
import com.BackEnd.BackEnd.Model.Poliza;
import com.BackEnd.BackEnd.Repositorio.EmpleadoRepositorio;
import com.BackEnd.BackEnd.Repositorio.PolizaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class PolizaControlador {
    @Autowired
    private PolizaRepositorio PolizaRepositorio;
    private EmpleadoRepositorio EmpleadoRepositorio;
    @PostMapping("/RegistroPoliza")
    Poliza newUser(@RequestBody Poliza newUser){
        return PolizaRepositorio.save(newUser);
    }



    @GetMapping("/Poliza")
    List<Poliza> getAllUsers(){
        return PolizaRepositorio.findAll();
    }



    @GetMapping("/Poliza/{id}")
    Poliza getUserById(@PathVariable Long id){
        return PolizaRepositorio.findById(id)
                .orElseThrow(()-> new PolizaNoEncontrada(id));
    }

    @PutMapping("/Poliza/{id}")
    Poliza updateUser(@RequestBody Poliza newUser,@PathVariable Long id){
        return PolizaRepositorio.findById(id)
                .map(Poliza ->{
                    Poliza.setCantidad(newUser.getCantidad());
                    Poliza.setFecha(newUser.getFecha());
                    Poliza.setEmpleadogenero(newUser.getEmpleadogenero());
                    Poliza.setSku(newUser.getSku());
                    return PolizaRepositorio.save(Poliza);
                }).orElseThrow(()-> new PolizaNoEncontrada(id));

    }

    @DeleteMapping("/Poliza/{id}")
    void deleteUser(@PathVariable Long id) {
        if (!PolizaRepositorio.existsById(id)) {
            throw new PolizaNoEncontrada(id);
        }
        PolizaRepositorio.deleteById(id);

    }

}


