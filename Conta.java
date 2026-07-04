// Classe responsável por representar uma conta financeira do usuário
public class Conta {

    // Atributos da conta
    private Usuario usuario;
    // Indica se a conta está ativa (true) ou inativa (false)
    private boolean status;
    private int id;
    private double saldo;
    private double limite;
    private String banco;
    
    // Construtor vazio
    public Conta(){

    }

    // Construtor para inicializar todos os atributos
    public Conta(Usuario usuario, boolean status, int id, double saldo, double limite, String banco){
        this.usuario = usuario;
        this.status = status;
        this.id = id;
        this.saldo = saldo;
        this.limite = limite;
        this.banco = banco;
    }

    // Métodos Getters
    public Usuario getUsuario(){
        return usuario;
    }
    public boolean getStatus(){
        return status;
    }
    public int getId(){
        return id;
    }
    public double getSaldo(){
        return saldo;
    }
    public double getLimite(){
        return limite;
    }
    public String getBanco(){
        return banco;
    }

    // Métodos Setters
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public void setStatus (boolean status){
        this.status = status;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setLimite(double limite){
        this.limite = limite;
    }
    public void setBanco(String banco){
        this.banco = banco;
    }

// Retorna as informações da conta em formato de texto
    @Override
    public String toString() {
        return "Usuário: " + usuario +
                "\nStatus: " + status +
                "\nID: " + id +
                "\nSaldo: " + saldo +
                "\nLimite: " + limite +
                "\nBanco: " + banco;
    }
    
}
