package br.com.sisnema.banco.repositories;

import br.com.sisnema.banco.entities.Usuario;
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
public class UsuarioRepositoryTests {

    @Autowired
    private UsuarioRepository repository;

    private Long idExistente;
    private Long idNaoExistente;
    private Long contagemTotalDeUsuarios;
    private List<Usuario> lista = new ArrayList<>();

    @BeforeEach
    void setup() {
        idExistente = 1L;
        idNaoExistente = 999L;
        contagemTotalDeUsuarios = 3L;
    }

    @Test
    public void salvarDeveriaPersistirComAutoincrementoQuandoOIdForNulo() {
        Usuario usuario = Factory.criarUsuario();
        usuario.setId(null);
        usuario = repository.save(usuario);

        Assertions.assertNotNull(usuario.getId()); // 4L
        Assertions.assertEquals(contagemTotalDeUsuarios + 1, usuario.getId());
    }

    @Test
    public void buscarTodosDeveriaRetornarUmaListaDeObjetos() {
        lista = repository.findAll();

        Assertions.assertNotNull(lista);
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalComUmObjeto() {
        Optional<Usuario> resultado = repository.findById(idExistente);

        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUmOptionalVazio() {
        Optional<Usuario> resultado = repository.findById(idNaoExistente);

        Assertions.assertTrue(resultado.isEmpty());
    }

    @Test
    public void excluirPorIdDeveriaDeletarORegistroQuandoOIdExistir() {
        repository.deleteById(idExistente);
        Optional<Usuario> resultado = repository.findById(idExistente);

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
