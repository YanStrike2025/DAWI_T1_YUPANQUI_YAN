package com.cibertec.dawi_t1_yupanqui_yan.services.implementation;

import com.cibertec.dawi_t1_yupanqui_yan.entities.DocenteEntity;
import com.cibertec.dawi_t1_yupanqui_yan.models.Docente;
import com.cibertec.dawi_t1_yupanqui_yan.repositories.IDocenteRepository;
import com.cibertec.dawi_t1_yupanqui_yan.services.IDocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteService implements IDocenteService { //Controller - Service - Repository | Model - Conversion - Entity
    private final IDocenteRepository iDocenteRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Docente create(Docente docente) {
        DocenteEntity docenteEntity = objectMapper.convertValue(docente, DocenteEntity.class);
        return objectMapper.convertValue(iDocenteRepository.save(docenteEntity), Docente.class);
    }

    @Override
    public Docente update(Long id, Docente docente) {
        if (!iDocenteRepository.existsById(id)) {
            return null;
        }
        DocenteEntity docenteEntity = objectMapper.convertValue(docente, DocenteEntity.class);
        docenteEntity.setId(id);
        return objectMapper.convertValue(iDocenteRepository.save(docenteEntity), Docente.class);
    }

    @Override
    public Docente get(Long id) {
        return objectMapper.convertValue(iDocenteRepository.searchById(id).orElse(null), Docente.class);
    }

    @Override
    public List<Docente> getAll() {
        return objectMapper.convertValue(iDocenteRepository.findAll(), new TypeReference<List<Docente>>() {
        });
    }

    @Override
    public boolean delete(Long id) {
        if (!iDocenteRepository.existsById(id)) {
            return false;
        }
        iDocenteRepository.deleteById(id);
        return true;
    }
}
