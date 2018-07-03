
public class PilhaVetor<T> implements Pilha<T> {

    private T info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[this.limite];
        this.tamanho = 0;
    }

    @Override
    public void push(T valor) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        } else {
            this.info[this.tamanho] = valor;
            this.tamanho++;
        }
    }

    @Override
    public T pop() {
        T valor = this.peek();
        this.tamanho--;
        this.info[this.tamanho] = null;
        return valor;
    }

    @Override
    public T peek() {
        if (this.tamanho == 0) {
            throw new PilhaVaziaException();
        }
        return this.info[this.tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return (this.tamanho == 0);
    }

    @Override
    public void liberar() {
        for (int i = this.tamanho - 1; i >= 0; i++) {
            this.info[i] = null;
        }
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = this.tamanho - 1; i >= 0; i--) {
            str += this.info[i].toString() + ", ";
        }
        return (str.equals("")) ? "" : str.substring(0, str.length() - 2);
    }

    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i < p.tamanho; i++) {
            this.push(p.info[i]);
        }
    }

    public static void main(String[] args) {

        PilhaVetor<Integer> pv = new PilhaVetor<Integer>(15);
        PilhaVetor<Integer> pv1 = new PilhaVetor<Integer>(15);
        
        for (int i = 1; i < 8; i++) {
            pv.push(i);
        }
        for (int i = 8; i < 10; i++) {
            pv1.push(i);
        }

        System.out.println(pv.toString());
        System.out.println(pv1.toString());

        pv.concatenar(pv1);

        System.out.println(pv.toString());
        System.out.println(pv1.toString());

    }

}
