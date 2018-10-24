/**
 * @author Vinícius Luis da Silva && Carlos Henrique Ponciano da Silva
 */
public class Barbeiro extends Thread {

    private Barbearia barb;

    public Barbeiro(Barbearia barb) {
        this.barb = barb;
    }

    public synchronized void acordar() {
        this.notify();
    }

    @Override
    public synchronized void run() {
        Cliente c;
        while (true) {
            c = barb.getProximo();
            if (c == null) {
                System.out.println("O barbeiro foi dormir");
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("O barbeiro acordou");
            } else {
                System.out.println(c + " esta cortando o cabelo");
                try {
                    sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(c + " terminou de cortar o cabelo");
            }
        }
    }

}
