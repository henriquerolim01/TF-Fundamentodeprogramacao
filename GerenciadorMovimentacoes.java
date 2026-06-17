public class GerenciadorMovimentacoes {

    private Movimentacao[] movimentacoes;
    private int qtdMovimentacoes;
    private GerenciadorCategorias gerenciadorCategorias;

    public GerenciadorMovimentacoes(GerenciadorCategorias gerenciadorCategorias) {
        movimentacoes = new Movimentacao[50];
        qtdMovimentacoes = 0;
        this.gerenciadorCategorias = gerenciadorCategorias;
    }
}