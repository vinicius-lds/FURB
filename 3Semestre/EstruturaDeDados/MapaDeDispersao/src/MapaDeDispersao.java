/**
 * @author Vinícius Luis da Silva
 */
public class MapaDeDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;
    private final double FATOR_DE_CARGA_MAXIMO = 0.75;
    private final double FATOR_DE_CARGA_MINIMO = 0.6;

    public MapaDeDispersao(int tamanho) {
        this.info = new ListaEncadeada[(tamanho < 2) ? 2 : tamanho];
    }

    public MapaDeDispersao() {
        this.info = new ListaEncadeada[2];
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
        if(this.getFatorCarga() > this.FATOR_DE_CARGA_MAXIMO) {
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
        if(this.getFatorCarga() < this.FATOR_DE_CARGA_MINIMO) {
            this.realocarMapa(this.calcularPrimoAnterior());
        }
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
        int n = this.info.length + 1;
        for (;;n++) {
            if(isPrimo(n)) {
                break;
            }
        }
        return n;
    }
    
    private int calcularPrimoAnterior() {
        int n = this.info.length - 1;
        for (;;n--) {
            if(isPrimo(n)) {
                if(n < 2) {
                    return this.info.length + 1;
                }
                break;
            }
        }
        return n;
    }
    
    /***
     * Verfica se um nomero é primo
     * @param n número que será testado
     * @return true se n for primo<br><B>BUG: retorna true quando o número é menor que 2</B>
     */
    private boolean isPrimo(int n) {
        double aux = ((Integer)n).doubleValue();
        for (int i = 2; i < (n / 2); i++) {
            if((aux % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public double getFatorCarga() {
        return ((Integer)this.calcularQtdObjetos()).doubleValue() / this.info.length;
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

    public double getFatorDeCargaMaximo() {
        return FATOR_DE_CARGA_MAXIMO;
    }

    public double getFatorDeCargaMinimo() {
        return FATOR_DE_CARGA_MINIMO;
    }
    
    public static void main(String[] args) {
        MapaDeDispersao map = new MapaDeDispersao<>();
        System.out.println(map.info.length);
        map.inserir(150, "no1");
        map.inserir(2, "no2");
        map.inserir(12, "no3");
        map.inserir(70, "no4");
        map.inserir(50, "no5");
        map.inserir(1500, "no6");
        map.inserir(1001, "no7");
        System.out.println(map.info.length);
        map.remover(150);
        map.remover(2);
        map.remover(12);
        map.remover(70);
        map.remover(50);
        map.remover(1500);
        map.remover(1001);
        System.out.println(map.info.length);
    }

}
