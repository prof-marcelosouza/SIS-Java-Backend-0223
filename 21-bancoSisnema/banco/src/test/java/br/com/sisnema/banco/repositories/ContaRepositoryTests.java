package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.Conta;
import br.com.sisnema.banco.factories.FactoryFK;
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
public class ContaRepositoryTests {

    @Autowired
    private ContaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeContas;
    private List<Conta> lista = new ArrayList<>();

    @BeforeEach
    void Setup() {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeContas = 5L;
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Conta conta = FactoryFK.criarConta();
        conta.setId(null);
        conta = repository.save(conta);

        Assertions.assertNotNull(conta.getId());
        Assertions.assertEquals(contagemTotalDeContas + 1, conta.getId());
    }

    @Test
    public void buscarTodosDeveriaRetornarUmaListaDeObjetos() {
        lista = repository.findAll();

        Assertions.assertNotNull(lista);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Conta> resultado = repository.findById(idExistente);

        Assertions.assertTrue(resultado.isPresent()); // Retorna um boolean
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Conta> resultado = repository.findById(idNaoExistente); // 999L

        Assertions.assertTrue(resultado.isEmpty()); // Retorna um boolean
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        repository.deleteById(idExistente); // 1L
        Optional<Conta> resultado = repository.findById(idExistente); // 1L

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
