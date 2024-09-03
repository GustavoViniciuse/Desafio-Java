//2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o 
//próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), 
//escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci 
//e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

import java.util.Scanner;

public class Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero = sc.nextInt();

        if (Fibonacci(numero)) {
            System.out.println("pertence a sequencia");
        } else {
            System.out.println("nao pertence a sequencia");
        }

        sc.close();
    }

    public static boolean Fibonacci(int numero) {
        int a = 0, b = 1, c = 0;
        if (numero == 0 || numero == 1) {
            return true;
        }

        while (c < numero) {
            c = a + b;
            a = b;
            b = c;
        }

        return c == numero;
    }

    
    
}