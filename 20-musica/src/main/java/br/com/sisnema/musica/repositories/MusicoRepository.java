package br.com.sisnema.musica.repositories;


import br.com.sisnema.musica.entities.Musico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Ele possui todos os métodos do CRUD.
public interface MusicoRepository extends JpaRepository<Musico, Long> {

    // Aqui podemos colocar consultas extras;

}
