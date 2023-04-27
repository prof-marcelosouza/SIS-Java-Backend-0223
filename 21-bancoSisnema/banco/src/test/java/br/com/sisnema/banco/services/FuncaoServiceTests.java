package br.com.sisnema.banco.services;

import br.com.sisnema.banco.dtos.FuncaoDto;
import br.com.sisnema.banco.entities.Funcao;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.FuncaoRepository;
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

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class FuncaoServiceTests {

    @InjectMocks
    private FuncaoService service;

    @Mock
    private FuncaoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Funcao funcao;
    private FuncaoDto funcaoDto;
    private List<Funcao> funcaoList;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        funcao = Factory.criarFuncao();
        funcaoDto = Factory.criarFuncaoDto();
        funcaoList = new ArrayList<>();

        // Simulações da camada de Repository - MOCK
        when(repository.findAll()).thenReturn(funcaoList);

        when(repository.findById(idExistente)).thenReturn(Optional.of(funcao));
        when(repository.findById(idNaoExistente)).thenReturn(Optional.empty());

        when(repository.save(ArgumentMatchers.any())).thenReturn(funcao);

        when(repository.getReferenceById(idExistente)).thenReturn(funcao);
        when(repository.getReferenceById(idNaoExistente)).thenThrow(EntityNotFoundException.class);

        doNothing().when(repository).deleteById(idExistente);
        doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idNaoExistente);
        doThrow(DataIntegrityViolationException.class).when(repository).deleteById(idChaveEstrangeira);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeObjetos() {
        List<FuncaoDto> list = service.procurarTodos();

        Assertions.assertNotNull(list);
        Mockito.verify(repository, times(1)).findAll();
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        FuncaoDto resultado = service.procurarPorId(idExistente);

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
        FuncaoDto dto = funcaoDto;
        dto.setId(null);
        FuncaoDto resultado = service.inserir(dto);

        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaPersistirNovamenteOMesmoObjeto() {
        FuncaoDto resultado = service.atualizar(idExistente, funcaoDto);

        Assertions.assertNotNull(resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoQuandoOidNaoExistir() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, funcaoDto);
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
