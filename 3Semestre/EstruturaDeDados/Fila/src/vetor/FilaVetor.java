package vetor;



import interfacefila.Fila;

public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        super();
        this.limite = limite;
        this.info = (T[]) new Object[this.limite];
        this.inicio = 0;
        this.tamanho = 0;
    }

    //Indice em que ser� adicionado o pr�ximo elemento do fila
    private int getPosicaoProximoElemento() {
        return (getFinalDaFila() + 1 == this.limite) ? 0 : getFinalDaFila() + 1;
    }
    
    private int getFinalDaFila() {
        return (this.inicio + this.tamanho - 1) % this.limite;
    }

    @Override
    public void inserir(T valor) throws RuntimeException {

        if (this.limite == this.tamanho) {
            System.out.println(valor);
            System.out.println(this.tamanho + " " + this.limite);
            throw new RuntimeException();
        }
        //0,0,1,1,1
        this.info[this.getPosicaoProximoElemento()] = valor;
        this.tamanho++;

    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public T peek() throws RuntimeException {
        if (this.estaVazia()) {
            throw new RuntimeException();
        }
        return this.info[this.inicio];
    }

    @Override
    public T retirar() throws RuntimeException {
        if (this.estaVazia()) {
            throw new RuntimeException();
        }
        T aux = this.info[this.inicio];
        this.info[this.inicio] = null;
        this.inicio++;
        if (this.inicio == this.limite) {
            this.inicio = 0;
        }
        this.tamanho--;
        return aux;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[this.limite];
        this.inicio = 0;
        this.tamanho = 0;
    }

    public FilaVetor<T> criaFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<T>(this.limite + f2.limite);
        int aux = this.getFinalDaFila();
        for (int i = this.inicio; i != aux; i++) {
            if(i == this.limite) {
                i = 0;
            }
            f3.inserir(this.info[i]);
        }
        aux = f2.getFinalDaFila();  // f2.getFinalDaFila();
        for (int i = f2.inicio; i != aux; i++) {
            if(i == f2.limite) {
                i = 0;
            } 
            f3.inserir(f2.info[i]);
        }
        return f3;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = this.inicio; i != this.getFinalDaFila(); i++) {
            if(this.inicio == this.limite) {
                i = 0;
            }
            str += info[i] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        FilaVetor<Integer> fila = new FilaVetor<Integer>(10);
        FilaVetor<Integer> fila2 = new FilaVetor<Integer>(10);
        for (int i = 1; i <= 10; i++) {
            fila.inserir(i);
        }
        for (int i = 11; i <= 20; i++) {
            fila2.inserir(i);
        }
        fila.retirar();
        System.out.println(fila.toString());
        System.out.println(fila2.toString());
        FilaVetor<Integer> fila3 = fila.criaFilaConcatenada(fila2);
        System.out.println(fila3.toString());

    }

}
