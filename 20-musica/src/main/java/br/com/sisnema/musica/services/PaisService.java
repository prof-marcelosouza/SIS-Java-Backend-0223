package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.entities.Musico;
import br.com.sisnema.musica.entities.Pais;
import br.com.sisnema.musica.repositories.PaisRepository;
import br.com.sisnema.musica.services.exceptions.IntegridadeBD;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService {

    // Significa que todos os recursos da interface PaisRepository
    // estarão disponíveis dentro do PaisService
    @Autowired
    private PaisRepository repository;

    @Transactional(readOnly = true)
    public List<PaisDto> procurarTodos() {
        List<Pais> list = repository.findAll();
        return list.stream().map(x -> new PaisDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaisDto procurarPorId(Long id) {
        Optional<Pais> objeto = repository.findById(id);
        //Pais entidade = objeto.get(); // Retira o Artista do Optional
        Pais entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("O ID " + id + " não existe. Camada de serviço."));
        return new PaisDto(entidade);
    }

    @Transactional(readOnly = true)
    public PaisDto procurarPorIdComArtistas(Long id) {
        Optional<Pais> objeto = repository.findById(id);
        Pais entidade = objeto.get(); // Retira o Artista do Optional
        return new PaisDto(entidade, entidade.getArtistaList());
    }

    @Transactional
    public PaisDto inserir(PaisDto dto) { // null "Uruguai"
        Pais entidade = new Pais(); // null "Uruguai"
        entidade.setNome(dto.getNome()); // null "Uruguai"

        // Salva no BD e devolve 6 "Uruguai"
        entidade = repository.save(entidade);
        return new PaisDto(entidade);
    }

    @Transactional
    public PaisDto atualizar(Long id, PaisDto dto) {
        try {
            Pais entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade = repository.save(entidade);
            return new PaisDto(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("Falha na atualização. O ID " + id + " não existe. Camada de serviço.");
        }
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("Falha na deleção. O ID " + id + " não existe. Camada de serviço.");
        }
        catch (DataIntegrityViolationException e) {
            throw new IntegridadeBD("Violação de integridade no banco de dados.");
        }
    }

}
