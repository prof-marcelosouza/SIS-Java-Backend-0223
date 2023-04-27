package br.com.sisnema.banco.controllers;

import br.com.sisnema.banco.dtos.TipoContaDto;
import br.com.sisnema.banco.services.TipoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/tipocontas")
public class TipoContaController {

    @Autowired
    private TipoContaService service;

    @GetMapping
    public ResponseEntity<List<TipoContaDto>> buscarTodos() {
        List<TipoContaDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoContaDto> buscarPorId(@PathVariable Long id) {
        TipoContaDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<TipoContaDto> inserir(@RequestBody TipoContaDto dto) {
        TipoContaDto newDto = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoContaDto> atualizar(@PathVariable Long id, @RequestBody TipoContaDto dto) {
        TipoContaDto newDto = service.atualizar(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
