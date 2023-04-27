package br.com.sisnema.banco.services;

import br.com.sisnema.banco.dtos.TipoContaDto;
import br.com.sisnema.banco.entities.TipoConta;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.TipoContaRepository;
import br.com.sisnema.banco.services.exceptions.IntegridadeBD;
import br.com.sisnema.banco.services.exceptions.RecursoNaoEncontrado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class TipoContaServiceTests {

    @InjectMocks
    private TipoContaService service;

    @Mock
    private TipoContaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private TipoConta tipoConta;
    private TipoContaDto tipoContaDto;
    private List<TipoConta> tipoContaList;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        tipoConta = Factory.criarTipoConta();
        tipoContaDto = Factory.criarTipoContaDto();
        tipoContaList = new ArrayList<>();

        // Simulações da camada de Repository - MOCK
        Mockito.when(repository.findAll()).thenReturn(tipoContaList);

        Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(tipoConta));
        Mockito.when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(tipoConta);

        Mockito.when(repository.getReferenceById(idExistente)).thenReturn(tipoConta);
        Mockito.when(repository.getReferenceById(idNaoExistente)).thenThrow(EntityNotFoundException.class);

        Mockito.doNothing().when(repository).deleteById(idExistente);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idNaoExistente);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(idChaveEstrangeira);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeObjetos() {
        List<TipoContaDto> list = service.procurarTodos();

        Assertions.assertNotNull(list);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        TipoContaDto resultado = service.procurarPorId(idExistente);

        Assertions.assertNotNull(resultado);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmaExcecaoQuandoOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.procurarPorId(idNaoExistente);
        });

        Mockito.verify(repository, times(1)).findById(idNaoExistente);
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        TipoContaDto dto = tipoContaDto;
        dto.setId(null);
        TipoContaDto resultado = service.inserir(dto);

        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaPersistirNovamenteOMesmoObjeto() {
        TipoContaDto resultado = service.atualizar(idExistente, tipoContaDto);

        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoOidNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, tipoContaDto);
        });
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        Assertions.assertDoesNotThrow(() -> {
            service.excluir(idExistente);
        });
    }

    @Test
    public void excluirPorIdDeveriaLancarExcecaoSeOIdNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });

        Mockito.verify(repository, times(1)).deleteById(idNaoExistente);
    }

    @Test
    public void excluirPorIdDeveriaLancarExcecaoDeIntegridadeQuandoOIdForUtilizadoEmOutraTabela() {
        Assertions.assertThrows(IntegridadeBD.class, () -> {
            service.excluir(idChaveEstrangeira);
        });

        Mockito.verify(repository, times(1)).deleteById(idChaveEstrangeira);
    }

}
