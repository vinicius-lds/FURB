/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinic
 */
public abstract class ListaAbstract<T> {

    private T[] info;
    private int tamanho;
    
    
    public ListaAbstract() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    public abstract void inserir(T valor);
    public abstract int buscar(T valor);

    protected void redimensionar() {
        T[] novo = (T[]) new Object[this.tamanho + 10];
        for (int i = 0; i < this.tamanho; i++) {
            novo[i] = this.info[i];
        }
        this.info = novo;
    }

    public void exibir() {
        System.out.print("Lista: ");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print("{" + i + "->" + this.info[i] + "}");
        }
        System.out.println(";");
    }

    public void retirar(T valor) {
        if (this.buscar(valor) > -1) {
            for (int i = this.buscar(valor); i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            this.tamanho--;
            this.info[this.tamanho] = null;
        }
    }

    public void liberar() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }

    public T obterElemento(int i) {
        if (i >= this.tamanho || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.info[i];
    }

    public void inserirOrdenado(int valor) {
        
    }

    public boolean estaVazia() {
        return (this.tamanho == 0) ? true : false;
    }

    public int getTamanho() {
        return this.tamanho;
    }
    
    protected T[] getInfo() {
        return this.info;
    }
    
    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.tamanho; i++) {
            str += info[i] + ", ";
        }
        return (str.equals("")) ? "" : str.substring(0, str.length() - 2) + ".";
    }

    public void inverter() {
        /*
        E aux;
        for (int i = this.tamanho - 1, j = 0; i >= this.tamanho / 2; i--, j++) {
            aux = this.info[i];
            this.info[i] = this.info[j];
            this.info[j] = aux;
        }
         */

        int esquerda = 0;
        int direita = this.tamanho - 1;
        int meio = this.tamanho / 2;

        T backup;

        while (esquerda < meio) {
            backup = this.info[esquerda];
            this.info[esquerda] = this.info[direita];
            this.info[direita] = backup;

            esquerda++;
            direita--;
        }

    }

}
