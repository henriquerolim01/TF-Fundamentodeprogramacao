import java.util.Scanner;

public class Main {

    private static Categoria[] categorias = new Categoria[20];
    private static int qtdCategorias = 0;

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("\n=== SISTEMA DE CONTROLE FINANCEIRO ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Categoria");
            System.out.println("3 - Cadastrar Movimentação");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Listar Categorias");
            System.out.println("6 - Listar Movimentações");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Cadastro de Usuário");
                    break;

                case 2:
                    cadastrarCategoria(entrada);
                    break;

                case 3:
                    System.out.println("Cadastro de Movimentação");
                    break;

                case 4:
                    System.out.println("Listagem de Usuários");
                    break;

                case 5:
                    listarCategorias();
                    break;

                case 6:
                    System.out.println("Listagem de Movimentações");
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static void cadastrarCategoria(Scanner entrada) {

        if (qtdCategorias >= categorias.length) {
            System.out.println("Limite de categorias atingido.");
            return;
        }

        entrada.nextLine();

        System.out.print("Nome da categoria: ");
        String nome = entrada.nextLine();

        // Verifica duplicidade
        for (int i = 0; i < qtdCategorias; i++) {

            if (categorias[i].getNome().equalsIgnoreCase(nome)) {
                System.out.println("Categoria já cadastrada.");
                return;
            }
        }

        System.out.print("Tipo (Receita ou Despesa): ");
        String tipo = entrada.nextLine();

        categorias[qtdCategorias] =
                new Categoria(qtdCategorias + 1, nome, tipo);

        qtdCategorias++;

        System.out.println("Categoria cadastrada com sucesso!");
    }

    public static void listarCategorias() {

        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada.");
            return;
        }

        System.out.println("\n=== CATEGORIAS CADASTRADAS ===");

        for (int i = 0; i < qtdCategorias; i++) {

            System.out.println(categorias[i]);
            System.out.println("--------------------");
        }
    }
}