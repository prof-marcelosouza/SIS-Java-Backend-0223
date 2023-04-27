package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.MusicoDto;
import br.com.sisnema.musica.services.MusicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/musicos")
public class MusicoController {

    @Autowired
    private MusicoService service;

    @GetMapping
    public ResponseEntity<List<MusicoDto>> buscarTodos() {
        List<MusicoDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicoDto> buscarPorId(@PathVariable Long id) {
        MusicoDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MusicoDto> inserir(@RequestBody @Valid MusicoDto dto) {
        MusicoDto dtoRec = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoRec.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoRec);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid MusicoDto dto) {
        MusicoDto dtoRec = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dtoRec);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
