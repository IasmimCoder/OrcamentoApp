package view;

import java.util.Scanner;

public class Forms {

    Scanner input = new Scanner(System.in);

    public int inserirTipo() {
        System.out.println("Informe o tipo: \n");
        System.out.println("[1] ENTRADA\n[2] SAÍDA");
        System.out.print("Sua resposta:");

        return input.nextInt();
    }
}
