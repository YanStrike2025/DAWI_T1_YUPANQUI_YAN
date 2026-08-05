package com.cibertec.dawi_t1_yupanqui_yan.services;

import com.cibertec.dawi_t1_yupanqui_yan.models.Docente;

import java.util.List;

public interface IDocenteService {
    Docente create(Docente docente);
    Docente update(Long id, Docente docente);
    Docente get(Long id);
    List<Docente> getAll();
    boolean delete(Long id);
}
