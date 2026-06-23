# Trabalho Final - Fundamentos de Programação
#### Turma 034 - 2026/1
#### Disciplina: Fundamentos de Programação
#### Professora: Aline Campos

## Integrantes
|Integrantes     |Matrícula |
|---|---|
|Guilherme Machado|24200740  |
|Henrique Rolim   |25280332  |
|Rodrigo Bacchin  |25200604  |

## Descrição Geral do Sistema
O projeto consiste em um Sistema de Controle Financeiro Pessoal desenvolvido em Java. O sistema será executado em terminal e utilizará conceitos fundamentais de programação orientada a objetos, incluindo classes, objetos, composição, vetores de objetos, métodos, estruturas condicionais e estruturas de repetição.

## Objetivos
- Registrar receitas e despesas.
- Organizar movimentações por categoria.
- Consultar informações financeiras.
- Gerar relatórios de gastos.
- Auxiliar o usuário no controle financeiro pessoal.
- Aplicar os conceitos estudados na disciplina.

## Primeiro Passos
### 1. Antes de começar a programar, atualize sua cópia local:
```bash
git pull origin main
```
Isso evita conflitos com alterações feitas por outros integrantes.

### 2. Entrar na pasta do código
```bash
cd src
```

### 3. Compilar o projeto
```bash
javac *.java
```
Se não aparecer nenhuma mensagem de erro, a compilação foi realizada com sucesso.

### 4. Executar o sistema
```bash
java Main
```
O menu principal será exibido no terminal.

### 5. Salvar alterações
Após concluir uma funcionalidade:
```bash
git add .
git commit -m "Descrição da alteração"
git push origin main
```

# Estrutura do Projeto

## Classes Principais

### Usuario

Representa o usuário do sistema.

**Atributos:**
- nome
- idade
- genero

### Conta
Representa uma conta financeira pertencente a um usuário.

**Atributos**
- Usuario
- status
- id
- saldo
- limite
- banco

**Composição**
- Uma conta pertence a um usuário.

### Categoria
Representa uma categoria de movimentação financeira.

**Atributos**
- nome
- tipo
- observacoes

### Movimentação
Representa uma movimentação financeira.

**Atributos**
- conta
- data
- id
- categoria
- valor
- observacoes

**Composição**
- Uma movimentação pertence a uma conta.
- Uma movimentação pertence a uma categoria.

### GerenciadorCategorias
Responsável pelo gerenciamento das categorias cadastradas.
**Funcionalidades:**
- Cadastro de categoria
- Listagem de categorias
- Busca de categoria
- Edição de categoria

# Diagrama de Classes

( INSERIR O DIAGRAMA QUANDO ESTIVER PRONTO)

---


