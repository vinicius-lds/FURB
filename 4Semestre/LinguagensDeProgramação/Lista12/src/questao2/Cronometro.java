package questao2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Cronometro extends Thread {
    
    private int segundos;
    
    public Cronometro(int segundos) {
        this.segundos = segundos;
        if(this.segundos > 0) {
            this.start();
        }
    }

    @Override
    public void run() {
        while(segundos > 0) {
            System.out.println(segundos + " segundos restantes.");
            segundos--;
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("O cronometro chegou a 0!");
    }
    
}
