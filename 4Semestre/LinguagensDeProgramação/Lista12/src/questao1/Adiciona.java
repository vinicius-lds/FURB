package questao1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Adiciona extends Thread {

    private Buffer buffer;
    
    public Adiciona(Buffer buffer) {
        this.buffer = buffer;
        this.start();
    }
    
    @Override
    public void run() {
        while(true) {
            buffer.adiciona();
            try {
                sleep(Main.INTERVALO);
            } catch (InterruptedException ex) {
                Logger.getLogger(Subtrai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
