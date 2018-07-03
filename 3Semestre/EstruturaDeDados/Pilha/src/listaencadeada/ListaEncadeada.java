package listaencadeada;

/*/
 * @author vinic
/*/
public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    
    public ListaEncadeada() {
        this.primeiro = null;
    }
    
    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }
    
    public void inserir(T elemento) {
        NoLista<T> novo = new NoLista();
        novo.setInfo(elemento);
        NoLista velho = this.primeiro;
        this.primeiro = novo;
        this.primeiro.setProximo(velho);
    }
    
    public void exibir() {
        System.out.print("Elemenos da Lista: { ");
        NoLista atual = this.primeiro;
        while (atual != null) {            
            System.out.print(atual.getInfo()+ " ");
            atual = atual.getProximo();
        }
        System.out.println("}");
    }
    
    public boolean estaVazia() {
        return (this.primeiro == null) ? true : false;
    }
    
    public NoLista<T> buscar(T info) {
        NoLista<T> atual = this.primeiro;
        while (atual != null) {            
            if(atual.equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }
    
    public void retirar(T info) {
        
        NoLista<T> atual = this.primeiro;
        NoLista<T> anterior = null;
        NoLista<T> noLocalizado = null;
        while (atual != null) {            
            if(atual.getInfo().equals(info)) {
                noLocalizado = atual;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        
        if(noLocalizado != this.primeiro) {
            anterior.setProximo(atual.getProximo());
        } else {
            this.primeiro.setProximo(this.primeiro.getProximo());
        }
        
    }
    
    public int obterComprimento() {
        
        NoLista<T> atual = this.primeiro;
        int comprimento = 0;
        while (atual != null) {            
            comprimento++;
            atual = atual.getProximo();
        }
        return comprimento;
    
    }
    
    public NoLista<T> obterNo(int index) {
        
        if(index < 0) {
            throw new IndexOutOfBoundsException("O index é negativo! " + index);
        }
        NoLista<T> atual = this.primeiro;
        int currentIndex = 0;
        while (currentIndex < index) {
            if(atual == null) {
                throw new IndexOutOfBoundsException("O index é inválido! " + index);
            }
            atual = atual.getProximo();
            currentIndex++;
        }
        return atual;
        
    }
    
    public ListaEncadeada<T> criarSubLista(int inicio, int fim) {
        if((inicio < 0) || (inicio > fim)) {
            throw new IndexOutOfBoundsException();
        }
        
        ListaEncadeada<T> le = new ListaEncadeada<T>();
        NoLista<T> atual = this.primeiro;
        for (int i = 0; atual != null; i++) {
            if(i >= inicio && i <= fim) {
                le.inserir(atual.getInfo());
            }
            atual = atual.getProximo();
        }
        if(le.estaVazia()) {
            throw new IndexOutOfBoundsException();
        }
        return le;
    }
    
    @Override
    public String toString() {
        NoLista<T> atual = this.primeiro;
        String str = "";
        while (atual != null) {
            str += atual.getInfo() + ", ";
            atual = atual.getProximo();
        }
        return (str.equals("")) ? str : str.substring(0, str.length() - 2) + ".";
    }
    
    public static void main(String[] args) {
        
        ListaEncadeada<Integer> ints = new ListaEncadeada<>();
        
        for (int i = 0; i < 10; i++) {
            ints.inserir(i);
        }
        
        ints.exibir();
        ListaEncadeada<Integer> ints2 = ints.criarSubLista(2, 5);
        ints2.exibir();
        
    }
    
}
