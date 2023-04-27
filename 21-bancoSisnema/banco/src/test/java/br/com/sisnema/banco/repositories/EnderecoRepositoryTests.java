package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.Endereco;
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
public class EnderecoRepositoryTests {

    @Autowired
    private EnderecoRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeEnderecos;
    private List<Endereco> lista = new ArrayList<>();

    // Preparação para os testes
    @BeforeEach
    void Setup() {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeEnderecos = 4L;
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Endereco endereco = Factory.criarEndereco();
        endereco.setId(null);
        endereco = repository.save(endereco);

        Assertions.assertNotNull(endereco.getId()); // 4
        Assertions.assertEquals(contagemTotalDeEnderecos + 1, endereco.getId());
    }

    @Test
    public void buscarTodosDeveriaRetornarUmaListaDeObjetos() {
        lista = repository.findAll();

        Assertions.assertNotNull(lista);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Endereco> resultado = repository.findById(idExistente);

        Assertions.assertTrue(resultado.isPresent()); // Retorna um boolean
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Endereco> resultado = repository.findById(idNaoExistente); // 999L

        Assertions.assertTrue(resultado.isEmpty()); // Retorna um boolean
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        repository.deleteById(idExistente); // 1L
        Optional<Endereco> resultado = repository.findById(idExistente); // 1L

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
