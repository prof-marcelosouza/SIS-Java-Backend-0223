package br.com.sisnema.banco.controllers;

import br.com.sisnema.banco.dtos.UsuarioAtualizarDto;
import br.com.sisnema.banco.dtos.UsuarioDto;
import br.com.sisnema.banco.dtos.UsuarioInserirDto;
import br.com.sisnema.banco.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> buscarTodos() {
        List<UsuarioDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable Long id) {
        UsuarioDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> inserir(@RequestBody UsuarioInserirDto dto) {
        UsuarioDto newDto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody UsuarioAtualizarDto dto) {
        UsuarioDto newDto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
