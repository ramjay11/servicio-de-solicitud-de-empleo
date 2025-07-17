package com.ramjava.empleado.sistemico.atras.entidad;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @Entity
public class Empleado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_depila", nullable = false)
    private String nombreDepila;
    @Column(name = "apellido_depila", nullable = false)
    private String apellidoDepila;
    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;
}
