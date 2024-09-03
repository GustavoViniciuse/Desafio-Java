//5) Escreva um programa que inverta os caracteres de um string.

//IMPORTANTE:
//a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
//b) Evite usar funções prontas, como, por exemplo, reverse;

import java.util.Scanner;

public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String input = sc.nextLine();
        String invertida = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }

        System.out.println("String invertida: " + invertida);

        sc.close();
    }
}
