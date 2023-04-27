package entities;

public abstract class Professor {

    private int id;
    private String nome;
    private String email;

    public Professor() {
    }

    public Professor(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // método abstrato
    public abstract double calcularSalario(double base, double percDesc);

    public void mostrarSalario() {
        System.out.println("Salário: " + calcularSalario(1000.0, 0.0));
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
