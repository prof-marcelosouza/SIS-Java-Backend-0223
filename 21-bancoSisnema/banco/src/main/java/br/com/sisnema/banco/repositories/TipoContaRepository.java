package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {
}
