/*/
 * @author vinic
/*/
public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;
    
    public ListaDupla() {
        this.primeiro = null;
    }
    
    public NoListaDupla<T> getPrimeiro() {
        return this.primeiro;
    }
    
    public void inserir(T elemento) {
        NoListaDupla<T> novo = new NoListaDupla();
        novo.setInfo(elemento);
        NoListaDupla velho = this.primeiro;
        this.primeiro = novo;
        this.primeiro.setProximo(velho);
        if(velho != null) {
            velho.setAnterior(this.primeiro);
        }
    }
    
    private NoListaDupla<T> getUltimo() {
        NoListaDupla<T> atual = this.primeiro;
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        return atual;
    }
    
    public void exibirOrdemInversa() {
        
        NoListaDupla<T> atual = this.getUltimo();
        
        System.out.print("Elemenos da Lista: { ");
        while (atual != null) {
            System.out.print(atual.getInfo()+ " ");
            atual = atual.getAnterior();
        }
        System.out.println("}");
    }
    
    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = this.primeiro;
        while (atual != null) {
            if(atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }
    
    public void retirar(T info) {
        
        NoListaDupla<T> noLocalizado = this.buscar(info);
        
        if(noLocalizado != null) {
            if(!noLocalizado.equals(this.primeiro)) {
                noLocalizado.getAnterior().setProximo(noLocalizado.getProximo());
                if(noLocalizado.getProximo() != null) {
                    noLocalizado.getProximo().setAnterior(noLocalizado.getAnterior());
                } else {
                    noLocalizado.getAnterior().setProximo(null);
                }
            } else {
                this.primeiro = this.primeiro.getProximo();
                this.primeiro.setAnterior(null);
            }
        }
        
    }
    
    public void liberar() {
        NoListaDupla<T> atual = this.primeiro;
        NoListaDupla<T> proximo;
        
        while(atual != null) {
            proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual.setInfo(null);
            atual = proximo;
        }
    }
    
    @Override
    public String toString() {
        NoListaDupla<T> atual = this.primeiro;
        String str = "";
        while (atual != null) {
            str += atual.getInfo() + ", ";
            atual = atual.getProximo();
        }
        return (str.equals("")) ? str : str.substring(0, str.length() - 2) + ".";
    }

    public static void main(String[] args) {
        
        ListaDupla<Integer> ints = new ListaDupla<>();
        
        for (int i = 0; i < 10; i++) {
            ints.inserir(i);
        }
        
        ints.exibirOrdemInversa();
        ints.retirar(0);
        ints.exibirOrdemInversa();
        //ints.liberar();
        ints.exibirOrdemInversa();
        System.out.println(ints.toString());
        //System.out.println(ints.obterNo(15).getInfo());
        //System.out.println(ints.obterComprimento());
        
    }
    
}
