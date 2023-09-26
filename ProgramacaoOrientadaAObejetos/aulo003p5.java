package POO;

import java.util.Scanner;

public class aulo003p5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o tamanho do primeiro lado: ");
        int lado1 = input.nextInt();

        System.out.print("Digite o tamanho do segundo lado: ");
        int lado2 = input.nextInt();

        System.out.print("Digite o tamanho do terceiro lado: ");
        int lado3 = input.nextInt();

        if (verificarTriangulo(lado1, lado2, lado3)) {
            exibirClassificacaoTriangulo(lado1, lado2, lado3);
        } else {
            System.out.println("Os valores informados não formam um triângulo.");
        }
    }

    public static boolean verificarTriangulo(int lado1, int lado2, int lado3) {
        return (lado1 < lado2 + lado3) && (lado2 < lado1 + lado3) && (lado3 < lado1 + lado2);
    }

    public static void exibirClassificacaoTriangulo(int lado1, int lado2, int lado3) {
        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("Triângulo Equilátero");
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            System.out.println("Triângulo Isósceles");
        } else {
            System.out.println("Triângulo Escaleno");
        }
    }
}