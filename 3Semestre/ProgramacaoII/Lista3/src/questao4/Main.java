package questao4;

import java.util.Scanner;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        Frase frase = new Frase(scanner.nextLine());
        System.out.println(frase.getPalavras());
        
    }
    
}


