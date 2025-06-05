package sistema_financeiro.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema_financeiro.demo.dtos.PessoaDTO;
import sistema_financeiro.demo.services.PessoasServices;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoasServices pessoasService;

    @GetMapping
    public ResponseEntity listarPessoas(@PageableDefault(size = 20, sort = {"nome"}) Pageable paginacao) {
        return pessoasService.listarPessoas(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Integer id) {
        return pessoasService.detalhar(id);
    }

    @PostMapping
    public ResponseEntity criarPessoa(@RequestBody @Valid PessoaDTO pessoa, UriComponentsBuilder uriBuilder) {
        var pessoaCriada = pessoasService.criarPessoa(pessoa);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoaCriada.getCodigo_pessoa()).toUri();
        return ResponseEntity.created(uri).body(pessoaCriada);
    }

    @GetMapping("/ativar/{id}")
    public ResponseEntity ativarPessoa(@PathVariable Integer id) {
        return pessoasService.ativarPessoa(id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPessoa(@PathVariable Integer id) {
        return pessoasService.deletarPessoa(id);
    }


    @DeleteMapping("/desativar/{id}")
    public ResponseEntity<String> desativarPessoa(@PathVariable Integer id) {
        return pessoasService.desativarPessoa(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPessoa(@PathVariable Integer id, @RequestBody PessoaDTO pessoa) {
        return pessoasService.atualizarPessoa(id, pessoa);
    }
}

