package com.ramjava.empleado.sistemico.atras;

import com.ramjava.empleado.sistemico.atras.entidad.Empleado;
import com.ramjava.empleado.sistemico.atras.servicio.ServicioAlEmpleado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpleadoSistemicoAtrasApplication implements CommandLineRunner {

	private final ServicioAlEmpleado servicioAlEmpleado;

	public EmpleadoSistemicoAtrasApplication(ServicioAlEmpleado servicioAlEmpleado) {
		this.servicioAlEmpleado = servicioAlEmpleado;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmpleadoSistemicoAtrasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Empleado empleado1 = Empleado.builder()
				.nombreDepila("Mowkree")
				.apellidoDepila("Saint")
				.correoElectronico("mowkree.saint@yahoo.com")
				.build();

		Empleado empleado2 = Empleado.builder()
				.nombreDepila("Mowreo")
				.apellidoDepila("Saint")
				.correoElectronico("mowreo.saint@yahoo.com")
				.build();
		servicioAlEmpleado.guardarEmpleado(empleado1);
		servicioAlEmpleado.guardarEmpleado(empleado2);
	}
}
