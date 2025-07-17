package com.ramjava.empleado.sistemico.atras.repositorio;

import com.ramjava.empleado.sistemico.atras.entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDeEmpleados extends JpaRepository<Empleado, Long> {
}
