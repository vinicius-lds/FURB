package questao3;

import java.util.Random;

/**
 * @author Vinícius Luis da Silva
 */
public class Main {

    public static final long TEMPO_IMPRESSAO = 1000;

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        for (int i = 0; i < 3; i++) {
            new Impressora(servidor, "Impressora" + (i + 1));
        }
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            new Computador(servidor, r.nextInt(10) + 1, "Computador" + (i + 1));
        }
    }

}
