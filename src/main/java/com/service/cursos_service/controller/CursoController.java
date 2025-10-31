package com.service.cursos_service.controller;


import com.service.cursos_service.model.Curso;
import com.service.cursos_service.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    @GetMapping("/cursos/listar")
    public List<Curso> ListarCurso(){
        try{
            return cursoService.obtenerCursos();
        }
        catch(Exception ex)
        {
            return  List.of();
        }
    }


}
