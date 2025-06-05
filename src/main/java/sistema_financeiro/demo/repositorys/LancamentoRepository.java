package sistema_financeiro.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema_financeiro.demo.models.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

}
