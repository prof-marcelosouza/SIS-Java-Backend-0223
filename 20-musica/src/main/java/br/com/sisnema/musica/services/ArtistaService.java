package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.ArtistaDto;
import br.com.sisnema.musica.entities.Artista;
import br.com.sisnema.musica.entities.Pais;
import br.com.sisnema.musica.repositories.ArtistaRepository;
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
public class ArtistaService {

    // Significa que todos os recursos da interface ArtistaRepository
    // estarão disponíveis dentro do ArtistaService
    @Autowired
    private ArtistaRepository repository;

    @Transactional(readOnly = true)
    public List<ArtistaDto> procurarTodos() {
        List<Artista> list = repository.findAll();
        return list.stream().map(x -> new ArtistaDto(x)).collect(Collectors.toList());
    } // Expressão lambda

    @Transactional(readOnly = true)
    public ArtistaDto procurarPorId(Long id) {
        Optional<Artista> objeto = repository.findById(id);
        //Artista entidade = objeto.get(); // Retira o Artista do Optional
        Artista entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("O ID " + id + " não existe. Camada de serviço."));
        return new ArtistaDto(entidade);
    }

    @Transactional(readOnly = true)
    public ArtistaDto procurarPorIdComAlbuns(Long id) {
        Optional<Artista> objeto = repository.findById(id);
        //Artista entidade = objeto.get(); // Retira o Artista do Optional
        Artista entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("O ID " + id + " não existe. Camada de serviço."));
        return new ArtistaDto(entidade, entidade.getAlbumList());
    }

    @Transactional
    public ArtistaDto inserir(ArtistaDto dto) { // null "Foo Fighters" true
        Artista entidade = new Artista(); // null "Foo Fighters" true
        entidade.setNome(dto.getNome()); // null "Foo Fighters" true
        entidade.setBanda(dto.isBanda()); // null "Foo Fighters" true
        entidade.setPais(new Pais(dto.getPais_id()));
        // Salva no BD e devolve 5 "Foo Fighters" true
        entidade = repository.save(entidade);
        return new ArtistaDto(entidade);
    }

    @Transactional
    public ArtistaDto atualizar(Long id, ArtistaDto dto) {
        try {
            Artista entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade.setBanda(dto.isBanda());
            entidade.setPais(new Pais(dto.getPais_id()));
            entidade = repository.save(entidade);
            return new ArtistaDto(entidade);
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
