
/**
 * @author Vinícius Luis da Silva
 */
public class MapaDeDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;
    private double fatorDeCarga;

    public MapaDeDispersao(int tamanho) {
        this.info = new ListaEncadeada[tamanho];
        this.fatorDeCarga = 0.75;
    }

    public MapaDeDispersao() {
        this.info = new ListaEncadeada[1];
        this.fatorDeCarga = 0.75;
    }
    
    private int calcularHash(int chave) {
        return chave % info.length;
    }

    public void inserir(int chave, T dado) {
        int hash = calcularHash(chave);
        if (this.info[hash] == null) {
            this.info[hash] = new ListaEncadeada<>();
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setInfo(dado);
        this.info[hash].inserir(no);
        if(this.getFatorCarga() > this.fatorDeCarga) {
            this.realocarMapa(this.calcularProximoPrimo());
        }
    }

    public void remover(int chave) {
        int hash = calcularHash(chave);
        if (this.info[hash] == null) {
            return;
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        this.info[hash].retirar(no);
    }

    public T buscar(int chave) {
        int hash = calcularHash(chave);
        if (this.info[hash] == null) {
            return null;
        }
        NoMapa<T> noAux = new NoMapa<>();
        noAux.setChave(chave);
        NoLista<NoMapa<T>> no = this.info[hash].buscar(noAux);
        if (no != null) {
            return no.getInfo().getInfo();
        }
        return null;
    }

    public int calcularQtdObjetos() {
        int qtdObjetos = 0;
        for (int i = 0; i < this.info.length; i++) {
            if (this.info[i] != null) {
                qtdObjetos += this.info[i].obterComprimento();
            }
        }
        return qtdObjetos;
    }

    public void realocarMapa(int tamanho) {
        ListaEncadeada<NoMapa<T>>[] aux = new ListaEncadeada[tamanho];
        int novaPosicao;
        NoLista<NoMapa<T>> no;
        for (int i = 0; i < this.info.length; i++) {
            if (this.info[i] != null) {
                no = this.info[i].getPrimeiro();
                while (no != null) {
                    novaPosicao = no.getInfo().getChave() % tamanho;
                    if (aux[novaPosicao] == null) {
                        aux[novaPosicao] = new ListaEncadeada<NoMapa<T>>();
                    }
                    aux[novaPosicao].inserir(no.getInfo());
                    no = no.getProximo();
                }
            }
        }
        this.info = aux;
    }

    private int calcularProximoPrimo() {
        int i = this.info.length + 1;
        int j;
        do {
            for (j = 2; (j < i) && (i % j != 0); j++) {}
            i++;
        } while(i == j);
        return i;
    }

    public double getFatorCarga() {
        System.out.println(this.info.length);
        return ((Integer)this.calcularQtdObjetos()).doubleValue() / this.info.length;
    }

    public void setFatorDeCarga(double fatorDeCarga) {
        if(this.fatorDeCarga < 0) {
            throw new IllegalArgumentException("O Fator de Carga deve ser positivo!");
        }
        this.fatorDeCarga = fatorDeCarga;
    }
    
    public void garantirTamanho(int tamanho) {
        this.realocarMapa(tamanho);
    }
    
    public ListaEncadeada<T> hashToList() {
        ListaEncadeada<T> list = new ListaEncadeada<>();
        NoLista<NoMapa<T>> no;
        for (int i = 0; i < this.info.length; i++) {
            if(info[i] != null) {
                no = info[i].getPrimeiro();
                while(no != null) {
                    list.inserir(no.getInfo().getInfo());
                    no = no.getProximo();
                }
            } 
        }
        return list;
    }

}
