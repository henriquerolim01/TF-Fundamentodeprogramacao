public class Categoria {

    private int id;
    private String nome;
    private String tipo;

    public Categoria(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nTipo: " + tipo;
    }    
}