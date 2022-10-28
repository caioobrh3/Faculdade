package br.ucsal;

import java.util.Scanner;

public class Quetao2prova {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double desconto;
        int soma, opcao, opcao2;
        System.out.println("Bem vindo a loja de Eltrodomesticos!");
        System.out.println("Qual dos aparelhos você quer?");
        System.out.println("TV valor: 600$");
        System.out.println("Geladeira valor: 800$");
        System.out.println("Microondas valor: 100$");
        System.out.println("computador valor: 50$");
        System.out.println("Digite o valor do produto:");
        opcao = sc.nextInt();
        System.out.println("Digite o valor do segundo produto:");
        opcao2 = sc.nextInt();
        soma =  (opcao + opcao2);
        if (soma >= 200 && soma <=1000){
            desconto = soma / 5;
            System.out.println("Você recebou um desconto de 20% então o valor final fica:"+(soma - desconto));

        }
        if (soma >= 1000) {
            desconto = soma / 4;
            System.out.println("Você recebeu um desconto de 25%, então o valor final fica:"+(soma - desconto));
        }
        if (soma <= 200) {
            System.out.println("Você não tem direito a um desconto, o total ficou:"+soma);
        }

        sc.close();






    }

}