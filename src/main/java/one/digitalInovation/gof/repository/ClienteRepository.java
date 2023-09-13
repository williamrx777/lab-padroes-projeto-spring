package one.digitalInovation.gof.repository;

import one.digitalInovation.gof.dto.ClienteDTO;
import one.digitalInovation.gof.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
