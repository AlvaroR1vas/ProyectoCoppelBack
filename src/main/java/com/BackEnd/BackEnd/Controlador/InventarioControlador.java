package com.BackEnd.BackEnd.Controlador;

import com.BackEnd.BackEnd.Excepciones.ProductoNoEncontrado;
import com.BackEnd.BackEnd.Model.Inventario;
import com.BackEnd.BackEnd.Repositorio.InventarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class InventarioControlador {
    @Autowired
    private InventarioRepositorio InventarioRepositorio;
    @PostMapping("/RegistroInventario")
    Inventario newUser(@RequestBody Inventario newUser){
        return InventarioRepositorio.save(newUser);
    }


    @GetMapping("/Inventario")
    List<Inventario> getAllUsers(){
        return InventarioRepositorio.findAll();
    }



    @GetMapping("/Inventario/{id}")
    Inventario getUserById(@PathVariable Long id){
        return InventarioRepositorio.findById(id)
                .orElseThrow(()-> new ProductoNoEncontrado(id));
    }

    @PutMapping("/Inventario/{id}")
    Inventario updateUser(@RequestBody Inventario newUser,@PathVariable Long id){
        return InventarioRepositorio.findById(id)
                .map(Inventario ->{
                    Inventario.setNombre(newUser.getNombre());
                    Inventario.setCantidad(newUser.getCantidad());
                    return InventarioRepositorio.save(Inventario);
                }).orElseThrow(()-> new ProductoNoEncontrado(id));

    }

    @DeleteMapping("/Inventario/{id}")
    void deleteUser(@PathVariable Long id) {
        if (!InventarioRepositorio.existsById(id)) {
            throw new ProductoNoEncontrado(id);
        }
        InventarioRepositorio.deleteById(id);
    }
}
