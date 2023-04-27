import entities.Carrinho;

public class Main {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();
        carrinho.setId(1);
        carrinho.setItem("Impressora Epson LX-300");
        carrinho.setQuantidade(2);
        carrinho.setValor(699.39);
        carrinho.setPromocao(false);

        Carrinho carrinho2 = new Carrinho();
        carrinho2.setId(1);
        carrinho2.setItem("Impressora Samsung");
        carrinho2.setQuantidade(2);
        carrinho2.setValor(699.39);
        carrinho2.setPromocao(false);

        // Chamando o método sem parãmetros
//        System.out.println("Valor total do item: " + carrinho.calcularTotalItem());
//        System.out.println(carrinho);

        // Chamando o método com parâmetros
//        System.out.println("Valor total do item modificado: " + carrinho.alterarValorItem(29.20));
//        System.out.println("Valor total do item: " + carrinho.calcularTotalItem());
//        System.out.println(carrinho);

//        System.out.println(carrinho.getItem().hashCode());
//        System.out.println(carrinho2.getItem().hashCode());

        Carrinho carrinho3 = null;
        System.out.println(carrinho3.getItem());
    }
}