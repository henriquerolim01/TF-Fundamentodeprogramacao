public class Usuario {

    private int id;
    private String nome;
    private int idade;
    private char genero;

    public Usuario() {
    }

    public Usuario(int id, String nome, int idade, char genero) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public int getId() {
        return id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               "\nNome: " + nome +
               "\nIdade: " + idade +
               "\nGênero: " + genero;
    }
}