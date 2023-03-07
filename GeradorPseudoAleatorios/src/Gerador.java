import java.util.ArrayList;

public class Gerador {
    public static ArrayList<Double> gerador(long seed, long a, long c, long m, int num_aleatorios) {
        long x = seed;
        ArrayList<Double> numeros_aleatorios = new ArrayList<Double>();
        for (int i = 0; i < num_aleatorios; i++) {
            x = (a*x + c) % m;
            double num_aleatorio = (double) x / m;
            numeros_aleatorios.add(num_aleatorio);
        }
        return numeros_aleatorios;
    }
}
