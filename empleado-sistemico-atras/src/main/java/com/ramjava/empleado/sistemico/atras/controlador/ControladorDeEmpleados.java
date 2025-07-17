package com.ramjava.empleado.sistemico.atras.controlador;

import com.ramjava.empleado.sistemico.atras.entidad.Empleado;
import com.ramjava.empleado.sistemico.atras.servicio.ServicioAlEmpleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/empleados")
public class ControladorDeEmpleados {

    private final ServicioAlEmpleado servicioAlEmpleado;

    public ControladorDeEmpleados(ServicioAlEmpleado servicioAlEmpleado) {
        this.servicioAlEmpleado = servicioAlEmpleado;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerEmpleados() {
        List<Empleado> empleados = servicioAlEmpleado.obtenerEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {
        Empleado empleado = servicioAlEmpleado.obtenerEmpleado(id);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoGuardado = servicioAlEmpleado.guardarEmpleado(empleado);
        return new ResponseEntity<>(empleadoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empleadoActualizado = servicioAlEmpleado.actualizarEmpleado(empleado);
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Long id) {
        servicioAlEmpleado.eliminarEmpleado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
