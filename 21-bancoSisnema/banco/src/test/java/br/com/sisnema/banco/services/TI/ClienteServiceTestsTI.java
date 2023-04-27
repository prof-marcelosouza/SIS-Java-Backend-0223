package br.com.sisnema.banco.services.TI;

import br.com.sisnema.banco.dtos.ClienteDto;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.ClienteRepository;
import br.com.sisnema.banco.services.ClienteService;
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
public class ClienteServiceTestsTI {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long idParaDelecao;
    private Long contagemTotalDeClientes;
    private ClienteDto clienteDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        idParaDelecao = 4L;
        contagemTotalDeClientes = 4L;
        clienteDto = Factory.criarClienteDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<ClienteDto> lista = service.procurarTodos();

        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        ClienteDto resultado = service.procurarPorId(idExistente);

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
        ClienteDto resultado = service.inserir(clienteDto);

        Assertions.assertEquals(contagemTotalDeClientes + 1, repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        ClienteDto resultado = service.atualizar(idExistente, clienteDto);

        Assertions.assertNotNull(resultado);
        System.out.println("Registro atualizado em Cliente: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, clienteDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idParaDelecao);

        Assertions.assertEquals(contagemTotalDeClientes - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }
}
