import entities.Produto;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        Produto p1 = new Produto();
        p1.setId(1);
        p1.setNome("Microfone Condensador");
        p1.setDesc("Este microfone é omnidirecional");
        p1.setValor(49.95);
        p1.setEstoque(55);
        p1.setDataCadastro(Instant.now());

        Produto p2 = new Produto();
        p2.setId(2);
        p2.setNome("Impressora HP MFP128fn");
        p2.setDesc("Impressora multifuncional da HP - LaserJet");
        p2.setValor(650.40);
        p2.setEstoque(95);
        p2.setDataCadastro(Instant.now());

        Produto p3 = new Produto(3, "Mouse Óptico Logitech", "Kit Mouse + teclado sem fio", 110.20,65, Instant.now());

        System.out.println("ID: " + p1.getId());
        System.out.println("Nome: " + p1.getNome());
        System.out.println("Descrição: " + p1.getDesc());
        System.out.println("Valor: " + p1.getValor());
        System.out.println("Estoque: " + p1.getEstoque());
        System.out.println("Data de cadastro: " + p1.getDataCadastro());

        System.out.println(p2);
        System.out.println(p3);

    }
}