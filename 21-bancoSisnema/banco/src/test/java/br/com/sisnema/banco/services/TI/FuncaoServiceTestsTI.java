package br.com.sisnema.banco.services.TI;

import br.com.sisnema.banco.dtos.FuncaoDto;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.FuncaoRepository;
import br.com.sisnema.banco.services.FuncaoService;
import br.com.sisnema.banco.services.exceptions.IntegridadeBD;
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
public class FuncaoServiceTestsTI {

    @Autowired
    private FuncaoService service;

    @Autowired
    private FuncaoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long idParaDelecao;
    private Long contagemTotalDeFuncoes;
    private FuncaoDto funcaoDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        idParaDelecao = 4L;
        contagemTotalDeFuncoes = 4L;
        funcaoDto = Factory.criarFuncaoDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<FuncaoDto> lista = service.procurarTodos();

        Assertions.assertFalse(lista.isEmpty());
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
    }

    @Test
    public void inserirDeveriaGravarUmObjetoNoBancoDeDados() {
        FuncaoDto resultado = service.inserir(funcaoDto);

        Assertions.assertEquals(contagemTotalDeFuncoes + 1, repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        FuncaoDto resultado = service.atualizar(idExistente, funcaoDto);

        Assertions.assertNotNull(resultado);
        System.out.println("Registro atualizado em Funcao: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, funcaoDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idParaDelecao); // 4L

        Assertions.assertEquals(contagemTotalDeFuncoes - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }
}
