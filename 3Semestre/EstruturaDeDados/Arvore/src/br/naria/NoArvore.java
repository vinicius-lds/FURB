package br.naria;

/**
 * @author vinic
 */
public class NoArvore<T> {

    private T info;
    private NoArvore<T> primeiro = null; //Primeira SubArvore
    private NoArvore<T> proximo = null; //Para seu irmao
    
    public NoArvore(T info) {
        this.info = info;
    }
    
    public void inserirFilho(NoArvore<T> filho) {
        this.proximo = this.primeiro;
        this.primeiro = filho;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }
    
    public T getInfo() {
        return info;
    }
    
    public NoArvore<T> getPrimeiro() {
        return this.primeiro;
    }
    
    public NoArvore<T> getProximo() {
        return this.proximo;
    }
    
}
