import java.time.LocalDate;

// Classe responsável por representar uma movimentação financeira
public class Movimentacao {

    // Atributos da movimentação
    private int id;
    private String descricao;
    private double valor;
    private LocalDate data;

    // Relacionamentos da movimentação
    private Usuario usuario;
    private Categoria categoria;

    // Construtor para inicializar todos os atributos
    public Movimentacao(int id, String descricao, double valor,
                        LocalDate data, Usuario usuario,
                        Categoria categoria) {

        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    // Métodos Getters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Retorna as informações da movimentação em formato de texto
    @Override
    public String toString() {
        return "ID: " + id +
               "\nDescrição: " + descricao +
               "\nValor: R$ " + String.format("%.2f", valor) +
               "\nData: " + data +
               "\nCategoria: " + categoria.getNome() +
               "\nTipo: " + categoria.getTipo() +
               "\nUsuário: " + usuario.getNome();
    }
}