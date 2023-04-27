package br.com.sisnema.banco.factories;

import br.com.sisnema.banco.dtos.*;
import br.com.sisnema.banco.entities.*;

import java.time.LocalDate;

public class Factory {

    public static Funcao criarFuncao() {
        Funcao funcao = new Funcao(1L, "ROLE_PILOT");
        return funcao;
    }

    public static FuncaoDto criarFuncaoDto() {
        Funcao funcao = criarFuncao();
        return new FuncaoDto(funcao);
    }

    public static TipoConta criarTipoConta() {
        TipoConta tipoConta = new TipoConta(1L, "Conjunta");
        return tipoConta;
    }

    public static TipoContaDto criarTipoContaDto() {
        TipoConta tipoConta = criarTipoConta();
        return new TipoContaDto(tipoConta);
    }

    public static Usuario criarUsuario() {
        Usuario usuario = new Usuario(1L, "Felipe", "Massa", "massa@gmail.com", "123456");
        return usuario;
    }

    public static UsuarioDto criarUsuarioDto() {
        Usuario usuario = criarUsuario();
        return new UsuarioDto(usuario);
    }

    public static Cliente criarCliente() {
        Cliente cliente = new Cliente(3L, "Auguste", "Comte", LocalDate.of(1885, 02, 02), "comte@gmail.com", "51 99344-2224");
        return cliente;
    }

    public static ClienteDto criarClienteDto() {
        Cliente cliente = criarCliente();
        return new ClienteDto(cliente);
    }

    public static Endereco criarEndereco() {
        Endereco endereco = new Endereco(4L, "Av. Bento Gonçalves", "2542", "N/A", "Centro", "96709-411", "Pelotas", "RS");
        return endereco;
    }

    public static EnderecoDto criarEnderecoDto() {
        Endereco endereco = criarEndereco();
        return new EnderecoDto(endereco);
    }
}
