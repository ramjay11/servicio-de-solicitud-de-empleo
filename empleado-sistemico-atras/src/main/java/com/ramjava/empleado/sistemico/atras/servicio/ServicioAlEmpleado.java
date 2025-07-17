package com.ramjava.empleado.sistemico.atras.servicio;

import com.ramjava.empleado.sistemico.atras.entidad.Empleado;
import com.ramjava.empleado.sistemico.atras.repositorio.RepositorioDeEmpleados;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioAlEmpleado {

    private final RepositorioDeEmpleados repositorioDeEmpleados;

    public ServicioAlEmpleado(RepositorioDeEmpleados repositorioDeEmpleados) {
        this.repositorioDeEmpleados = repositorioDeEmpleados;
    }

    public List<Empleado> obtenerEmpleados() {
        return repositorioDeEmpleados.findAll();
    }

    public Empleado obtenerEmpleado(Long id) {
        return repositorioDeEmpleados.findById(id).orElse(null);
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorioDeEmpleados.save(empleado);
    }

    public Empleado actualizarEmpleado(Empleado empleado) {
        return repositorioDeEmpleados.save(empleado);
    }

    public void eliminarEmpleado(Long id) {
        repositorioDeEmpleados.deleteById(id);
    }
}
