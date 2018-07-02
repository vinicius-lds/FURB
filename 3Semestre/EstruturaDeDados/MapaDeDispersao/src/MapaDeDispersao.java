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
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setInfo(dado);
        this.info[hash].inserir(no);
    }
    
    public void remover(int chave) {
        int hash = calcularHash(chave);
        if(this.info[hash] == null) {
            return;
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        this.info[hash].retirar(no);
    }
    
    public T buscar(int chave) {
        int hash = calcularHash(chave);
        if(this.info[hash] == null) {
            return null;
        }
        NoMapa<T> noAux = new NoMapa<>();
        noAux.setChave(chave);
        NoLista<NoMapa<T>> no = this.info[hash].buscar(noAux);
        if(no != null) {
            return no.getInfo().getInfo();
        }
        return null;
    }
    
    public static void main(String[] args) {
        MapaDeDispersao map = new MapaDeDispersao<>(7);
        map.inserir(150, "oi");
        map.inserir(2, "tchau");
        System.out.println(map.buscar(150));
        map.remover(150);
        
    }
    
}
