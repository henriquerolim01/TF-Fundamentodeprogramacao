import java.time.LocalDate;

public class Movimentacao {

    private int id;
    private String descricao;
    private double valor;
    private LocalDate data;

    private Conta conta;
    private Categoria categoria;

    public Movimentacao(int id, String descricao, double valor,
                        LocalDate data, Conta conta,
                        Categoria categoria) {

        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.conta = conta;
        this.categoria = categoria;
    }

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

    public Conta getConta() {
        return conta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               "\nDescrição: " + descricao +
               "\nValor: R$ " + String.format("%.2f", valor) +
               "\nData: " + data +
               "\nCategoria: " + categoria.getNome() +
               "\nTipo: " + categoria.getTipo() +
               "\nConta: " + conta.getId();
    }
}