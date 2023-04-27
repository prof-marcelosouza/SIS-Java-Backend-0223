package br.com.sisnema.banco.controllers.TI;

import br.com.sisnema.banco.dtos.EnderecoDto;
import br.com.sisnema.banco.factories.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EnderecoControllerTestsTI {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Long idExistente;
    private Long idNaoExistente;

    @BeforeEach
    void Setup() throws Exception {
        idExistente = 1L;
        idNaoExistente = 999L;
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
    public void procurarPorIdDeveriaRetornarUmDtoQuandoOIdExistir() throws Exception {
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
    public void inserirDeveriaRetornarUmObjetoDto() throws Exception {

        EnderecoDto dto = Factory.criarEnderecoDto();
        String jsonBody = objectMapper.writeValueAsString(dto);

        ResultActions resultado = mockMvc.perform(
                post("/v1/enderecos")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
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
    public void atualizarDeveriaRetornarUmObjetoDto() throws Exception {

        EnderecoDto dto = Factory.criarEnderecoDto();
        String jsonBody = objectMapper.writeValueAsString(dto);

        ResultActions resultado = mockMvc.perform(
                put("/v1/enderecos/{id}", idExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
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
    public void atualizarDeveriaRetornarUm404IdNaoExistente() throws Exception {

        EnderecoDto dto = Factory.criarEnderecoDto();
        String jsonBody = objectMapper.writeValueAsString(dto);

        ResultActions resultado = mockMvc.perform(
                put("/v1/enderecos/{id}", idNaoExistente)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
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
    public void excluirDeveriaRetornarUm404QuandoOIdNaoExistir() throws Exception {
        ResultActions resultado = mockMvc.perform(
                delete("/v1/enderecos/{id}", idNaoExistente)
                        .accept(MediaType.APPLICATION_JSON)
        );

        resultado.andExpect(status().isNotFound());
    }

}
