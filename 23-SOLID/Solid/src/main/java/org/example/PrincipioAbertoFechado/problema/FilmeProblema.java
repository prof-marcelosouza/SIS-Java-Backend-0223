package org.example.PrincipioAbertoFechado.problema;

public class FilmeProblema {

    private String categoriaDaMidia;

    public String escolhaDaMidia(String midia) {
        if (midia == "Filme") {
            System.out.println("Categoria filme sendo carregada ...");
        } else if (midia == "série") {
            System.out.println("Categoria série sendo carregada ...");
        } else if (midia == "Policial") {
            System.out.println("Categoria policial sendo carregada ...");
        } else if (midia == "Documentário") {
            System.out.println("Categoria documentário sendo carregada ...");
        } else {
            System.out.println("Erro de conexão.");
        }

        return null;
    }

}
