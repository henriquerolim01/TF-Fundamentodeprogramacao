
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static Usuario[] usuario = new Usuario[10];
    private static Categoria[] categorias = new Categoria[20];
    private static int qtdCategorias = 0;
    private static Movimentacao[] movimentacoes = new Movimentacao[30];
    private static int qtdMovimentacoes = 0;
    private static Conta[] conta = new Conta [20];
    

    private static String verificaEmail() {
        Scanner leEmail = new Scanner(System.in);
        String email;
        String inicioEmail;

        do {
            System.out.println("ele precisa conter pelo menos 3 caracteres antes do @, o @ e precisa ser hotmail.com");
            email = leEmail.nextLine();
            int arroba = email.indexOf("@");
            inicioEmail = email.substring(0, arroba + 1);

        } while (!(email.contains("@") == true && email.endsWith("@hotmail.com") && inicioEmail.length() > 4 == true));
        System.out.println("Validação concluída! Email OK");
        return email;
    }

    public static String verificaSenha() {
        String senha;
        Scanner leSenha = new Scanner(System.in);
        do {
            System.out.println("A senha deve conter pelo menos 7 caracteres e conter @ ou & ou %");
            senha = leSenha.nextLine();

        } while (!(senha.length() > 8 == true
                && (senha.contains("@") == true || senha.contains("&") || senha.contains("%"))));
        System.out.println("Senha cadastrada com sucesso");
        return senha;
    }

    public static int verificaIndice() {
        int i = 0;
        do {

            i++;
        } while (!(usuario[i] == null));
        return i;

    }

    private static Conta[] cadastraUsuario() {
        String nome;
        int idade;
        char genero;
        String email;
        String senha;
        int i;
        Scanner leUsuario = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        nome = leUsuario.nextLine();
        do {
            System.out.println("Digite sua idade:");
            idade = leUsuario.nextInt();
        } while (idade < 18);
        do {
            System.out.println("Digite seu gênero (M/F)");
            genero = leUsuario.next().charAt(0);
        } while (!(genero == 'M' || genero == 'F'));
        System.out.println("Digite seu e-mail");
        email = verificaEmail();
        System.out.println("Digite sua senha");
        senha = verificaSenha();
        System.out.println("senha" + senha);
        i = verificaIndice();
        usuario[i] = new Usuario(nome, idade, genero, email, senha);
        boolean status = true;
        int id = i;
        System.out.println("Digite seu saldo");
        double saldo = leUsuario.nextDouble();;
        System.out.println("Digite o limite da sua conta ");
        double limite = leUsuario.nextDouble();;
        System.out.println("Digite seu banco");
        String banco = leUsuario.nextLine();
        int j=0;
        do{
            j++;

        }while(!(conta[j]==null));
        conta [j]= new Conta(usuario[i], status, id, saldo, limite, banco);
        System.out.println(conta[j]);
        System.out.println("Usuario cadastrado com sucesso!");
        return conta;

    }

    public static String login() {
        Scanner leDados = new Scanner(System.in);
        String email;
        String nome = "";
        String senha;
        boolean verificaEmail;
        boolean verificaSenha;
        int contador = 0;
        do {
            if (contador > 0) {
                System.out.println("Credenciais incorretas");
            }
            System.out.println("Digite seu email");
            email = leDados.nextLine();
            System.out.println("Digite sua senha");
            senha = leDados.nextLine();
            verificaEmail = procuraEmail(email);
            verificaSenha = procuraSenha(senha);
            contador++;
        } while ((verificaEmail == false || verificaSenha == false));
        System.out.println("Loggin efetuado com sucesso!");
        nome = salvaUsuario(email);
        return nome;
    }

    public static String salvaUsuario(String email) {
        String j ="";
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] != null && usuario[i].getEmail().equals(email)) {
                j = usuario[i].getNome();
                break;

            } else {
                
            }

        }
        return j;

    }

    public static boolean procuraEmail(String email) {
        boolean j = true;
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] != null && usuario[i].getEmail().equals(email)) {
                j = true;
                break;

            } else {
                j = false;
            }

        }
        return j;

    }

    public static boolean procuraSenha(String senha) {
        boolean j = true;
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] != null && usuario[i].getSenha().equals(senha)) {
                j = true;
                break;

            } else {
                j = false;
            }
        }
        return j;
    }

    public static void menu2(String nome){
        int opcao;
        Scanner entrada = new Scanner(System.in);

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
                    System.out.println("\n=== CADASTRO DE MOVIMENTAÇÃO ===");
                    cadastrarMovimentacao(entrada, nome);
                    break;

                case 4:
                    System.out.println("Listagem de Usuários");
                    break;

                case 5:
                    listarCategorias();
                    break;

                case 6:
                    listarMovimentacoes();
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

    private static void menu() {
        Scanner scanf = new Scanner(System.in);
        int num;
        do {
            System.out.println("1 - Cadastrar usuario, 2 - fazer login, 3 - Sair");

            num = scanf.nextInt();

            switch (num) {
                case 1:
                    Conta[] c1 = cadastraUsuario();


                    break;
                case 2:
                    String nome = login();
                    menu2(nome);
                    break;

                default:
                    break;
            }
        } while (num != 3);

    }
    public static void cadastrarCategoria(Scanner entrada) {

        if (qtdCategorias >= categorias.length) {
            System.out.println("Limite de categorias atingido.");
            return;
        }

        entrada.nextLine();

        System.out.print("Nome da categoria: ");
        String nome = entrada.nextLine();

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

    public static void cadastrarMovimentacao(Scanner entrada, String nome) {
        int i;
        for (i = 0; i<usuario.length; i++){
            if (usuario[i].getNome().equals(nome)){
                break;
            }

        }
        if (qtdMovimentacoes >= movimentacoes.length) {
            System.out.println("Limite de movimentações atingido.");
            return;
        }

        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada. Cadastre uma categoria antes.");
            return;
        }

        int idMov = qtdMovimentacoes + 1;
        double valor;
        LocalDate data = LocalDate.now();
        String descricao;

        System.out.print("Valor: ");
        if (entrada.hasNextDouble()) {
            valor = entrada.nextDouble();
        } else {
            System.out.println("Valor inválido! Cadastro cancelado.");
            entrada.next();
            return;
        }

        listarCategorias();
        System.out.print("Escolha o número da categoria: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Entrada inválida! Cadastro cancelado.");
            entrada.next();
            return;
        }
        int categoriaSelec = entrada.nextInt();
        if (categoriaSelec < 1 || categoriaSelec > qtdCategorias) {
            System.out.println("Categoria inválida! Cadastro cancelado.");
            return;
        }
        Categoria categ = categorias[categoriaSelec - 1];

        entrada.nextLine();
        System.out.print("Descrição: ");
        descricao = entrada.nextLine();

        movimentacoes[qtdMovimentacoes] = new Movimentacao(idMov, descricao, valor, data, usuario[i], categ);
        qtdMovimentacoes++;

        System.out.println("Movimentação cadastrada com sucesso!");
    }

    public static void listarMovimentacoes() {

        if (qtdMovimentacoes == 0) {
            System.out.println("Nenhuma movimentação cadastrada.");
            return;
        }

        System.out.println("\n=== MOVIMENTAÇÕES CADASTRADAS ===");

        for (int i = 0; i < qtdMovimentacoes; i++) {
            System.out.println(movimentacoes[i]);
            System.out.println("--------------------");
        }
    }


    public static void main(String[] args) {
        usuario[0] = new Usuario("Jonas", 20, 'M', "jonas@gmail.com", "1235");
        usuario[1] = new Usuario("Carlos", 30, 'M', "carlos123@hotmail.com", "paodemel");
        usuario[2] = new Usuario("admin", 0, 'M', "admin@gmail.com", "adm321");

        menu();

        for (int i = 0; i < 10; i++) {
            System.out.println("Posição" + i + ": " + usuario[i]);

        }

    }

}
