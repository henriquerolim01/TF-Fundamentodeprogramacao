// Classe responsável por representar uma categoria de movimentação financeira
public class Categoria {

    private int id;
    private String nome;
    private String tipo;

    // Construtor para inicializar todos os atributos
    public Categoria(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Métodos Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    // Retorna as informações da categoria em formato de texto
    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nTipo: " + tipo;
    }    
}