package caio;

import java.util.*;

public class SepararNumerosPares {
    public static void main(String[] args) {
        List<Integer> numerosPares = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> numerosImpares = Arrays.asList(1, 3, 5, 7, 9);

        Stack<Integer> pilhaPares = new Stack<>();
        Stack<Integer> pilhaImpares = new Stack<>();

        for (int i = numerosPares.size() - 1; i >= 0; i--) {
            pilhaPares.push(numerosPares.get(i));
        }
        for (int i = numerosImpares.size() - 1; i >= 0; i--) {
            pilhaImpares.push(numerosImpares.get(i));
        }

        while (!pilhaPares.empty() || !pilhaImpares.empty()) {
            if (!pilhaPares.empty()) {
                System.out.print(pilhaPares.pop() + " ");
            }
            if (!pilhaImpares.empty()) {
                System.out.print(pilhaImpares.pop() + " ");
            }
        }
    }
}
