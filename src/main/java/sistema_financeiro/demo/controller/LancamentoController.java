package sistema_financeiro.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema_financeiro.demo.dtos.LancamentoDTO;
import sistema_financeiro.demo.models.Lancamento;
import sistema_financeiro.demo.services.LancamentoServices;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {


    @Autowired
    private LancamentoServices lancamentoServices;

    @GetMapping
    public List<LancamentoDTO> listarLancamentos() {
        return lancamentoServices.listarLancamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Integer id) {
        return lancamentoServices.detalhar(id);
    }


    @PostMapping
    public ResponseEntity<Lancamento> criarLancamento(@RequestBody @Valid LancamentoDTO lancamento, UriComponentsBuilder uriBuilder) {
        var lancamentoCriado = lancamentoServices.criarLancamento(lancamento);
        var uri = uriBuilder.path("/lancamentos/{id}").buildAndExpand(lancamentoCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(lancamentoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLancamento(@PathVariable Integer id) {
        return lancamentoServices.deletarLancamento(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarLancamento(@PathVariable Integer id, @RequestBody LancamentoDTO lancamento) {
        return lancamentoServices.atualizarLancamento(id, lancamento);
    }
}