package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.Funcao;
import br.com.sisnema.banco.factories.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class FuncaoRepositoryTests {

    @Autowired
    private FuncaoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeFuncoes;
    private List<Funcao> lista = new ArrayList<>();

    // Preparação para os testes
    @BeforeEach
    void Setup() {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeFuncoes = 4L;
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Funcao funcao = Factory.criarFuncao(); // 1 ROLE_PILOT (veio do Factory)
        funcao.setId(null); // null ROLE_PILOT
        funcao = repository.save(funcao); // 4 ROLE_PILOT

        Assertions.assertNotNull(funcao.getId()); // 4
        Assertions.assertEquals(contagemTotalDeFuncoes + 1, funcao.getId());
    }

    @Test
    public void buscarTodosDeveriaRetornarUmaListaDeObjetos() {
        lista = repository.findAll();

        Assertions.assertNotNull(lista);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Funcao> resultado = repository.findById(idExistente);

        Assertions.assertTrue(resultado.isPresent()); // Retorna um boolean
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Funcao> resultado = repository.findById(idNaoExistente); // 999L

        Assertions.assertTrue(resultado.isEmpty()); // Retorna um boolean
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        repository.deleteById(idExistente); // 1L
        Optional<Funcao> resultado = repository.findById(idExistente); // 1L

        Assertions.assertFalse(resultado.isPresent());
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void excluirPorIdDeveriaLancarExcecaoSeOIdNaoExistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
           repository.deleteById(idNaoExistente); // 999L
        });
    }

}
