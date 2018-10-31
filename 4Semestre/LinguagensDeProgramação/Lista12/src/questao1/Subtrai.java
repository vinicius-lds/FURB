package questao1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Subtrai extends Thread {

    private Buffer buffer;
    
    public Subtrai(Buffer buffer) {
        this.buffer = buffer;
        this.start();
    }
    
    @Override
    public void run() {
        while(true) {
            buffer.subtrai();
            try {
                sleep(Main.INTERVALO);
            } catch (InterruptedException ex) {
                Logger.getLogger(Subtrai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
