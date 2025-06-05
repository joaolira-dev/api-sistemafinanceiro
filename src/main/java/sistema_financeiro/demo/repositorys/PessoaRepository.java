package sistema_financeiro.demo.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sistema_financeiro.demo.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Page<Pessoa> findAllByAtivoTrue(Pageable paginacao);
}
