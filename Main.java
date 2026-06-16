public class Main {
    public static void main(String [] args){
    Usuario p1 = new Usuario("Guilherme", 23, 'M');
    System.out.println(p1.toString());
    Conta c1 = new Conta (p1, true, 123, 10.000, 20.000, "Santander");
    System.out.println(c1.toString());

}
    

}
