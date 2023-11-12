package Apresentacao;

import java.util.Scanner;

public class ClienteApresentacaoSaldo {
    public static Scanner in = new Scanner(System.in);

    public float obterValorAdicionar() {
        System.out.println("Informe o valor a adicionar: ");
        return in.nextFloat();
    }
}