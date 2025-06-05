package sistema_financeiro.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema_financeiro.demo.dtos.CategoriaDTO;
import sistema_financeiro.demo.services.CategoriaServices;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServices categoriaService;

    @GetMapping
    public List<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public ResponseEntity<String> adicionarCategoria(@RequestBody  CategoriaDTO categoria) {
        return categoriaService.adicionarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Integer id) {
        return categoriaService.deletarCategoria(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPessoa(@PathVariable Integer id, @RequestBody CategoriaDTO categoria) {
        return categoriaService.atualizarCategoria(id, categoria);
    }
}
