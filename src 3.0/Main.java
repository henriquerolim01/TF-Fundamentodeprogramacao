
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class Main {

    private static Usuario[] usuario = new Usuario[10];
    private static Categoria[] categorias = new Categoria[20];
    private static int qtdCategorias = 0;
    private static Movimentacao[] movimentacoes = new Movimentacao[30];
    private static int qtdMovimentacoes = 0;
    private static Conta[] conta = new Conta[20];

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

    // Realiza o cadastro de um novo usuário
    private static void cadastraUsuario() {
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
        double saldo = leUsuario.nextDouble();
        ;
        System.out.println("Digite o limite da sua conta ");
        double limite = leUsuario.nextDouble();
        ;
        System.out.println("Digite seu banco");
        String banco = leUsuario.nextLine();
        int j = 0;
        do {
            j++;

        } while (!(conta[j] == null));
        conta[j] = new Conta(usuario[i], status, id, saldo, limite, banco);
        System.out.println(conta[j]);
        System.out.println("Usuario cadastrado com sucesso!");

    }

    // Efetua o login do usuário
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
        String j = "";
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

    public static void mostraSaldo(String nome) {
        for (int i = 0; i < conta.length; i++) {
            if (conta[i] != null && conta[i].getUsuario().getNome().equals(nome)) {
                System.out.println("Saldo da conta: " + conta[i].getSaldo());
            }
        }
    }

    public static void atualizaSaldo(String nome, double valor) {
        for (int i = 0; i < conta.length; i++) {
            if (conta[i] != null && conta[i].getUsuario().getNome().equals(nome)) {
                conta[i].setSaldo(valor);
            }
        }

    }

    public static void descontaSaldo(String nome, double valorGasto) {
        int contador = 0;
        for (int j = 0; j < movimentacoes.length; j++) {
            if (movimentacoes[j] != null) {
                contador++;
            }
        }
        for (int i = 0; i < conta.length; i++) {
            if (conta[i] != null && conta[i].getUsuario().getNome().equals(nome) && movimentacoes[contador - 1] != null
                    && movimentacoes[contador - 1].getCategoria().getTipo().equalsIgnoreCase("Despesa")) {
                conta[i].setSaldo(conta[i].getSaldo() - valorGasto);
                break;
            } else if (conta[i] != null && conta[i].getUsuario().getNome().equals(nome)
                    && movimentacoes[contador - 1] != null
                    && movimentacoes[contador - 1].getCategoria().getTipo().equalsIgnoreCase("Receita")) {
                conta[i].setSaldo(conta[i].getSaldo() + valorGasto);
                break;
            }
        }
    }

    public static void menu2(String nome) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("===SALDO E LIMITE===");
            mostraSaldo(nome);

            System.out.println("\n=== SISTEMA DE CONTROLE FINANCEIRO ===");
            System.out.println("1 - Alterar Saldo");
            System.out.println("2 - Cadastrar Categoria");
            System.out.println("3 - Cadastrar Movimentação");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Listar Categorias");
            System.out.println("6 - Listar Movimentações");
            System.out.println("7 - Imprimir relatório");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o novo valor:");
                    double valor = entrada.nextDouble();
                    atualizaSaldo(nome, valor);
                    break;

                case 2:
                    cadastrarCategoria(entrada);
                    break;

                case 3:
                    System.out.println("\n=== CADASTRO DE MOVIMENTAÇÃO ===");
                    double valorGasto = cadastrarMovimentacao(entrada, nome);
                    descontaSaldo(nome, valorGasto);

                    break;

                case 4:
                    System.out.println("Listagem de Usuários");
                    break;

                case 5:
                    listarCategorias();
                    break;

                case 6:
                    listarMovimentacoes(nome);
                    break;
                case 7:
                    exibirRelatorio(nome);
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        // entrada.close();
    }

    // Exibe o menu principal do sistema
    private static void menu() {
        Scanner scanf = new Scanner(System.in);
        int num;
        do {
            System.out.println("1 - Cadastrar usuario, 2 - fazer login, 3 - Sair");

            num = scanf.nextInt();

            switch (num) {
                case 1:

                    cadastraUsuario();
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

    // Cadastra uma nova categoria
    public static void cadastrarCategoria(Scanner entrada) {
        String tipo;
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
        do {
            System.out.print("Tipo (Receita ou Despesa): ");
            String aux = entrada.nextLine();
            tipo = aux.substring(0, 1).toUpperCase() + aux.substring(1).toLowerCase();
            if (!(tipo.equalsIgnoreCase("receita") || tipo.equalsIgnoreCase("despesa"))) {
                System.out.println("Ocorreu algum erro de digitação! Por favor, digite novamente!");
            }
        } while (!(tipo.equalsIgnoreCase("receita") || tipo.equalsIgnoreCase("despesa")));

        categorias[qtdCategorias] = new Categoria(qtdCategorias + 1, nome, tipo);

        qtdCategorias++;

        System.out.println("Categoria cadastrada com sucesso!");
    }

    // Lista todas as categorias cadastradas
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

    // Cadastra uma nova movimentação financeira
    public static double cadastrarMovimentacao(Scanner entrada, String nome) {
        int i;
        double valor;
        for (i = 0; i < usuario.length; i++) {
            if (usuario[i].getNome().equals(nome)) {
                break;
            }

        }
        if (qtdMovimentacoes >= movimentacoes.length) {
            System.out.println("Limite de movimentações atingido.");
            return valor = 0.0;
        }

        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada. Cadastre uma categoria antes.");
            return valor = 0.0;
        }

        int idMov = qtdMovimentacoes + 1;
        LocalDate data;
        String descricao;

        System.out.print("Valor: ");
        if (entrada.hasNextDouble()) {
            do {
                System.out.println("O valor precisa ser positivo");
                valor = entrada.nextDouble();
            } while (valor < 0);
        } else {
            System.out.println("Valor inválido! Cadastro cancelado.");
            entrada.next();
            return valor = 0.0;
        }
        System.out.print("Ano: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Ano inválido! Cadastro cancelado.");
            entrada.next();
            return valor = 0.0;
        }
        int ano = entrada.nextInt();

        System.out.print("Mês: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Mês inválido! Cadastro cancelado.");
            entrada.next();
            return valor = 0.0;
        }
        int mes = entrada.nextInt();

        System.out.print("Dia: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Dia inválido! Cadastro cancelado.");
            entrada.next();
            return valor = 0.0;
        }
        int dia = entrada.nextInt();

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido! Cadastro cancelado.");
            return valor = 0.0;
        }
        if (dia < 1 || dia > 31) {
            System.out.println("Dia inválido! Cadastro cancelado.");
            return valor = 0.0;
        }

        data = LocalDate.of(ano, mes, dia);

        listarCategorias();
        System.out.print("Escolha o número da categoria: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Entrada inválida! Cadastro cancelado.");
            entrada.next();
            return valor = 0.0;
        }
        int categoriaSelec = entrada.nextInt();
        if (categoriaSelec < 0 || categoriaSelec > qtdCategorias) {
            System.out.println("Categoria inválida! Cadastro cancelado.");
            return valor = 0.0;
        }
        Categoria categ = categorias[categoriaSelec];

        entrada.nextLine();
        System.out.print("Descrição: ");
        descricao = entrada.nextLine();

        movimentacoes[qtdMovimentacoes] = new Movimentacao(idMov, descricao, valor, data, usuario[i], categ);
        qtdMovimentacoes++;

        System.out.println("Movimentação cadastrada com sucesso!");
        return valor;
    }

    // Lista as movimentações do usuário logado
    public static void listarMovimentacoes(String nome) {

        if (qtdMovimentacoes == 0) {
            System.out.println("Nenhuma movimentação cadastrada.");
            return;
        }

        System.out.println("\n=== MOVIMENTAÇÕES CADASTRADAS ===");

        for (int i = 0; i < qtdMovimentacoes; i++) {
            if (movimentacoes[i].getUsuario().getNome().equals(nome)) {
                System.out.println(movimentacoes[i]);
                System.out.println("--------------------");
            }
        }
    }

    // Gera um relatório filtrado por categoria e período
    public static void exibirRelatorio(String nome) {
        Scanner entrada = new Scanner(System.in);
        int contador = 0;
        int id;
        boolean verificador = true;
        String catSave = null;
        if (qtdCategorias == 0) {
            System.out.println("Nenhuma categoria cadastrada. Cadastre uma categoria antes.");
            return;
        }
        System.out.println("Selecione a categoria");
        listarCategorias();
        do {
            if (contador > 0) {
                System.out.println("Selecione uma Categoria Válida");
            }
            id = entrada.nextInt();
            contador++;
            for (int i = 0; i < categorias.length; i++) {
                if (categorias[i] != null && categorias[i].getId() == id) {
                    verificador = true;
                    catSave = categorias[i].getNome();
                    break;
                } else {
                    verificador = false;
                }
            }
        } while (verificador == false);
        boolean dataCerta = false;
        LocalDate dataInicio = null;
        LocalDate dataFim = null;

        while (!dataCerta) {
            System.out.println("Digite a data de inicio do relatório (YYYY-mm-dd)");

            String inicio = entrada.nextLine();
            String lixo = entrada.nextLine();
            System.out.println("Digite a data de fim do relatório (YYYY-mm-dd)");
            String fim = entrada.nextLine();

            try {
                dataInicio = LocalDate.parse(inicio);
                dataFim = LocalDate.parse(fim);
                dataCerta = true;

            } catch (DateTimeParseException e) {
                System.out.println("Formato inexistente, tente novamente");

            }

        }

        Double total = 0.0;

        for (int j = 0; j < movimentacoes.length; j++) {
            if (movimentacoes[j] != null) {
                LocalDate dataDaMovimentacao = movimentacoes[j].getData();
                boolean intervalo = !dataDaMovimentacao.isBefore(dataInicio) && !dataDaMovimentacao.isAfter(dataFim);
                if (intervalo) {
                    if (movimentacoes[j].getCategoria().getNome().equals(catSave)
                            && movimentacoes[j].getUsuario().getNome().equals(nome)) {
                        System.out.println(
                                "Data:" + movimentacoes[j].getData() + "Valor: " + movimentacoes[j].getValor());
                        total = total + movimentacoes[j].getValor();
                    }

                }
            }
        }
        System.out.println("Total: " + total);

    }

    public static void main(String[] args) {
        usuario[0] = new Usuario("Jonas", 20, 'M', "jonas@gmail.com", "1235");
        usuario[1] = new Usuario("Carlos", 30, 'M', "carlos123@hotmail.com", "paodemel");
        usuario[2] = new Usuario("admin", 0, 'M', "admin@gmail.com", "adm321");
        conta[0] = new Conta(usuario[0], true, 0, 1000, 500, null);
        categorias[0] = new Categoria(0, "Alimentação", "Despesa");
        categorias[1] = new Categoria(1, "Conta de Luz", "Despesa");
        categorias[2] = new Categoria(2, "Salário", "Receita");
        for (int i = 0; i < categorias.length; i++) {
            if (categorias[i] != null)
                qtdCategorias++;
        }
        menu();
    }

}