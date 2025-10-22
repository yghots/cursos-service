package com.service.cursos_service.service;

import com.service.cursos_service.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    String AgregarCurso(Curso curso);
    Optional<Curso> obtenerCurso(Long id);
    String EliminarCurso(Curso curso);
    String EditarCurso(Curso curso);
    List<Curso> obtenerCursos();
}
