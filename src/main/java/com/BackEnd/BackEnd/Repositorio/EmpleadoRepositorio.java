package com.BackEnd.BackEnd.Repositorio;

import com.BackEnd.BackEnd.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {
}
