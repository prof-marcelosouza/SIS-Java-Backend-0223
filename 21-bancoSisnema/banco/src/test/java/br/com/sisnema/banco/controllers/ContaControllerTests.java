package br.com.sisnema.banco.controllers;

import br.com.sisnema.banco.dtos.ContaDto;
import br.com.sisnema.banco.factories.FactoryFK;
import br.com.sisnema.banco.services.ContaService;
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

@WebMvcTest(ContaController.class)
public class ContaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContaService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;
    private ContaDto contaDto;
    private List<ContaDto> contaDtoList;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
        contaDto = FactoryFK.criarContaDto();
        contaDtoList = new ArrayList<>();

        when(service.procurarTodos()).thenReturn(contaDtoList);

        when(service.procurarPorId(idExistente)).thenReturn(contaDto);
        when(service.procurarPorId(idNaoExistente)).thenThrow(RecursoNaoEncontrado.class);

        when(service.inserir(any())).thenReturn(contaDto);

        when(service.atualizar(eq(idExistente), any())).thenReturn(contaDto);
        when(service.atualizar(eq(idNaoExistente), any())).thenThrow(RecursoNaoEncontrado.class);

        doNothing().when(service).excluir(idExistente);
        doThrow(RecursoNaoEncontrado.class).when(service).excluir(idNaoExistente);
    }

    @Test
    public void procurarTodosDeveriaRetornarUmaListaDeDtos() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/v1/contas")
                .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm200QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/v1/contas/{id}", idExistente)
                .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.banco").exists());
        resultado.andExpect(jsonPath("$.agencia").exists());
        resultado.andExpect(jsonPath("$.numero").exists());
        resultado.andExpect(jsonPath("$.limite").exists());
        resultado.andExpect(jsonPath("$.saldo").exists());
        resultado.andExpect(jsonPath("$.tipo_conta_id").exists());
    }

    @Test
    public void procurarPorIdDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                get("/v1/contas/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void  inserirDeveriaRetornarUm201Dto() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(contaDto);

        ResultActions resultado = mockMvc.perform(
                post("/v1/contas")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isCreated());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.banco").exists());
        resultado.andExpect(jsonPath("$.agencia").exists());
        resultado.andExpect(jsonPath("$.numero").exists());
        resultado.andExpect(jsonPath("$.limite").exists());
        resultado.andExpect(jsonPath("$.saldo").exists());
        resultado.andExpect(jsonPath("$.tipo_conta_id").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm200DtoQuandoOIdExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(contaDto);

        ResultActions resultado = mockMvc.perform(
                put("/v1/contas/{id}", idExistente)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isOk());
        resultado.andExpect(jsonPath("$.id").exists());
        resultado.andExpect(jsonPath("$.banco").exists());
        resultado.andExpect(jsonPath("$.agencia").exists());
        resultado.andExpect(jsonPath("$.numero").exists());
        resultado.andExpect(jsonPath("$.limite").exists());
        resultado.andExpect(jsonPath("$.saldo").exists());
        resultado.andExpect(jsonPath("$.tipo_conta_id").exists());
    }

    @Test
    public void atualizarDeveriaRetornarUm404DtoQuandoOIdNaoExistir() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(contaDto);

        ResultActions resultado = mockMvc.perform(
                put("/v1/contas/{id}", idNaoExistente)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

    @Test
    public void excluirDeveriaRetornarUm204QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/v1/contas/{id}", idExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNoContent());
    }

    @Test
    public void excluirDeveriaRetornarUm404QuandoOIdExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/v1/contas/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

}
