/**
 * @author Vinícius Luis da Silva && Carlos Henrique Ponciano da Silva
 */
public class Cliente extends Thread {

    private static int contador = 0;
    
    private String nome;
    private Barbearia barb;

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
        if(barb.addCliente(this)) {
            System.out.println(this + " sentou");
        } else {
            System.out.println(this + " foi embora!");
        }
    }
    
    public synchronized void chamar() {
        
    }
    
}
