package sistema_financeiro.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema_financeiro.demo.models.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
