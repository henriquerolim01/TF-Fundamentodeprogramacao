public class Categoria {
    private String nome;
    private int tipo;
    private String observacoes;

    public Categoria(){

    }
    public Categoria(String nome, int tipo, String observacoes){
        this.nome = nome;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }
    public String getNome(){
        return nome;
    }
    public int getTipo(){
        return tipo;
    }
    public String getObservacoes(){
        return observacoes;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    public void setObservacoes(String observacoes){
        this.observacoes = observacoes;
    }
    public String toString(){
        return "depois eu escrevo 2";
    }
    
}
