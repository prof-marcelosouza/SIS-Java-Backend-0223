package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.InstrumentoDto;
import br.com.sisnema.musica.services.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/instrumentos")
public class InstrumentoController {

    @Autowired
    private InstrumentoService service;

    @GetMapping
    public ResponseEntity<List<InstrumentoDto>> buscarTodos() {
        List<InstrumentoDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InstrumentoDto> buscarPorId(@PathVariable Long id) {
        InstrumentoDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<InstrumentoDto> inserir(@RequestBody @Valid InstrumentoDto dto) {
        InstrumentoDto dtoRec = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoRec.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoRec);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InstrumentoDto> atualizar(@PathVariable Long id, @RequestBody @Valid InstrumentoDto dto) {
        InstrumentoDto dtoRec = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dtoRec);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
