import java.util.Scanner;

public class Main {

    private static GerenciadorCategorias gerenciadorCategorias = new GerenciadorCategorias();
    private static GerenciadorMovimentacoes gerenciadorMovimentacoes = new GerenciadorMovimentacoes();
    private static Conta conta = new Conta(null, true, 1, 1000.0, 500.0, "Banco X");

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
            System.out.println("7 - Gerar Relatório");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Cadastro de Usuário");
                    break;

                case 2:
                    gerenciadorCategorias.cadastrarCategoria(entrada);
                    break;

                case 3:
                    System.out.println("\n=== CADASTRO DE MOVIMENTAÇÃO ===");
                    gerenciadorMovimentacoes.cadastrarMovimentacao(entrada, conta, gerenciadorCategorias);
                    break;

                case 4:
                    System.out.println("Listagem de Usuários");
                    break;

                case 5:
                    gerenciadorCategorias.listarCategorias();
                    break;

                case 6:
                    gerenciadorMovimentacoes.listarMovimentacoes();
                    break;

                case 7:
                    gerenciadorMovimentacoes.gerarRelatorio();
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
}