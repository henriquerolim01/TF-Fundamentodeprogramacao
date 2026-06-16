public class Usuario {
    private String nome;
    private int idade;
    private char genero;

    public Usuario() {
    }

    public Usuario(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public char getGenero() {
        return genero;

    }
    public void setNome (String nome){
        this.nome = nome;
    }
    public void setIdade (int idade){
        this.idade = idade;
    }
    public void setGenero (char genero){
        this.genero = genero;
    }
    public String toString(){
        return "Nome:" +nome+ "; Idade: " +idade+ "; Genero: " +genero;
    }
    

}
