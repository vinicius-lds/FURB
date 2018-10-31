package questao2;

import java.util.Scanner;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite um valor em segundos para o cronometro: ");
        try {
            new Cronometro(scan.nextInt());
        } catch (Exception e) {
            System.out.println("Valor inválido!");
        }
    }
    
}
