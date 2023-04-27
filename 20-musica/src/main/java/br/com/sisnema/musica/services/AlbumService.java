package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.AlbumDto;
import br.com.sisnema.musica.entities.Album;
import br.com.sisnema.musica.entities.Artista;
import br.com.sisnema.musica.repositories.AlbumRepository;
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
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    @Transactional(readOnly = true)
    public List<AlbumDto> procurarTodos() {
        List<Album> list = repository.findAll();
        return list.stream().map(x -> new AlbumDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AlbumDto procurarPorId(Long id) {
        Optional<Album> objeto = repository.findById(id);
        //Album entidade = objeto.get();
        Album entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("O ID " + id + " não existe. Camada de serviço."));
        return new AlbumDto(entidade);
    }

    @Transactional
    public AlbumDto inserir(AlbumDto dto) {
        Album entidade = new Album();
        entidade.setTitulo(dto.getTitulo());
        entidade.setAno(dto.getAno());
        entidade.setArtista(new Artista(dto.getArtista_id()));
        entidade = repository.save(entidade);
        return new AlbumDto(entidade);
    }

    @Transactional
    public AlbumDto atualizar(Long id, AlbumDto dto) {
        try {
            Album entidade = repository.getReferenceById(id);
            entidade.setTitulo(dto.getTitulo());
            entidade.setAno(dto.getAno());
            entidade.setArtista(new Artista(dto.getArtista_id()));
            entidade = repository.save(entidade);
            return new AlbumDto(entidade);
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
