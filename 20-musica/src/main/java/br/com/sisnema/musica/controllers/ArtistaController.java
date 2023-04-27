package br.com.sisnema.musica.controllers;

import br.com.sisnema.musica.dtos.ArtistaDto;
import br.com.sisnema.musica.services.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService service;

    @GetMapping
    public ResponseEntity<List<ArtistaDto>> buscarTodos() {
        List<ArtistaDto> list = service.procurarTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ArtistaDto> buscarPorId(@PathVariable Long id) {
        ArtistaDto dto = service.procurarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}/albuns")
    public ResponseEntity<ArtistaDto> buscarPorIdComAlbuns(@PathVariable Long id) {
        ArtistaDto dto = service.procurarPorIdComAlbuns(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ArtistaDto> inserir(@RequestBody @Valid ArtistaDto dto) {
        ArtistaDto dtoRec = service.inserir(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoRec.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoRec);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ArtistaDto> atualizar(@PathVariable Long id, @RequestBody @Valid ArtistaDto dto) {
        ArtistaDto dtoRec = service.atualizar(id, dto);
        return ResponseEntity.ok().body(dtoRec);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
