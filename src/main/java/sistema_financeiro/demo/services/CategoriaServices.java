package sistema_financeiro.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sistema_financeiro.demo.dtos.CategoriaDTO;
import sistema_financeiro.demo.models.Categoria;
import sistema_financeiro.demo.repositorys.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository repository;


    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> categorias = repository.findAll();
        return categorias.stream().map(CategoriaDTO::new).toList();
    }

    public ResponseEntity<String> adicionarCategoria(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());

        repository.save(categoria);
        return ResponseEntity.ok("Categoria adicionada");
    }

    public ResponseEntity<String> deletarCategoria(Integer id) {
        Categoria existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        repository.delete(existente);
        return ResponseEntity.ok("Categoria deletada!");
    }


    public ResponseEntity<String> atualizarCategoria(Integer id, CategoriaDTO dto) {
        Categoria existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
        if(dto.nome() != null) {
            existente.setNome(dto.nome());
        }
       return ResponseEntity.ok("Nome atualizado!");
    }

}
