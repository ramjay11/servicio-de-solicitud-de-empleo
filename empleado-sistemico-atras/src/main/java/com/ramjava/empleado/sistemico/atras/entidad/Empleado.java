package com.ramjava.empleado.sistemico.atras.entidad;

import jakarta.persistence.*;
import lombok.*;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Empleado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_depila", nullable = false)
    private String nombreDepila;
    @Column(name = "apellido_depila", nullable = false)
    private String apellidoDepila;
    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    public Empleado() {}

    public Empleado(Long id, String nombreDepila, String apellidoDepila, String correoElectronico) {
        this.id = id;
        this.nombreDepila = nombreDepila;
        this.apellidoDepila = apellidoDepila;
        this.correoElectronico = correoElectronico;
    }

    public Long getId() {
        return id;
    }

    public String getNombreDepila() {
        return nombreDepila;
    }

    public String getApellidoDepila() {
        return apellidoDepila;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreDepila(String nombreDepila) {
        this.nombreDepila = nombreDepila;
    }

    public void setApellidoDepila(String apellidoDepila) {
        this.apellidoDepila = apellidoDepila;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Static builder
    public static EmpleadoBuilder builder() {
        return new EmpleadoBuilder();
    }

    public static class EmpleadoBuilder {
        private String nombreDepila;
        private String apellidoDepila;
        private String correoElectronico;

        public EmpleadoBuilder nombreDepila(String nombreDepila) {
            this.nombreDepila = nombreDepila;
            return this;
        }

        public EmpleadoBuilder apellidoDepila(String apellidoDepila) {
            this.apellidoDepila = apellidoDepila;
            return this;
        }

        public EmpleadoBuilder correoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return this;
        }

        public Empleado build() {
            return new Empleado(null, nombreDepila, apellidoDepila, correoElectronico);
        }
    }
}
