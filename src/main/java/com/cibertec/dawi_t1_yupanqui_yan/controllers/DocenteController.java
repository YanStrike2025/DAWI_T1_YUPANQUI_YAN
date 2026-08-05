package com.cibertec.dawi_t1_yupanqui_yan.controllers;

import com.cibertec.dawi_t1_yupanqui_yan.models.Docente;
import com.cibertec.dawi_t1_yupanqui_yan.services.IDocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/docentes")
@RequiredArgsConstructor
@Tag(name = "Docentes", description = "Operaciones relacionadas con docentes")
public class DocenteController {
    private final IDocenteService docenteService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo docente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Docente registrado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<Docente> create(@RequestBody @Valid Docente docente){
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.create(docente));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un docente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Docente actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    })
    public ResponseEntity<Docente> update(@PathVariable Long id, @RequestBody @Valid Docente docente){
        Docente respuesta = docenteService.update(id, docente);
        if (respuesta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un docente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Docente encontrado"),
            @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    })
    public ResponseEntity<Docente> get(@PathVariable Long id){
        Docente respuesta = docenteService.get(id);
        if (respuesta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    @Operation(summary = "Obtener todos los docentes")
    @ApiResponse(responseCode = "200", description = "Lista de docentes")
    public ResponseEntity<List<Docente>> getAll(){
        return ResponseEntity.ok(docenteService.getAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un docente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Docente eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Docente no encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!docenteService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
