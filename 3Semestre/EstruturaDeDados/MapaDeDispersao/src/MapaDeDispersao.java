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
        if(this.info[hash] == null) {
            this.info[hash] = new ListaEncadeada<>();
        }
        this.info[hash].inserir(new NoMapa<>(chave, dado));
    }
    
    public void remover(int chave) {
        this.info[calcularHash(chave)].retirar(new NoMapa<>(chave));
    }
    
    public T buscar(int chave) {
        int hash = calcularHash(chave);
        if(this.info[hash] == null) {
            return null;
        }
        NoMapa<T> noAux = new NoMapa<>(chave);
        NoLista<NoMapa<T>> noListaAux = this.info[hash].buscar(noAux);
        if(noListaAux == null) {
            return null;
        }
        noAux = noListaAux.getInfo();
        
        return noAux.getInfo();
    }
    
    public static void main(String[] args) {
        MapaDeDispersao map = new MapaDeDispersao<>(7);
        map.inserir(150, "oi");
        map.inserir(2, "tchau");
        map.buscar(150);
    }
    
}
