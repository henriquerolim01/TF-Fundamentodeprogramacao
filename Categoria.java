// Classe responsável por representar uma categoria de movimentação financeira
public class Categoria {

    // Atributos da categoria
    private String nome;
    private String tipo;
    private String observacoes;
    
    // Construtor vazio
    public Categoria(){

    }

    // Construtor para inicializar todos os atributos
    public Categoria(String nome, String tipo, String observacoes){
        this.nome = nome;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }

    // Métodos Getters
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public String getObservacoes(){
        return observacoes;
    }

    // Métodos Setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setObservacoes(String observacoes){
        this.observacoes = observacoes;
    }

    // Retorna as informações da categoria em formato de texto
    @Override
    public String toString() {
        return "Nome: " + nome + "\nTipo: " + tipo + "\nObservações: " + observacoes;
    }
}
