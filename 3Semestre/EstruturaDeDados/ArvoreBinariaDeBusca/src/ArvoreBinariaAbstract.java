

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return (this.raiz == null);
    }

/*    
    public boolean pertence(T info) {
        return this.pertence(this.raiz, info);
    }
*/
    
    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        } else {
            return (no.getInfo() == info)
                    || this.pertence(no.getEsquerda(), info)
                    || this.pertence(no.getDireita(), info);
        }
    }

    @Override
    public String toString() {
        return this.arvorePre(getRaiz());
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        } else {
            return "<" + no.getInfo().toString()
                    + this.arvorePre(no.getEsquerda())
                    + this.arvorePre(no.getDireita())
                    + ">";
        }
    }

    public int contarNos() {
        return this.contarNos(this.getRaiz());
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + this.contarNos(no.getEsquerda()) + this.contarNos(no.getDireita());
        }
    }
    
    public abstract NoArvoreBinaria<T> buscar(T info);
    public boolean pertence(T info) {
        return this.buscar(info) == null;
    }
    
}
