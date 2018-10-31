package questao3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Servidor {

    private int count = 0;

    /**
     * @return se foi possivel retirar da fila
     */
    public boolean dec() {
        boolean canDec;
        synchronized (this) {
            canDec = count > 0;
            if (canDec) {
                count--;
                notifyAll();
            }
        }
        return canDec;
    }

    /**
     * @return se foi ppossivel adicionar a fila
     */
    public boolean inc() {
        boolean canAdd;
        synchronized (this) {
            canAdd = count < 3;
            if (canAdd) {
                count++;
                notifyAll();
            }
        }
        return canAdd;
    }

    public void lock(Object o) {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Computador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
