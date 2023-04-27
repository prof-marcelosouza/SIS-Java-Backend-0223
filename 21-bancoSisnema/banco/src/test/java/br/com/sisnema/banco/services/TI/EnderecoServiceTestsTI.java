package br.com.sisnema.banco.services.TI;

import br.com.sisnema.banco.dtos.EnderecoDto;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.EnderecoRepository;
import br.com.sisnema.banco.services.EnderecoService;
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
public class EnderecoServiceTestsTI {

    @Autowired
    private EnderecoService service;

    @Autowired
    private EnderecoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long idParaDelecao;
    private Long contagemTotalDeEnderecos;
    private EnderecoDto enderecoDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        idParaDelecao = 4L;
        contagemTotalDeEnderecos = 4L;
        enderecoDto = Factory.criarEnderecoDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<EnderecoDto> lista = service.procurarTodos();

        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        EnderecoDto resultado = service.procurarPorId(idExistente);

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
        EnderecoDto resultado = service.inserir(enderecoDto);

        Assertions.assertEquals(contagemTotalDeEnderecos + 1, repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        EnderecoDto resultado = service.atualizar(idExistente, enderecoDto);

        Assertions.assertNotNull(resultado);
        System.out.println("Registro atualizado em Endereco: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, enderecoDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idParaDelecao);

        Assertions.assertEquals(contagemTotalDeEnderecos - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }
}
