package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.Funcao;
import br.com.sisnema.banco.entities.TipoConta;
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
public class TipoContaRepositoryTests {

    @Autowired
    private TipoContaRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeTipoContas;
    private List<TipoConta> lista = new ArrayList<>();

    @BeforeEach
    void Setup() {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeTipoContas = 4L;
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        TipoConta tipoConta = Factory.criarTipoConta();
        tipoConta.setId(null);
        tipoConta = repository.save(tipoConta);

        Assertions.assertNotNull(tipoConta.getId());
        Assertions.assertEquals(contagemTotalDeTipoContas + 1, tipoConta.getId());
    }

    @Test
    public void buscarTodosDeveriaRetornarUmaListaDeObjetos() {
        lista = repository.findAll();

        Assertions.assertNotNull(lista);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<TipoConta> resultado = repository.findById(idExistente);

        Assertions.assertTrue(resultado.isPresent()); // Retorna um boolean
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<TipoConta> resultado = repository.findById(idNaoExistente); // 999L

        Assertions.assertTrue(resultado.isEmpty()); // Retorna um boolean
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        repository.deleteById(idExistente); // 1L
        Optional<TipoConta> resultado = repository.findById(idExistente); // 1L

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
