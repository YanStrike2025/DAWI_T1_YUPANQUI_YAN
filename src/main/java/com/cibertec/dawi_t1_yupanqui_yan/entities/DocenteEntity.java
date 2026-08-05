package com.cibertec.dawi_t1_yupanqui_yan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "docente")
@NoArgsConstructor
@AllArgsConstructor
public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String especialidad;
    private LocalDate fechaIngreso;
}
