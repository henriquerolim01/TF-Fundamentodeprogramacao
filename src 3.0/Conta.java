public class Conta {
    private Usuario usuario;
    private boolean status;
    private int id;
    private double saldo;
    private double limite;
    private String banco;

    public Conta() {

    }

    public Conta(Usuario usuario, boolean status, int id, double saldo, double limite, String banco) {
        this.usuario = usuario;
        this.status = status;
        this.id = id;
        this.saldo = saldo;
        this.limite = limite;
        this.banco = banco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public String getBanco() {
        return banco;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String toString() {
        return "Usuario: " + usuario + " Status: " + status + " ID: " + id + " Saldo: " + saldo + " Limite: " + limite
                + " Banco: " + banco;
    }

}
