package com.service.cursos_service.service.Implementacion;

import com.service.cursos_service.model.Curso;
import com.service.cursos_service.repository.CursoRepository;
import com.service.cursos_service.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;

    @Override
    public String AgregarCurso(Curso curso) {
        try{
            cursoRepository.save(curso);
            return "Curso agregado com sucesso";
        }
        catch(Exception ex)
            {
            return "Error al agregar curso";
            }
    }

    @Override
    public Optional<Curso> obtenerCurso(Long id) {
        try{
         return cursoRepository.findById(id);
        }
        catch(Exception ex) {
            return Optional.empty();
        }
    }

    @Override
    public String EliminarCurso(Curso curso) {
        try{
            cursoRepository.delete(curso);
            return "Curso eliminado com sucesso";
        }
        catch(Exception ex) {
            return "Error al eliminar curso";
        }
    }

    @Override
    public String EditarCurso(Curso curso) {
        try {
            Optional<Curso> optionalCurso = cursoRepository.findById(curso.getId());
            if(optionalCurso.isPresent()){
                cursoRepository.save(curso);
            return "Curso editado com sucesso";
            }
            else {
                return "El curso no se ah encontrado";
            }
        }
        catch(Exception ex) {
            return "Error al editar curso" + ex.getMessage();
        }
    }

    @Override
    public List<Curso> obtenerCursos() {
        try{
            return cursoRepository.findAll();
        }
        catch(Exception ex) {
            return List.of();
        }
    }
}
