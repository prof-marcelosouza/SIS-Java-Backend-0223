package br.com.sisnema.banco.services.TI;

import br.com.sisnema.banco.dtos.UsuarioDto;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.repositories.UsuarioRepository;
import br.com.sisnema.banco.services.UsuarioService;
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
public class UsuarioServiceTestsTI {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long idChaveEstrangeira;
    private Long idParaDelecao;
    private Long contagemTotalDeUsuarios;
    private UsuarioDto usuarioDto;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        idChaveEstrangeira = 2L;
        idParaDelecao = 3L;
        contagemTotalDeUsuarios = 3L;
        usuarioDto = Factory.criarUsuarioDto();
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() {
        List<UsuarioDto> lista = service.procurarTodos();

        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() {
        UsuarioDto resultado = service.procurarPorId(idExistente);

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
        UsuarioDto resultado = service.inserir(usuarioDto);

        Assertions.assertEquals(contagemTotalDeUsuarios + 1, repository.count());
    }

    @Test
    public void atualizarDeveriaGravarNovamenteUmMesmoObjeto() {
        UsuarioDto resultado = service.atualizar(idExistente, usuarioDto);

        Assertions.assertNotNull(resultado);
        System.out.println("Registro atualizado em Usuario: " + resultado);
    }

    @Test
    public void atualizarDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.atualizar(idNaoExistente, usuarioDto);
        });
    }

    @Test
    public void excluirDeveriaEliminarUmRegistro() {
        service.excluir(idParaDelecao);

        Assertions.assertEquals(contagemTotalDeUsuarios - 1, repository.count());
    }

    @Test
    public void excluirDeveriaLancarUmaExcecaoDeIdNaoEncontrado() {
        Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
            service.excluir(idNaoExistente);
        });
    }
}
