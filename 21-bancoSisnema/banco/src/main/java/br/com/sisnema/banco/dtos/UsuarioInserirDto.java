package br.com.sisnema.banco.dtos;

public class UsuarioInserirDto extends UsuarioDto {
    private static final Long serialVersionUID = 1L;

    private String senha;

    public UsuarioInserirDto() {
        super();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
