package br.com.sisnema.banco.services;

import br.com.sisnema.banco.dtos.FuncaoDto;
import br.com.sisnema.banco.dtos.UsuarioAtualizarDto;
import br.com.sisnema.banco.dtos.UsuarioDto;
import br.com.sisnema.banco.dtos.UsuarioInserirDto;
import br.com.sisnema.banco.entities.Funcao;
import br.com.sisnema.banco.entities.Usuario;
import br.com.sisnema.banco.repositories.FuncaoRepository;
import br.com.sisnema.banco.repositories.UsuarioRepository;
import br.com.sisnema.banco.services.exceptions.IntegridadeBD;
import br.com.sisnema.banco.services.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private FuncaoRepository funcaoRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UsuarioDto> procurarTodos() {
        List<Usuario> list = repository.findAll();
        return list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDto procurarPorId(Long id) {
        Optional<Usuario> objeto = repository.findById(id);
        Usuario entidade = objeto.orElseThrow(() ->
                    new RecursoNaoEncontrado("Este ID não existe em nosso sistema.")
                );
        return new UsuarioDto(entidade);
    }

    @Transactional
    public UsuarioDto inserir(UsuarioInserirDto dto) {
        Usuario entidade = new Usuario();
        copiarDtoParaEntidade(dto, entidade);
        entidade.setSenha(passwordEncoder.encode(dto.getSenha()));
        entidade = repository.save(entidade);
        return new UsuarioDto(entidade);
    }

    @Transactional
    public UsuarioDto atualizar(Long id, UsuarioAtualizarDto dto) {
        try {
            Usuario entidade = repository.getReferenceById(id);
            copiarDtoParaEntidade(dto, entidade);
            entidade = repository.save(entidade);
            return new UsuarioDto(entidade);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("Id não encontrado: " + id);
        }
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("Id não encontrado para exclusão: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new IntegridadeBD("Violação de integridade no banco de dados");
        }
    }

    private void copiarDtoParaEntidade(UsuarioDto dto, Usuario entidade) {
        entidade.setNome(dto.getNome());
        entidade.setSobrenome(dto.getSobrenome());
        entidade.setEmail(dto.getEmail());

        entidade.getFuncoes().clear();
        for (FuncaoDto funcDto : dto.getFuncaoDtos()) {
            Funcao func = funcaoRepository.getReferenceById(funcDto.getId());
            entidade.getFuncoes().add(func);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("E-mail inexistente!");
        }

        return usuario;
    }
}
