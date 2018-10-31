package questao3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Computador extends Thread {

    private Servidor servidor;
    private int nCopias;
    private String nomeComputador;

    public Computador(Servidor servidor, int nCopias, String nomeComputador) {
        this.servidor = servidor;
        this.nCopias = nCopias;
        this.nomeComputador = nomeComputador;
        this.start();
    }

    @Override
    public void run() {
        while (nCopias > 0) {
            if (servidor.inc()) {
                System.out.println(nomeComputador + " conseguiu adicionar um arquivo na fila. Restantes: " + (--nCopias));
            } else {
                System.out.println(nomeComputador + " parou pois não há espaço na fila");
                servidor.lock(this);
            }
        }
    }

}
