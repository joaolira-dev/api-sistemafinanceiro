package sistema_financeiro.demo.services;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sistema_financeiro.demo.dtos.PessoaDTO;
import org.springframework.data.domain.Pageable;
import sistema_financeiro.demo.models.Pessoa;
import sistema_financeiro.demo.repositorys.LancamentoRepository;
import sistema_financeiro.demo.repositorys.PessoaRepository;

@Service
public class PessoasServices {

    @Autowired
    private PessoaRepository pessoaRepository;
    private LancamentoRepository lancamentoRepository;

    public ResponseEntity listarPessoas(Pageable paginacao) {
        var page = pessoaRepository.findAllByAtivoTrue(paginacao).map(PessoaDTO::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    public ResponseEntity detalhar(Integer id) {
        var pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return ResponseEntity.ok(new PessoaDTO(pessoa));
    }

    public Pessoa criarPessoa(@Valid PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.nome());
        pessoa.setAtivo(dto.ativo());
        pessoa.setEndereco(dto.endereco());
        return pessoaRepository.save(pessoa);
    }

    public ResponseEntity desativarPessoa(Integer id) {
        var pessoaExistente = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoaExistente.setAtivo(false);
        pessoaRepository.save(pessoaExistente);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity deletarPessoa(Integer id) {
        var pessoaExistente = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoaRepository.delete(pessoaExistente);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity ativarPessoa(Integer id) {
        var pessoaExistente = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoaExistente.setAtivo(true);
        pessoaRepository.save(pessoaExistente);
        return ResponseEntity.status(200).body("Pessoa ativada!");
    }

    public ResponseEntity<String> atualizarPessoa(Integer id, PessoaDTO dto) {
        Pessoa existente = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

        if (dto.ativo() != null) {
            existente.setAtivo(dto.ativo());
        }
        if (dto.endereco() != null) {
            existente.setEndereco(dto.endereco());
        }
        if (dto.nome() != null) {
            existente.setNome(dto.nome());
        }

        pessoaRepository.save(existente);
        return ResponseEntity.ok("Pessoa atualizada com sucesso!");
    }
}
