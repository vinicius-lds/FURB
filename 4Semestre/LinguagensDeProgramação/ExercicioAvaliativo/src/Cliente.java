
/**
 * @author Vinícius Luis da Silva && Carlos Henrique Ponciano da Silva
 */
public class Cliente extends Thread {

    private static int contador = 0;

    private String nome;
    private Barbearia barb;
    private boolean esperando = false;

    public Cliente(Barbearia b) {
        barb = b;
        nome = "Cliente " + (++contador);
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public synchronized void run() {
        if (barb.addCliente(this)) {
            System.out.println(this + " sentou");
            esperar();
        } else {
            System.out.println(this + " foi embora!");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean chamar() {
        if (esperando) {
            esperando = false;
            notify();
            return true;
        } else {
            return false;
        }
    }

    public synchronized void esperar() {
        esperando = true;
        try {
            while (esperando) {
                wait();
            }
        } catch (Exception e) {
//            if(esperando) {
//                esperando = false;
//            } else {
//                Thread.currentThread().interrupt();
//            }
        }
        esperando = false;
    }

}
