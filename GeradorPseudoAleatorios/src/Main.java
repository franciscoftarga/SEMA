import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Gerador gerador = new Gerador();
        long X0 = 666666;
        long a = 12324;
        long c = 342423;
        long M = (long) Math.pow(2, 35);

        ArrayList<Double> numeros_aleatorios = Gerador.gerador(X0, a, c, M, 1000);
        System.out.println(numeros_aleatorios);
    }
}