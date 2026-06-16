public class Movimentacao {
    private Conta conta;
    private String data;
    private int id;
    private Categoria categoria;
    private double valor;
    private String observacoes;

    public Movimentacao() {

    }

    public Movimentacao(Conta conta, String data, int id, Categoria categoria, double valor, String observacoes) {
        this.conta = conta;
        this.data = data;
        this.id = id;
        this.categoria = categoria;
        this.valor = valor;
        this.observacoes = observacoes;
    }

    public Conta getConta() {
        return conta;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String toString() {
        return "depois escrevo";
    }

}
