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

        System.out.println("Tipo da categoria:");
        System.out.println("1 - Receita");
        System.out.println("2 - Despesa");
        System.out.print("Escolha: ");

        if (!entrada.hasNextInt()) {
            System.out.println("Opção inválida! Cadastro cancelado.");
            entrada.next();
            return;
        }
        int opcaoTipo = entrada.nextInt();
        entrada.nextLine();

        String tipo;
        if (opcaoTipo == 1) {
            tipo = "Receita";
        } else if (opcaoTipo == 2) {
            tipo = "Despesa";
        } else {
            System.out.println("Opção inválida! Cadastro cancelado.");
            return;
        }

        System.out.print("Observações: ");
        String observacoes = entrada.nextLine();

        categorias[qtdCategorias] =
        new Categoria(qtdCategorias + 1, nome, tipo, observacoes);

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

        System.out.println("Novo tipo da categoria:");
        System.out.println("1 - Receita");
        System.out.println("2 - Despesa");
        System.out.print("Escolha: ");

        if (!entrada.hasNextInt()) {
            System.out.println("Opção inválida! Edição cancelada.");
            entrada.next();
            return;
        }
        int opcaoTipo = entrada.nextInt();
        entrada.nextLine();

        String novoTipo;
        if (opcaoTipo == 1) {
            novoTipo = "Receita";
        } else if (opcaoTipo == 2) {
            novoTipo = "Despesa";
        } else {
            System.out.println("Opção inválida! Edição cancelada.");
            return;
        }

        System.out.print("Novas observações: ");
        String novasObservacoes = entrada.nextLine();

        categoria.setNome(novoNome);
        categoria.setTipo(novoTipo);
        categoria.setObservacoes(novasObservacoes);

        System.out.println("Categoria editada com sucesso!");
    }

    public int getQtdCategorias() {
        return qtdCategorias;
    }

    public Categoria getCategoria(int indice) {
        return categorias[indice];
    }
}