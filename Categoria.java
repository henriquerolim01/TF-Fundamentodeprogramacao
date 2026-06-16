public class Categoria {
    private String nome;
    private String tipo;
    private String observacoes;

    public Categoria(){

    }
    public Categoria(String nome, String tipo, String observacoes){
        this.nome = nome;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }
    public String getNome(){
        return nome;
    }
    public String getTipo(){
        return tipo;
    }
    public String getObservacoes(){
        return observacoes;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setObservacoes(String observacoes){
        this.observacoes = observacoes;
    }
    @Override
    public String toString() {
         return "Nome: " + nome + "\nTipo: " + tipo + "\nObservações: " + observacoes;
    }
}
