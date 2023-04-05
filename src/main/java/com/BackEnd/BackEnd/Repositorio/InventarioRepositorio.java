package com.BackEnd.BackEnd.Repositorio;

import com.BackEnd.BackEnd.Model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepositorio extends JpaRepository<Inventario,Long> {
}
