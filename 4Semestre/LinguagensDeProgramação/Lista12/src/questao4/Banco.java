package questao4;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vinícius Luis da Silva
 */
public class Banco extends Thread {
    
    private ArrayList<Conta> contas = new ArrayList<>();
    
    public Banco() {
        this.start();
    }

    @Override
    public void run() {
        this.iniciarContas();
        Random r = new Random();
        long ms = r.nextInt(10) * 1000;
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Conta conta : contas) {
            conta.atualizar();
        }
    }

    private void iniciarContas() {
        Conta conta;
        Cliente cliente;
        int nContas = new Random().nextInt(10000) + 1;
        this.contas = new ArrayList<>(nContas);
        for (int i = 0; i < nContas; i++) {
            conta = new Conta(this, "Conta" + (i + 1));
            cliente = new Cliente(conta, "Cliente" + (i + 1));
            conta.depositar(new Random().nextInt(50000) + 1);
            contas.add(conta);
        }
        System.out.println(nContas + " contas iniciadas.");
    }
    
}
