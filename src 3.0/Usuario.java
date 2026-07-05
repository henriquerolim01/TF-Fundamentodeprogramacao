public class Usuario {
    private String nome;
    private int idade;
    private char genero;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, int idade, char genero, String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
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
    public String getEmail(){
        return email;
    }
    public String getSenha(){
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public String toString() {
        return "Nome:" + nome + "; Idade: " + idade + "; Genero: " + genero;
    }

}
