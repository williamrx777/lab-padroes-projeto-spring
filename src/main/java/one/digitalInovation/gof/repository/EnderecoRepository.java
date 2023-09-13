package one.digitalInovation.gof.repository;

import one.digitalInovation.gof.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,String> {
}
