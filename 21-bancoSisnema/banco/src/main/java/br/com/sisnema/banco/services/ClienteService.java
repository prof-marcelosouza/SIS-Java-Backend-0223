package br.com.sisnema.banco.services;

import br.com.sisnema.banco.dtos.ClienteDto;
import br.com.sisnema.banco.dtos.EnderecoDto;
import br.com.sisnema.banco.entities.Cliente;
import br.com.sisnema.banco.entities.Endereco;
import br.com.sisnema.banco.repositories.ClienteRepository;
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
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<ClienteDto> procurarTodos() {
        List<Cliente> list = repository.findAll();
        return list.stream().map(x -> new ClienteDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClienteDto procurarPorId(Long id) {
        Optional<Cliente> objeto = repository.findById(id);
        Cliente entidade = objeto.orElseThrow(() ->
                    new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
                );
        return new ClienteDto(entidade);
    }

    @Transactional
    public ClienteDto inserir(ClienteDto dto) {
        Cliente entidade = new Cliente();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new ClienteDto(entidade);
    }

    @Transactional
    public ClienteDto atualizar(Long id, ClienteDto dto) {
        try {
            Cliente entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new ClienteDto(entidade);
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

    private void copiarDtoParaEntidade(ClienteDto dto, Cliente entidade) {
        entidade.setNome(dto.getNome());
        entidade.setSobrenome(dto.getSobrenome());
        entidade.setDataNasc(dto.getDataNasc());
        entidade.setEmail(dto.getEmail());
        entidade.setTelefone(dto.getTelefone());

        entidade.getEnderecos().clear();
        for (EnderecoDto endDto : dto.getEnderecoDtos()) {
            Endereco end = enderecoRepository.getReferenceById(endDto.getId());
            entidade.getEnderecos().add(end);
        }
    }

}
