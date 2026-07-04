// Classe responsável por representar uma movimentação financeira
public class Movimentacao {

    // Atributos da movimentação
    private Conta conta;
    private String data;
    private int id;
    private Categoria categoria;
    private double valor;
    private String observacoes;

    // Construtor vazio
    public Movimentacao() {

    }

    // Construtor para inicializar todos os atributos
    public Movimentacao(Conta conta, String data, int id, Categoria categoria, double valor, String observacoes) {
        this.conta = conta;
        this.data = data;
        this.id = id;
        this.categoria = categoria;
        this.valor = valor;
        this.observacoes = observacoes;
    }

    // Métodos Getters
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

    // Métodos Setters
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // Retorna as informações da movimentação em formato de texto
    @Override
    public String toString() {
        return "Conta: " + conta +
               "\nData: " + data +
               "\nID: " + id +
               "\nCategoria: " + categoria +
               "\nValor: " + valor +
               "\nObservações: " + observacoes;
    }
}