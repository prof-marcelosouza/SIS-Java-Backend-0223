package br.com.sisnema.musica.repositories;


import br.com.sisnema.musica.entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Ele possui todos os métodos do CRUD.
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {

    // Aqui podemos colocar consultas extras;

}
