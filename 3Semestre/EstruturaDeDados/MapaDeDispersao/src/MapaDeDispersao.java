
/**
 * @author Vinícius Luis da Silva
 */
public class MapaDeDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDeDispersao(int tamanho) {
        this.info = new ListaEncadeada[tamanho];
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
    }

    public static void main(String[] args) {
        MapaDeDispersao map = new MapaDeDispersao<>(7);
        map.inserir(150, "no1");
        map.inserir(2, "no2");
        map.inserir(12, "no3");
        map.inserir(70, "no4");
        map.inserir(50, "no5");
        map.inserir(1500, "no6");
        map.inserir(1001, "no7");
        System.out.println(map.buscar(150));
        map.remover(150);
        System.out.println("Comprimento " + map.calcularQtdObjetos());
        map.realocarMapa(150);
        System.out.println(map.buscar(50));

    }

}
