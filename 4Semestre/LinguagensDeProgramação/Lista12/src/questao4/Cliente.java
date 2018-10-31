package questao4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Cliente extends Thread {
    
    private Conta conta;
    private String nome;
    
    public Cliente(Conta conta, String nome) {
        this.conta = conta;
        this.nome = nome;
        this.start();
    }

    @Override
    public void run() {
        Random r = new Random();
        long ms = r.nextInt(10) * 1000;
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean saque = r.nextBoolean();
        int valor = r.nextInt((int)conta.getSaldo()) + 1;
        if(saque) {
            conta.sacar(valor);
            System.out.println(nome + " sacou R$" + valor + ",00");
        } else {
            conta.depositar(valor);
            System.out.println(nome + " depositou R$" + valor + ",00");
        }
    }
    
}
