package br.com.sisnema.musica.repositories;


import br.com.sisnema.musica.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Ele possui todos os métodos do CRUD.
public interface PaisRepository extends JpaRepository<Pais, Long> {

    // Aqui podemos colocar consultas extras;

}
