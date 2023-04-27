package br.com.sisnema.banco.services.TI;

import br.com.sisnema.banco.dtos.TipoContaDto;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.TipoContaRepository;
import br.com.sisnema.banco.services.TipoContaService;
import br.com.sisnema.banco.services.exceptions.RecursoNaoEncontrado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class TipoContaServiceTestsTI {

    @Autowired
    private TipoContaService service;

    @Autowired
    private TipoContaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long idParaDelecao;
    private Long contagemTotalDeTipoContas;
    private TipoContaDto tipoContaDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        idParaDelecao = 4L;
        contagemTotalDeTipoContas = 4L;
        tipoContaDto = Factory.criarTipoContaDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<TipoContaDto> lista = service.procurarTodos();

        Assertions.assertFalse(lista.isEmpty());
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
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados() {
        TipoContaDto resultado = service.inserir(tipoContaDto);

        Assertions.assertEquals(contagemTotalDeTipoContas + 1, repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        TipoContaDto resultado = service.atualizar(idExistente, tipoContaDto);

        Assertions.assertNotNull(resultado);
        System.out.println("Registro atualizado em TipoConta: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, tipoContaDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idParaDelecao);

        Assertions.assertEquals(contagemTotalDeTipoContas - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }
}
