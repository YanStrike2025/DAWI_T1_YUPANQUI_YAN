package com.cibertec.dawi_t1_yupanqui_yan.repositories;

import com.cibertec.dawi_t1_yupanqui_yan.entities.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDocenteRepository extends JpaRepository<DocenteEntity, Long> {

    @Query("select docente from DocenteEntity docente where docente.id = ?1")
    Optional<DocenteEntity> searchById(Long id);

}
