import java.util.Scanner;

public class GerenciadorCategorias {

    private Categoria[] categorias;
    private int qtdCategorias;

    public GerenciadorCategorias() {
        categorias = new Categoria[20];
        qtdCategorias = 0;
    }

    public void cadastrarCategoria(Scanner entrada) {

        if (qtdCategorias >= categorias.length) {
            System.out.println("Limite de categorias atingido.");
            return;
        }

        System.out.print("Nome da categoria: ");
        String nome = entrada.nextLine();

        // Verifica se já existe
        for (int i = 0; i < qtdCategorias; i++) {

            if (categorias[i].getNome().equalsIgnoreCase(nome)) {
                System.out.println("Categoria já cadastrada.");
                return;
            }
        }

        System.out.print("Tipo (Receita ou Despesa): ");
        String tipo = entrada.nextLine();

        System.out.print("Observações: ");
        String observacoes = entrada.nextLine();

        categorias[qtdCategorias] =
                new Categoria(nome, tipo, observacoes);

        qtdCategorias++;

        System.out.println("Categoria cadastrada com sucesso!");
    }

    public void listarCategorias() {

        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        System.out.println("\n=== CATEGORIAS CADASTRADAS ===");

        for (int i = 0; i < qtdCategorias; i++) {

            System.out.println(categorias[i]);
            System.out.println("------------------------");
        }
    }

    public Categoria buscarCategoria(String nome) {

        for (int i = 0; i < qtdCategorias; i++) {

            if (categorias[i].getNome().equalsIgnoreCase(nome)) {
                return categorias[i];
            }
        }

        return null;
    }
}