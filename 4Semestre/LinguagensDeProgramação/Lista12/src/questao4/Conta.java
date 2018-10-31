package questao4;

/**
 * @author Vinícius Luis da Silva
 */
public class Conta {
    
    private Banco banco;
    private double saldo;
    private String nome;
    
    public Conta(Banco banco, String nome) {
        this.banco = banco;
        this.nome = nome;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public synchronized double sacar(int quantia) {
        this.saldo -= quantia;
        return this.saldo;
    }
    
    public synchronized void depositar(int quantia) {
        this.saldo += quantia;
    }
    
    public synchronized void atualizar() {
        this.saldo += this.saldo * 0.01;
        System.out.println(nome + " foi atualizada. Novo saldo: R$" + saldo);
    }
    
}
