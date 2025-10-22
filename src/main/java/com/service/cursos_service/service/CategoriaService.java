package com.service.cursos_service.service;

import com.service.cursos_service.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    String AgregarCategoria(Categoria categoria);
    String EliminarCategoria(Long id);
    String EditarCategoria(Categoria categoria);
    List<Categoria> ListarCategorias();
    Optional<Categoria> BuscarCategoria(Long id);


}
