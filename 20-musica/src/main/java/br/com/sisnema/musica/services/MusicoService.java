package br.com.sisnema.musica.services;

import br.com.sisnema.musica.dtos.InstrumentoDto;
import br.com.sisnema.musica.dtos.MusicoDto;
import br.com.sisnema.musica.entities.Instrumento;
import br.com.sisnema.musica.entities.Musico;
import br.com.sisnema.musica.repositories.InstrumentoRepository;
import br.com.sisnema.musica.repositories.MusicoRepository;
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
public class MusicoService {

    // Significa que todos os recursos da interface MusicoRepository
    // estarão disponíveis dentro do MusicoService
    @Autowired
    private MusicoRepository repository;
    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Transactional(readOnly = true)
    public List<MusicoDto> procurarTodos() {
        List<Musico> list = repository.findAll();
        return list.stream().map(x -> new MusicoDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MusicoDto procurarPorId(Long id) {
        Optional<Musico> objeto = repository.findById(id);
        //Musico entidade = objeto.get();
        Musico entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("O ID " + id + " não existe. Camada de serviço."));
        return new MusicoDto(entidade);
    }
    
    @Transactional
    public MusicoDto inserir(MusicoDto dto) {
        Musico entidade = new Musico();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new MusicoDto(entidade);
    }

    @Transactional
    public MusicoDto atualizar(Long id, MusicoDto dto) {
        try {
            Musico entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new MusicoDto(entidade);
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

    private void copiarDtoParaEntidade(MusicoDto dto, Musico entidade) {
        entidade.setNome(dto.getNome());
        entidade.setSobrenome(dto.getSobrenome());
        entidade.setDataNasc(dto.getDataNasc());

        entidade.getInstrumentos().clear();
        for (InstrumentoDto instDto : dto.getInstrumentoDtos()) { // 1 2
            Instrumento inst = instrumentoRepository.getReferenceById(instDto.getId());
            entidade.getInstrumentos().add(inst);
        }
    }
}
