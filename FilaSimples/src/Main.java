public class Main {
    public static void main(String[] args) {
        double taxaChegada = 0.2;
        double taxaServico = 0.3;
        int tamanhoMaximo = 3;

        Simulador simulador = new Simulador(taxaChegada, taxaServico, tamanhoMaximo);
        simulador.simular();
    }
}
