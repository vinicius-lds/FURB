/**
 *
 * @author Vinícius Luis da Silva
 */
public class NoLista<T> {
    
    private T info;
    private NoLista<T> proximo;
    
    public T getInfo() {
        return this.info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
    
    public NoLista<T> getProximo() {
        return this.proximo;
    }
    
    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public boolean equals(Object obj) {
        return this.info.equals(obj);
    }
    
}
