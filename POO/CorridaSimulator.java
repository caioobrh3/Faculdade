package POO;
import java.util.Random;

public class CorridaSimulator {
    // Define a velocidade e distancia
    private static final int VELOCIDADE_MAXIMA = 3;
    private static final int DISTANCIA_MAXIMA = 30;

    // Nome de cada veículo
    private static final char VEICULO1 = 'A';
    private static final char VEICULO2 = 'B';

    // Posição atual de cada veículo
    private static int distanciaVeiculo1 = 0;
    private static int distanciaVeiculo2 = 0;

    public static void main(String[] args) {
        System.out.println("Simulador de Corrida\n");

        // Loop para simulação da corrida
        while (distanciaVeiculo1 < DISTANCIA_MAXIMA && distanciaVeiculo2 < DISTANCIA_MAXIMA) {
            simularPasso();
        }

        // Verificar o vencedor
        if (distanciaVeiculo1 >= DISTANCIA_MAXIMA && distanciaVeiculo2 >= DISTANCIA_MAXIMA) {
            System.out.println("Empate! Ambos os veículos ultrapassaram a distância máxima.");
        } else if (distanciaVeiculo1 >= DISTANCIA_MAXIMA) {
            System.out.println("O veículo A venceu a corrida!");
        } else {
            System.out.println("O veículo B venceu a corrida!");
        }
    }

    // Avanço dos veículos 
    private static void simularPasso() {
        Random random = new Random();

        // Escolher aleatoriamente a velocidade 
        int velocidadeVeiculo1 = random.nextInt(VELOCIDADE_MAXIMA) + 1;
        int velocidadeVeiculo2 = random.nextInt(VELOCIDADE_MAXIMA) + 1;

        // Atualizar a posição 
        distanciaVeiculo1 += velocidadeVeiculo1;
        distanciaVeiculo2 += velocidadeVeiculo2;

        // Imprimir a posição 
        System.out.println(obterPista());
    }

    // Representa a posição atual dos veículos 
    private static String obterPista() {
        StringBuilder pista = new StringBuilder();

        // Iterar sobre cada posição da pista
        for (int i = 0; i < DISTANCIA_MAXIMA; i++) {
            if (i == distanciaVeiculo1) {
                // Se for a do veículo 1
                pista.append(VEICULO1);
            } else if (i == distanciaVeiculo2) {
                // Se for a do veículo 2
                pista.append(VEICULO2);
            } else {
                // Adicionar um traço à pista quando n tem nada
                pista.append("-");
            }
        }

        // Retornar a pista atualizada
        return pista.toString();
    }
}
