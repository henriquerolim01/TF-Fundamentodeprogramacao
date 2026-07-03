public class Categoria {

    private int id;
    private String nome;
    private String tipo;
    private String observacoes;

    public Categoria() {

    }

    public Categoria(int id, String nome, String tipo, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.observacoes = observacoes;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\nObservações: " + observacoes;
    }
}