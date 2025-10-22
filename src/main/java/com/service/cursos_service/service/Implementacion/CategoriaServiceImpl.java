package com.service.cursos_service.service.Implementacion;

import com.service.cursos_service.model.Categoria;
import com.service.cursos_service.repository.CategoriaRepository;
import com.service.cursos_service.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;
    @Override
    public String AgregarCategoria(Categoria categoria) {
        try{
            categoriaRepository.save(categoria);
            return "Categoria agregado com sucesso";
        }
        catch(Exception ex){
            return "Error al agregar categoria";
        }
    }

    @Override
    public String EliminarCategoria(Long id) {
        try{
            categoriaRepository.deleteById(id);
            return "Categoria eliminado com sucesso";
        }
        catch(Exception ex){
            return "Error al eliminar categoria";
        }
    }

    @Override
    public String EditarCategoria(Categoria categoria) {
        try{
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoria.getId());
            if(categoriaOptional.isPresent()){
                categoriaRepository.save(categoria);
                return "Categoria editado com sucesso";
            }
            else {
                return "No se encontro el categoria";
            }
        }
        catch(Exception ex){
            return "Error al editar categoria" + ex.getMessage();
        }
    }

    @Override
    public List<Categoria> ListarCategorias() {
        try{
            return categoriaRepository.findAll();
        }
        catch(Exception ex){
            return List.of();
        }
    }

    @Override
    public Optional<Categoria> BuscarCategoria(Long id) {
        try{
            return categoriaRepository.findById(id);
        }
        catch(Exception ex){
            return Optional.empty();
        }

    }
}
