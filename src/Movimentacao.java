public class Movimentacao {

    private int id;
    private String descricao;
    private double valor;
    private String data;

    private Usuario usuario;
    private Categoria categoria;

    public Movimentacao(int id, String descricao, double valor,
                        String data, Usuario usuario,
                        Categoria categoria) {

        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.usuario = usuario;
        this.categoria = categoria;
    }
}