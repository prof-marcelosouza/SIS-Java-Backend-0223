package br.com.sisnema.banco.controllers;

import br.com.sisnema.banco.dtos.EnderecoDto;
import br.com.sisnema.banco.factories.Factory;
import br.com.sisnema.banco.services.EnderecoService;
import br.com.sisnema.banco.services.exceptions.RecursoNaoEncontrado;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EnderecoController.class)
public class EnderecoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnderecoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;
    private EnderecoDto enderecoDto;
    private List<EnderecoDto> enderecoDtoList;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        enderecoDto = Factory.criarEnderecoDto();
        enderecoDtoList = new ArrayList<>();

        when(service.procurarTodos()).thenReturn(enderecoDtoList);

        when(service.procurarPorId(idExistente)).thenReturn(enderecoDto);
        when(service.procurarPorId(idNaoExistente)).thenThrow(RecursoNaoEncontrado.class);

        when(service.inserir(any())).thenReturn(enderecoDto);

        when(service.atualizar(eq(idExistente), any())).thenReturn(enderecoDto);
        when(service.atualizar(eq(idNaoExistente), any())).thenThrow(RecursoNaoEncontrado.class);

        doNothing().when(service).excluir(idExistente);
        doThrow(RecursoNaoEncontrado.class).when(service).excluir(idNaoExistente);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/v1/enderecos")
                .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm200QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/v1/enderecos/{id}", idExistente)
                .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.logradouro").exists());
        resultado.andExpect(jsonPath("$.numero").exists());
        resultado.andExpect(jsonPath("$.complemento").exists());
        resultado.andExpect(jsonPath("$.bairro").exists());
        resultado.andExpect(jsonPath("$.cep").exists());
        resultado.andExpect(jsonPath("$.cidade").exists());
        resultado.andExpect(jsonPath("$.estado").exists());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/v1/enderecos/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void  inserirDeveriaRetornarUm201Dto() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(enderecoDto);

        ResultActions resultado = mockMvc.perform(
                post("/v1/enderecos")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isCreated());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.logradouro").exists());
        resultado.andExpect(jsonPath("$.numero").exists());
        resultado.andExpect(jsonPath("$.complemento").exists());
        resultado.andExpect(jsonPath("$.bairro").exists());
        resultado.andExpect(jsonPath("$.cep").exists());
        resultado.andExpect(jsonPath("$.cidade").exists());
        resultado.andExpect(jsonPath("$.estado").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm200DtoQuandoOIdExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(enderecoDto);

        ResultActions resultado = mockMvc.perform(
                put("/v1/enderecos/{id}", idExistente)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.logradouro").exists());
        resultado.andExpect(jsonPath("$.numero").exists());
        resultado.andExpect(jsonPath("$.complemento").exists());
        resultado.andExpect(jsonPath("$.bairro").exists());
        resultado.andExpect(jsonPath("$.cep").exists());
        resultado.andExpect(jsonPath("$.cidade").exists());
        resultado.andExpect(jsonPath("$.estado").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm404DtoQuandoOIdNaoExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(enderecoDto);

        ResultActions resultado = mockMvc.perform(
                put("/v1/enderecos/{id}", idNaoExistente)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirDeveriaRetornarUm204QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/v1/enderecos/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirDeveriaRetornarUm404QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/v1/enderecos/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

}
