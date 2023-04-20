package caio;

public class ListaNumeros {

    public static void main(String[] args) {
        int numero = 4; 
        int fatorial = calcularFatorial(numero); 
        int[] fatorialArray = criarArrayFatorial(fatorial); 
        System.out.println("Fatorial de " + numero + " é: " + fatorial);
        System.out.println("Números do fatorial em ordem decrescente:");
        exibirArrayFatorial(fatorialArray);
    }

    public static int calcularFatorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * calcularFatorial(num - 1);
        }
    }

    public static int[] criarArrayFatorial(int fatorial) {
        int[] fatorialArray = new int[fatorial];
        for (int i = 0; i < fatorial; i++) {
            fatorialArray[i] = fatorial - i;
        }
        return fatorialArray;
    }

    public static void exibirArrayFatorial(int[] fatorialArray) {
        for (int i = 0; i < fatorialArray.length; i++) {
            System.out.print(fatorialArray[i] + " ");
        }
        System.out.println();
    }
}
