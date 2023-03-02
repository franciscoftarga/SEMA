import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private Queue<Double> fila;
    private int tamanhoMaximo;

    public Fila(int tamanhoMaximo) {
        fila = new LinkedList<>();
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public void adicionarCliente(double tempoAtual) {
        fila.add(tempoAtual);
    }

    public double removerCliente() {
        return fila.remove();
    }

    public boolean estaCheia() {
        return fila.size() >= tamanhoMaximo;
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }
}
