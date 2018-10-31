/**
 * @author Vinícius Luis da Silva && Carlos Henrique Ponciano da Silva
 */
public class Barbearia {

    private final Cliente[] salaDeEspera = new Cliente[6];
    private int contador = 0;
    private final Barbeiro b = new Barbeiro(this);
    
    {
        b.start();
    }
    
    public synchronized boolean addCliente(Cliente c) {
        if(contador == salaDeEspera.length) {
            return false;
        } else {
            salaDeEspera[contador++] = c;
            if(contador == 1) {
                b.acordar();
            }
            return true;
        }
    } 

    public Cliente getProximo() {
        if(contador == 0) {
            return null;
        }
        return salaDeEspera[--contador];
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            Barbearia barb = new Barbearia();
            while(true) {
                new Cliente(barb).start();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {}
            }
        }).run();
    }
    
}
