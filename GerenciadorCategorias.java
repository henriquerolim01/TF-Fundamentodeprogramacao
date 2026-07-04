import java.util.Scanner;

// Classe responsável por gerenciar todas as categorias cadastradas
public class GerenciadorCategorias {

    // Vetor que armazena as categorias cadastradas
    private Categoria[] categorias;
    // Controla a quantidade de categorias cadastradas
    private int qtdCategorias;

    public GerenciadorCategorias() {
        categorias = new Categoria[20];
        qtdCategorias = 0;
    }

    // Realiza o cadastro de uma nova categoria
    public void cadastrarCategoria(Scanner entrada) {

        // Verifica se o vetor já atingiu sua capacidade máxima
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

    // Lista todas as categorias cadastradas
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

    // Procura uma categoria pelo nome
    public Categoria buscarCategoria(String nome) {

        for (int i = 0; i < qtdCategorias; i++) {

            if (categorias[i].getNome().equalsIgnoreCase(nome)) {
                return categorias[i];
            }
        }

        return null;
    }

    // Permite alterar os dados de uma categoria já cadastrada
    public void editarCategoria(Scanner entrada) {

        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        System.out.print("Digite o nome da categoria que deseja editar: ");
        String nome = entrada.nextLine();

        Categoria categoria = buscarCategoria(nome);

        if (categoria == null) {
            System.out.println("Categoria não encontrada.");
            return;
        }

        System.out.print("Novo nome: ");
        String novoNome = entrada.nextLine();

        // Verifica se tem duplicidade
        for (int i = 0; i < qtdCategorias; i++) {

            if (categorias[i].getNome().equalsIgnoreCase(novoNome)
                    && categorias[i] != categoria) {

                System.out.println("Já existe uma categoria com esse nome.");
                return;
            }
        }

        System.out.print("Novo tipo (Receita ou Despesa): ");
        String novoTipo = entrada.nextLine();

        System.out.print("Novas observações: ");
        String novasObservacoes = entrada.nextLine();

        categoria.setNome(novoNome);
        categoria.setTipo(novoTipo);
        categoria.setObservacoes(novasObservacoes);

        System.out.println("Categoria editada com sucesso!");
    }
}