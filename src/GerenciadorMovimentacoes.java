import java.util.Scanner;
import java.time.LocalDate;

public class GerenciadorMovimentacoes {

    private Movimentacao[] movimentacoes = new Movimentacao[30];
    private int qtdMovimentacoes = 0;

    public void cadastrarMovimentacao(Scanner entrada, Conta conta, GerenciadorCategorias gerenciadorCategorias) {

        if (qtdMovimentacoes >= movimentacoes.length) {
            System.out.println("Limite de movimentações atingido.");
            return;
        }

        if (gerenciadorCategorias.getQtdCategorias() == 0) {
            System.out.println("Nenhuma categoria cadastrada. Cadastre uma categoria antes.");
            return;
        }

        int idMov = qtdMovimentacoes + 1;
        double valor;
        LocalDate data;
        String descricao;

        System.out.print("Valor: ");
        if (entrada.hasNextDouble()) {
            valor = entrada.nextDouble();
        } else {
            System.out.println("Valor inválido! Cadastro cancelado.");
            entrada.next();
            return;
        }

        System.out.print("Ano: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Ano inválido! Cadastro cancelado.");
            entrada.next();
            return;
        }
        int ano = entrada.nextInt();

        System.out.print("Mês: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Mês inválido! Cadastro cancelado.");
            entrada.next();
            return;
        }
        int mes = entrada.nextInt();

        System.out.print("Dia: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Dia inválido! Cadastro cancelado.");
            entrada.next();
            return;
        }
        int dia = entrada.nextInt();

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido! Cadastro cancelado.");
            return;
        }
        if (dia < 1 || dia > 31) {
            System.out.println("Dia inválido! Cadastro cancelado.");
            return;
        }

        data = LocalDate.of(ano, mes, dia);

        gerenciadorCategorias.listarCategorias();
        System.out.print("Escolha o número da categoria: ");
        if (!entrada.hasNextInt()) {
            System.out.println("Entrada inválida! Cadastro cancelado.");
            entrada.next();
            return;
        }
        int categoriaSelec = entrada.nextInt();
        if (categoriaSelec < 1 || categoriaSelec > gerenciadorCategorias.getQtdCategorias()) {
            System.out.println("Categoria inválida! Cadastro cancelado.");
            return;
        }
        Categoria categ = gerenciadorCategorias.getCategoria(categoriaSelec - 1);

        // Ajuste de saldo/limite conforme o tipo
        if (categ.getTipo().equalsIgnoreCase("Despesa")) {

            if (valor > conta.getSaldo() + conta.getLimite()) {
                System.out.println("Saldo e limite insuficientes! Cadastro cancelado.");
                return;
            }

            if (valor <= conta.getSaldo()) {
                conta.setSaldo(conta.getSaldo() - valor);
            } else {
                double resto = valor - conta.getSaldo();
                conta.setSaldo(0);
                conta.setLimite(conta.getLimite() - resto);
            }

        } else if (categ.getTipo().equalsIgnoreCase("Receita")) {
            conta.setSaldo(conta.getSaldo() + valor);
        }

        entrada.nextLine();
        System.out.print("Descrição: ");
        descricao = entrada.nextLine();

        movimentacoes[qtdMovimentacoes] = new Movimentacao(idMov, descricao, valor, data, conta, categ);
        qtdMovimentacoes++;

        System.out.println("Movimentação cadastrada com sucesso!");
    }

    public void listarMovimentacoes() {

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

    public void gerarRelatorio() {

        if (qtdMovimentacoes == 0) {
            System.out.println("Nenhuma movimentação cadastrada.");
            return;
        }

        double totalReceitas = 0;
        double totalDespesas = 0;

        for (int i = 0; i < qtdMovimentacoes; i++) {
            Movimentacao m = movimentacoes[i];
            Categoria c = m.getCategoria();

            System.out.println(m);
            System.out.println("--------------------");

            if (c.getTipo().equalsIgnoreCase("Receita")) {
                totalReceitas += m.getValor();
            } else if (c.getTipo().equalsIgnoreCase("Despesa")) {
                totalDespesas += m.getValor();
            }
        }

        System.out.println("\n=== RELATÓRIO ===");
        System.out.println("Total de receitas: R$ " + String.format("%.2f", totalReceitas));
        System.out.println("Total de despesas: R$ " + String.format("%.2f", totalDespesas));
        System.out.println("Saldo: R$ " + String.format("%.2f", totalReceitas - totalDespesas));
    }
}