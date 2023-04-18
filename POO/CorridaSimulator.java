package trabalho;
import java.util.Random;

public class CorridaSimulator {
    private static final int VELOCIDADE_MAXIMA = 3; 
    private static final int DISTANCIA_MAXIMA = 30; 
    private static final char VEICULO1 = 'A'; 
    private static final char VEICULO2 = 'B'; 

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
            System.out.println("Empate! Ambos os veículos ultrapassaram a distancia maxima.");
        } else if (distanciaVeiculo1 >= DISTANCIA_MAXIMA) {
            System.out.println("O veiculo A venceu a corrida!");
        } else {
            System.out.println("O veiculo B venceu a corrida!");
        }
    }

    // Simular corrida
    private static void simularPasso() {
        Random random = new Random();
        int velocidadeVeiculo1 = random.nextInt(VELOCIDADE_MAXIMA) + 1;
        int velocidadeVeiculo2 = random.nextInt(VELOCIDADE_MAXIMA) + 1;

        distanciaVeiculo1 += velocidadeVeiculo1;
        distanciaVeiculo2 += velocidadeVeiculo2;

        // Imprimir a pista atualizada
        System.out.println(obterPista());
    }


    private static String obterPista() {
        StringBuilder pista = new StringBuilder();
        for (int i = 0; i < DISTANCIA_MAXIMA; i++) {
            if (i == distanciaVeiculo1) {
                pista.append(VEICULO1);
            } else if (i == distanciaVeiculo2) {
                pista.append(VEICULO2);
            } else {
                pista.append("-");
            }
        }
        return pista.toString();
    }
}
