/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinic
 */
public class ListaEstatica {
    private int[] info;
    private int tamanho;
    private final byte TAMANHO_INICIAL = 10;
    
    public ListaEstatica() {
        info = new int[TAMANHO_INICIAL]; 
        tamanho = 0;
    }
    
    public void inserir(int valor) {
        if(this.info.length == this.tamanho) {
            this.redimensionar();
        }
        this.info[this.tamanho] = valor;
        this.tamanho++;
    }
    
    private void redimensionar() {
        int[] novo = new int[this.tamanho + TAMANHO_INICIAL];
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
    
    public int buscar(int valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if(info[i] == valor) { return i; }
        }
        return -1;
    }
    
    public void retirar(int valor) {
        if(this.buscar(valor) > -1) {
            for (int i = this.buscar(valor); i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            this.tamanho--;
            this.info[this.tamanho] = 0;
        }
    }
    
    public void liberar() {
        this.info = new int[TAMANHO_INICIAL];
        this.tamanho = 0;
    }
    
    public int obterElemento(int i) {
        if(i >= this.tamanho || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.info[i];
    }
    
    public void inserirOrdenado(int valor) {
        
        if(this.tamanho + 1 > this.info.length) {
            redimensionar();
        }
        
        boolean inserido = false;
        int aux = 0;
        int aux2;
        for (int i = 0; i < this.tamanho; i++) {
            if(inserido) {
                aux2 = this.info[i];
                this.info[i] = aux;
                continue;
            }
            if((this.info[i] > valor) && !inserido) {
                aux = this.info[i];
                this.info[i] = valor;
                inserido = true;
                this.tamanho++;
            }
        }
        
        
    }
    
    public boolean estaVazia() {
        return (this.tamanho == 0) ? true : false;
    }
    
    public int getTamanho() {
        return this.tamanho;
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
        
        int backup;
        
        while(esquerda < meio) {
            backup = this.info[esquerda];
            this.info[esquerda] = this.info[direita];
            this.info[direita] = backup;
        
            esquerda++;
            direita--;
        }
        
    }
    
    public static void main(String[] args) {
    
        ListaEstatica ints = new ListaEstatica();
        
        ints.inserir(20);
        ints.inserir(25);
        ints.inserir(30);
        
        ints.exibir();
        ints.inserirOrdenado(22);
        ints.exibir();
        
    }
            
}
