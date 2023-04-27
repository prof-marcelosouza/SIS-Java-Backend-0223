package br.com.sisnema.banco.services;

import br.com.sisnema.banco.dtos.ContaDto;
import br.com.sisnema.banco.entities.Cliente;
import br.com.sisnema.banco.entities.Conta;
import br.com.sisnema.banco.entities.TipoConta;
import br.com.sisnema.banco.repositories.ContaRepository;
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
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Transactional(readOnly = true)
    public List<ContaDto> procurarTodos() {
        List<Conta> list = repository.findAll();
        return list.stream().map(x -> new ContaDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContaDto procurarPorId(Long id) {
        Optional<Conta> objeto = repository.findById(id);
        Conta entidade = objeto.orElseThrow(() ->
                new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
        );
        return new ContaDto(entidade);
    }

    @Transactional
    public ContaDto inserir(ContaDto dto) {
        Conta entidade = new Conta();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new ContaDto(entidade);
    }

    @Transactional
    public ContaDto atualizar(Long id, ContaDto dto) {
        try {
            Conta entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new ContaDto(entidade);
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

    private void copiarDtoParaEntidade(ContaDto dto, Conta entidade) {
        entidade.setBanco(dto.getBanco());
        entidade.setAgencia(dto.getAgencia());
        entidade.setNumero(dto.getNumero());
        entidade.setLimite(dto.getLimite());
        entidade.setSaldo(dto.getSaldo());
        entidade.setTipoConta(new TipoConta(dto.getTipo_conta_id()));
        entidade.setCliente(new Cliente(dto.getCliente_id()));
    }
}
