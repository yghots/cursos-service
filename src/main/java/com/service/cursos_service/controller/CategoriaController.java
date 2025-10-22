package com.service.cursos_service.controller;

import com.service.cursos_service.model.Categoria;
import com.service.cursos_service.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoriaController  {
    private final CategoriaService categoriaService;

    @PostMapping("/categoria/registrar")
    public ResponseEntity<String>RegistrarCategoria(@PathVariable Categoria categoria) {
        try{
            return ResponseEntity.ok(categoriaService.AgregarCategoria(categoria));
        }
        catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/categoria/eliminar")
    public ResponseEntity<String> EliminarCategoria(Long id) {
        try{
            return  ResponseEntity.ok(categoriaService.EliminarCategoria(id));
        }
        catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/categoria/editar")
    public ResponseEntity<String> EditarCategoria(Categoria categoria) {
        try{
            return ResponseEntity.ok(categoriaService.EditarCategoria(categoria));
        }
        catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/categoria/listar")
    public List<Categoria> ListarCategorias() {
        try{
            return categoriaService.ListarCategorias();
        }
        catch(Exception ex) {
            return List.of();
        }
    }

    @PostMapping("/categoria/buscar/{id}")
    public Optional<Categoria> BuscarCategoria(@RequestBody Long id) {
        try{
            return categoriaService.BuscarCategoria(id);
        }
        catch(Exception ex) {
            return Optional.empty();
        }

    }
}
