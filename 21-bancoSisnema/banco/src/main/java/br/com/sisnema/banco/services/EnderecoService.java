package br.com.sisnema.banco.services;

import br.com.sisnema.banco.dtos.EnderecoDto;
import br.com.sisnema.banco.entities.Endereco;
import br.com.sisnema.banco.repositories.EnderecoRepository;
import br.com.sisnema.banco.services.exceptions.IntegridadeBD;
import br.com.sisnema.banco.services.exceptions.RecursoNaoEncontrado;
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
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Transactional(readOnly = true)
    public List<EnderecoDto> procurarTodos() {
        List<Endereco> list = repository.findAll();
        return list.stream().map(x -> new EnderecoDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EnderecoDto procurarPorId(Long id) {
        Optional<Endereco> objeto = repository.findById(id);
        Endereco entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new EnderecoDto(entidade);
    }

    @Transactional
    public EnderecoDto inserir(EnderecoDto dto) {
        Endereco entidade = new Endereco();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new EnderecoDto(entidade);
    }

    @Transactional
    public EnderecoDto atualizar(Long id, EnderecoDto dto) {
        try {
            Endereco entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new EnderecoDto(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("Id não encontrado para exclusão: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new IntegridadeBD("Violação de integridade no banco de dados");
        }
    }

    private void copiarDtoParaEntidade(EnderecoDto dto, Endereco entidade) {
        entidade.setLogradouro(dto.getLogradouro());
        entidade.setNumero(dto.getNumero());
        entidade.setComplemento(dto.getComplemento());
        entidade.setBairro(dto.getBairro());
        entidade.setCep(dto.getCep());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
    }
}
