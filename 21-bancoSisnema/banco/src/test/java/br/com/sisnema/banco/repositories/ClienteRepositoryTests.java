package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.Cliente;
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
public class ClienteRepositoryTests {

    @Autowired
    private ClienteRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeClientes;
    private List<Cliente> lista = new ArrayList<>();

    @BeforeEach
    void setup() {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeClientes = 4L;
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Cliente cliente = Factory.criarCliente();
        cliente.setId(null);
        cliente = repository.save(cliente);

        Assertions.assertNotNull(cliente.getId());
        Assertions.assertEquals(contagemTotalDeClientes + 1, cliente.getId());
    }

    @Test
    public void buscarTodosDeveriaRetornarUmaListaDeObjetos() {
        lista = repository.findAll();

        Assertions.assertNotNull(lista);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Cliente> resultado = repository.findById(idExistente);

        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Cliente> resultado = repository.findById(idNaoExistente);

        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Cliente> resultado = repository.findById(idExistente);

        Assertions.assertFalse(resultado.isPresent());
        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void excluirPorIdDeveriaLancarExcecaoSeOIdNaoExistir() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(idNaoExistente);
        });
    }

}
