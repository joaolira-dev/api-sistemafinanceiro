package sistema_financeiro.demo.services;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sistema_financeiro.demo.dtos.LancamentoDTO;
import sistema_financeiro.demo.models.Lancamento;
import sistema_financeiro.demo.repositorys.LancamentoRepository;

import java.util.List;


@Service
public class LancamentoServices {

    @Autowired
    private LancamentoRepository repository;

    public List<LancamentoDTO> listarLancamentos() {
        List<Lancamento> lancamentos = repository.findAll();
        return lancamentos.stream().map(LancamentoDTO::new).toList();
    }

    @Transactional
    public ResponseEntity detalhar(Integer id) {
        var lancamento = repository.findById(id);
        return ResponseEntity.ok(lancamento);
    }

    public Lancamento criarLancamento(@Valid LancamentoDTO dto) {
        Lancamento lancamento = new Lancamento();

        lancamento.setDescricao(dto.descricao());
        lancamento.setCategoria(dto.codigo_categoria());
        lancamento.setPessoa(dto.codigo_pessoa());
        lancamento.setTipo(dto.tipo());
        lancamento.setDataPagamento(dto.dataPagamento());
        lancamento.setObservacao(dto.observacao());
        lancamento.setValor(dto.valor());
        lancamento.setDataVencimento(dto.dataVencimento());

        return repository.save(lancamento);
    }

    public ResponseEntity<String> deletarLancamento(Integer id) {
        Lancamento existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        repository.delete(existente);
        return ResponseEntity.noContent().build();
    }




    public ResponseEntity<String> atualizarLancamento(Integer id, LancamentoDTO dto) {
        Lancamento existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

        if (dto.observacao() != null) {
            existente.setObservacao(dto.observacao());
        }
        if (dto.valor() != null) {
            existente.setValor(dto.valor());
        }
        if (dto.descricao() != null) {
            existente.setDescricao(dto.descricao());
        }
        if (dto.tipo() != null) {
            existente.setTipo(dto.tipo());
        }
        if (dto.dataVencimento() != null) {
            existente.setDataVencimento(dto.dataVencimento());
        }


        repository.save(existente);
        return ResponseEntity.ok("Lancamento atualizado com sucesso!");
    }
}
