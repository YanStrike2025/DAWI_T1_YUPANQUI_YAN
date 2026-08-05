package com.cibertec.dawi_t1_yupanqui_yan.models;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
    private Long id;
    @NotBlank
    @Size(min = 2, max = 100)
    private String nombres;
    @NotBlank
    @Size(min = 2, max = 100)
    private String apellidos;
    @NotBlank
    @Email
    private String correo;
    private String telefono;
    @NotBlank
    private String especialidad;
    private LocalDate fechaIngreso;
}
