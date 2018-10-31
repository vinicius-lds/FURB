package questao3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Impressora extends Thread {

    private Servidor servidor;
    private String nomeImpressora;

    public Impressora(Servidor servidor, String nomeImpressora) {
        this.servidor = servidor;
        this.nomeImpressora = nomeImpressora;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            if (servidor.dec()) {
                try {
                    System.out.println("Está sendo imprimido um arquivo");
                    sleep(Main.TEMPO_IMPRESSAO);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Impressora.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Uma impressora parou");
                servidor.lock(this);
            }
        }
    }

}
