package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.InstrumentoDto;
import br.com.sisnema.musica.entities.Artista;
import br.com.sisnema.musica.entities.Instrumento;
import br.com.sisnema.musica.repositories.InstrumentoRepository;
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
public class InstrumentoService {

    // Significa que todos os recursos da interface InstrumentoRepository
    // estarão disponíveis dentro do InstrumentoService
    @Autowired
    private InstrumentoRepository repository;

    @Transactional(readOnly = true)
    public List<InstrumentoDto> procurarTodos() {
        List<Instrumento> list = repository.findAll();
        return list.stream().map(x -> new InstrumentoDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InstrumentoDto procurarPorId(Long id) {
        Optional<Instrumento> objeto = repository.findById(id);
        //Instrumento entidade = objeto.get();
        Instrumento entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("O ID " + id + " não existe. Camada de serviço."));
        return new InstrumentoDto(entidade);
    }

    @Transactional
    public InstrumentoDto inserir(InstrumentoDto dto) {
        Instrumento entidade = new Instrumento();
        entidade.setNome(dto.getNome());
        entidade.setObs(dto.getObs());
        entidade = repository.save(entidade);
        return new InstrumentoDto(entidade);
    }

    @Transactional
    public InstrumentoDto atualizar(Long id, InstrumentoDto dto) {
        try {
            Instrumento entidade = repository.getReferenceById(id);
            entidade.setNome(dto.getNome());
            entidade.setObs(dto.getObs());
            entidade = repository.save(entidade);
            return new InstrumentoDto(entidade);
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
