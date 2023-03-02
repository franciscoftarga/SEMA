import java.util.Random;
public class Simulador {
    private Fila fila;
    private double taxaChegada;
    private double taxaServico;
    private int tamanhoMaximo;

    private int clientesAtendidos;
    private double tempoTotalEspera;
    private double tempoTotalAtendimento;

    public Simulador(double taxaChegada, double taxaServico, int tamanhoMaximo) {
        this.taxaChegada = taxaChegada;
        this.taxaServico = taxaServico;
        this.tamanhoMaximo = tamanhoMaximo;

        fila = new Fila(tamanhoMaximo);
        clientesAtendidos = 0;
        tempoTotalEspera = 0.0;
        tempoTotalAtendimento = 0.0;
    }

    public double gerarTempoEntreChegadas() {
        Random geradorAleatorio = new Random();
        double u = geradorAleatorio.nextDouble();
        double tempoEntreChegadas = -(Math.log(1 - u) / taxaChegada);
        return tempoEntreChegadas;
    }

    public double gerarTempoDeServico() {
        Random geradorAleatorio = new Random();
        double u = geradorAleatorio.nextDouble();
        double tempoDeServico = -(Math.log(1 - u) / taxaServico);
        return tempoDeServico;
    }

    public void simular() {
        double tempoAtual = 0.0;
        double tempoProximoChegada = gerarTempoEntreChegadas();
        double tempoProximoAtendimento = Double.POSITIVE_INFINITY;

        while (clientesAtendidos < 2) {
            if (tempoProximoChegada < tempoProximoAtendimento) {
                // Chegada de um novo cliente
                if (!fila.estaCheia()) {
                    fila.adicionarCliente(tempoAtual);
                }
                tempoAtual += tempoProximoChegada;
                tempoProximoChegada = gerarTempoEntreChegadas();
            } else {
                // Atendimento de um cliente
                double tempoDeEspera = tempoAtual - fila.removerCliente();
                tempoTotalEspera += tempoDeEspera;
                tempoTotalAtendimento += tempoProximoAtendimento - tempoAtual;
                clientesAtendidos++;
                tempoAtual = tempoProximoAtendimento;
                tempoProximoAtendimento = Double.POSITIVE_INFINITY;
            }

            if (!fila.estaVazia() && tempoProximoAtendimento == Double.POSITIVE_INFINITY) {
                // Início de atendimento de um cliente da fila
                tempoProximoAtendimento = tempoAtual + gerarTempoDeServico();
            }
        }

        double tempoMedioEspera = tempoTotalEspera / clientesAtendidos;
        double tempoMedioSistema = tempoTotalAtendimento / clientesAtendidos + tempoMedioEspera;

        System.out.println("Simulação concluída:");
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Tempo médio de espera na fila: " + tempoMedioEspera);
        System.out.println("Tempo médio no sistema: " + tempoMedioSistema);
    }
}